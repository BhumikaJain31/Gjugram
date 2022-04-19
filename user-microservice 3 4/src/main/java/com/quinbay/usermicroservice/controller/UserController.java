package com.quinbay.usermicroservice.controller;


import com.quinbay.usermicroservice.dto.User;
import com.quinbay.usermicroservice.entity.UserEntity;
import com.quinbay.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping(value = "/signup", consumes = "application/json")
    public User addUser(@RequestBody User user) {

        return userService.addUser(user);
    }


    @GetMapping(value = "/get-user-by-userid")
    public User byUserId(@RequestParam String id) {
        return userService.getUserByUserId(id);
    }

    @PutMapping(value = "/interest")
    public User updateInterest(@RequestBody User user) {
        return userService.updateInterest(user);
    }

    @PutMapping(value = "/edit-profile", consumes = "application/json")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }


    @GetMapping(value = "/authenticate")
    public User authenticate(@RequestParam String userName, @RequestParam String password) {
        return userService.authenticate(userName, password);
    }


}
