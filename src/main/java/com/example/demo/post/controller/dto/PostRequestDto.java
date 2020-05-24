package com.example.demo.post.controller.dto;

import com.example.demo.post.model.Post;

public class PostRequestDto {
    private String title;
    private String content;
    private Long authorId;

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .authorId(authorId)
                .build();
    }
}
