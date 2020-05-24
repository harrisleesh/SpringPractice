package com.example.demo.post.service;

import com.example.demo.post.controller.dto.PostRequestDto;
import com.example.demo.post.controller.dto.PostResponseDto;
import com.example.demo.post.model.Post;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
    private Map<Long, Post> posts = new HashMap<>();
    private Long nextId  = 0L;

    public Long createPost(PostRequestDto postRequestDto){
        Post post = new Post();

        posts.put(post.getId(), post);
        nextId++;
        return post.getId();
    }

    public Long updatePost(Long id, PostRequestDto postRequestDto) {
        return null;
    }

    public Long deletePost(Long id) {
        return null;
    }

    public PostResponseDto getPost(Long id) {
        return null;
    }

    public List<PostResponseDto> getPostAll() {
        return null;
    }
}
