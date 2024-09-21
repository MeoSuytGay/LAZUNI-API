package com.example.SV_Market.controller;

import com.example.SV_Market.dto.UserDto;
import com.example.SV_Market.entity.User;
import com.example.SV_Market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User createUser(@RequestBody UserDto request) {
        return userService.createUser(request);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody UserDto request) {
        try {
            System.out.println(request.getUserId()+" "+request.getPassword());
            User updatedUser = userService.updatePassword(request.getUserId(), request.getPassword());
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}

