package com.Adarsh.JournalAppnew.controller;

import com.Adarsh.JournalAppnew.entity.User;
import com.Adarsh.JournalAppnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> all = userService.getall();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create-admin-users")
    public void createAdminUsers(@RequestBody User user){
        userService.saveAdmin(user);
    }


}

