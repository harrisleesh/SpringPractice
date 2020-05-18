package com.example.demo.post.controller;

import com.example.demo.post.service.PostService;
import com.example.demo.post.model.Post;
import org.springframework.web.bind.annotation.*;

public class PostController {
    private PostService postService;

    PostController(PostService postService){
        this.postService = postService;
    }

    //Read
    @GetMapping("/posts")
    private Post getPost(@RequestParam(required = true) int id){
        return postService.getPost(id);
    }

    //Create
    @PostMapping("/posts")
    private Post postPost(){
        return postService.createPost();
    }

    //Update

    @PutMapping("/posts")
    private Post putPost(@RequestParam(required = true) int id, @RequestParam(required = true) String name){
        return postService.updatePost(id, name);
    }

    //Delete
    @DeleteMapping("/posts")
    private String deletePost(@RequestParam(required = true) int id){
        return postService.deletePost(id);
    }
}
