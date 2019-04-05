package com.aptest.controller;

import com.aptest.document.Role;
import com.aptest.document.User;
import com.aptest.mail.NotificationService;
import com.aptest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    NotificationService notificationService;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/user")
    public User addUSer(@RequestBody User user){

        User userExists = userRepository.findUserByUserName(user.getUserName());
        if(userExists ==null){

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       User user1 = userRepository.save(user);
            notificationService.sendAccountCreationConfirmation(user1);
        return user1;
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


        User user = userRepository.findUserByUserName(userName);
        Set<Role> roleSet = user.getRoles();
        List<Role> roles = new ArrayList<>(roleSet);
        


        HttpHeaders header = new HttpHeaders();
        header.add("Responded", "userExists");
        header.add("Role",roles.get(0).getName());


        if (user != null) {
            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {

                return new ResponseEntity<>(user, header, HttpStatus.OK);
            }
            else
                return null;
        }
        else
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id")String id){
         userRepository.deleteById(id);

    }


}
