package com.example.demo.post.controller.dto;

import com.example.demo.post.model.Post;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    public static List<PostResponseDto> listOf(List<Post> posts) {
        return posts.stream()
                .map(PostResponseDto::from)
                .collect(Collectors.toList());
    }

    public static PostResponseDto from(Post post) {
        return new PostResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt(), post.getLastUpdatedAt());
    }
}
