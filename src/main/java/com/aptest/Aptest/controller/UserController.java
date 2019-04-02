package com.aptest.Aptest.controller;

import com.aptest.Aptest.document.Role;
import com.aptest.Aptest.document.User;
import com.aptest.Aptest.mail.NotificationService;
import com.aptest.Aptest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    NotificationService notificationService;

    @PostMapping("/user")
    public User addStudent(@RequestBody User user){
        User userExists = userRepository.findUserByUserName(user.getUserName());
        if(userExists ==null){
        User user1 = userRepository.save(user);
        String userId =  user1.getId();
            notificationService.sendAccountCreationConfirmation(user1);
        return userRepository.findById(userId).get();
        }
        return null;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();

    }

    @GetMapping("/user/{id}")
    public User getOneUser(@PathVariable("id")String id){
        return userRepository.findById(id).get();

    }

    //to do login functionality


    @GetMapping("/user")
    public ResponseEntity<User> loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        User userFound = userRepository.findByUserNameAndPassword(userName,password);
        Role role = userFound.getRole();


        HttpHeaders header = new HttpHeaders();
        header.add("Responded", "userExists");
        header.add("Role",role.getName());
        if(userFound== null){
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        } else{
            System.out.println("==============="+ userName +password);
            System.out.println("+++++++" + userFound.toString());
            return new ResponseEntity<>(userFound, header, HttpStatus.OK);
        }

//        return userFound;


    }

}
