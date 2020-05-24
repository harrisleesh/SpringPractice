package com.example.demo.post.controller;

import com.example.demo.post.controller.dto.PostRequestDto;
import com.example.demo.post.controller.dto.PostResponseDto;
import com.example.demo.post.service.PostService;
import com.example.demo.post.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    PostController(PostService postService){
        this.postService = postService;
    }

    //Read
    @ResponseBody
    @GetMapping
    private List<PostResponseDto> getPostAll(){
        return postService.getPostAll();
    }

    //Read
    @ResponseBody
    @GetMapping
    private PostResponseDto getPostById(@RequestParam(required = true) Long id){
        return postService.getPost(id);
    }

    //Create
    @PostMapping
    private ResponseEntity<Long> createPost(@RequestBody PostRequestDto postRequestDto){
        return ResponseEntity.ok(postService.createPost(postRequestDto));
    }

    //Update

    @PutMapping
    private ResponseEntity<Long> updatePost(@RequestParam(required = true) Long id, @RequestBody PostRequestDto postRequestDto){
        return ResponseEntity.ok(postService.updatePost(id, postRequestDto));

    }

    //Delete
    @DeleteMapping
    private ResponseEntity<Long> deletePost(@RequestParam(required = true) Long id){
        return ResponseEntity.ok(postService.deletePost(id));
    }
}
