package com.example.graphql_user.controllers;

import com.example.graphql_user.dtos.UserDTO;
import com.example.graphql_user.dtos.UserGraphql;
import com.example.graphql_user.dtos.requests.LoginRequest;
import com.example.graphql_user.models.User;
import com.example.graphql_user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/graphql/{id}")
    public UserGraphql getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginRequest loginRequest) {
        return userService.authenticateUser(loginRequest);
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody LoginRequest newUser) {
        return userService.createUser(newUser);
    }

    @PutMapping("/update")
    public UserDTO updateUser(@RequestBody UserDTO userInfo) {
        return userService.updateUser(userInfo);
    }
}
