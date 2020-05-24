package com.example.demo.post.service;

import com.example.demo.post.controller.dto.PostRequestDto;
import com.example.demo.post.controller.dto.PostResponseDto;
import com.example.demo.post.model.Post;
import com.example.demo.post.model.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponseDto> getPostAll() {
        return PostResponseDto.listOf(postRepository.findAll());
    }

    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));
        return PostResponseDto.from(post);
    }

    public Long createPost(PostRequestDto postRequestDto){
        return postRepository.save(postRequestDto.toEntity()).getId();
    }

    public Long updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));
        post.update(postRequestDto.toEntity());
        return post.getId();
    }

    public Long deletePost(Long id) {
        postRepository.deleteById(id);
        return id;
    }
}
