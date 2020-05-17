package com.example.demo.user.api;

import com.example.demo.user.service.UserService;
import com.example.demo.user.api.dto.UserResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    //Read
    @GetMapping("/users")
    private UserResponse getUser(@RequestParam(required = true) int id){
        return userService.getUser(id);
    }

    //Create
    @PostMapping("/users")
    private UserResponse postUser(){
//        return userService.createUser();
        return null;
    }

    //Update

    @PutMapping("/users")
    private UserResponse putUser(@RequestParam(required = true) int id, @RequestParam(required = true) String name){
        return userService.updateUser(id, name);
    }

    //Delete
    @DeleteMapping("/users")
    private String deleteUser(@RequestParam(required = true) int id){
        return userService.deleteUser(id);
    }
}
