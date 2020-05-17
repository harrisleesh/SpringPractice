package com.example.demo.post.api;

import com.example.demo.post.service.PostService;
import com.example.demo.user.domain.User;
import org.springframework.web.bind.annotation.*;

public class PostController {
    private PostService userService;

    UserController(PostService userService){
        this.userService = userService;
    }

    //Read
    @GetMapping("/users")
    private User getUser(@RequestParam(required = true) int id){
        return userService.getUser(id);
    }

    //Create
    @PostMapping("/users")
    private User postUser(){
        return userService.createUser();
    }

    //Update

    @PutMapping("/users")
    private User putUser(@RequestParam(required = true) int id, @RequestParam(required = true) String name){
        return userService.updateUser(id, name);
    }

    //Delete
    @DeleteMapping("/users")
    private String deleteUser(@RequestParam(required = true) int id){
        return userService.deleteUser(id);
    }
}
