package com.example.demo.post.service;

import com.example.demo.post.domain.Post;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PostService {
    private com.example.demo.user.PostService userService;
    private Map<Long, Post> posts = new HashMap<>();
    private Long nextId  = 0L;
    public PostService(com.example.demo.user.PostService userService){
        this.userService = userService;
    }

    public Post create(CreatePostRequest createPostRequest){
        User author = userService.get(createPostRequst.getAuthorId());
        Post post = Post.builder()
                .
                ;
        posts.put(post.getId(), post);
        nextId++;
        return post;
    }
}
