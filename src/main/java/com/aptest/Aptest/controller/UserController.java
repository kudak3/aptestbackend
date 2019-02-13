package com.aptest.Aptest.controller;

import com.aptest.Aptest.document.User;
import com.aptest.Aptest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User addStudent(@RequestBody User user){
        User user1 = userRepository.save(user);
        String userId =  user1.getId();
        return userRepository.findById(userId).get();
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
    public User loginUser(@RequestBody User user){
        User userFound = userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
        return userFound;
    }

}
