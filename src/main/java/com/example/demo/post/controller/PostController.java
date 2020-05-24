package com.example.demo.post.controller;

import com.example.demo.post.controller.dto.PostRequestDto;
import com.example.demo.post.controller.dto.PostResponseDto;
import com.example.demo.post.service.PostService;
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
    @GetMapping("/{id}")
    private PostResponseDto getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    //Create
    @PostMapping
    private ResponseEntity<Long> createPost(@RequestBody PostRequestDto postRequestDto){
        return ResponseEntity.ok(postService.createPost(postRequestDto));
    }

    //Update

    @PutMapping("/{id}")
    private ResponseEntity<Long> updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto){
        return ResponseEntity.ok(postService.updatePost(id, postRequestDto));

    }

    //Delete
    @DeleteMapping("/{id}")
    private ResponseEntity<Long> deletePost(@PathVariable Long id){
        return ResponseEntity.ok(postService.deletePost(id));
    }
}
