package com.example.demo.post.service;

import com.example.demo.post.model.Post;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PostService {
    private Map<Long, Post> posts = new HashMap<>();
    private Long nextId  = 0L;

    public Post create(CreatePostRequest createPostRequest){
        Post post = new Post();

        posts.put(post.getId(), post);
        nextId++;
        return post;
    }


    public Post createPost() {
        return null;
    }

    public Post updatePost(int id, String name) {
        return null;
    }

    public String deletePost(int id) {
        return null;
    }

    public Post getPost(int id) {
        return null;
    }
}
