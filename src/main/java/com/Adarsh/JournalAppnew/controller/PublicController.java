package com.Adarsh.JournalAppnew.controller;

import com.Adarsh.JournalAppnew.entity.User;
import com.Adarsh.JournalAppnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
class PublicController {

    @Autowired
    private UserService userService;
    @GetMapping("/health-check")
    String healthcheck(){
        return "Ok";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }
}

