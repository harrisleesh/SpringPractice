package com.example.demo.post;

import com.example.demo.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Post {
    private Long id;
    private String content;
    private Long viewCount;
    private int likeCount;
    private User author;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public Post(Long id, String content, Long viewCount, User author){
        this.id=id;
        this.content=content;
        this.viewCount=viewCount;
        this.likeCount=0;
        this.author=author;
        this.createdAt=LocalDateTime.now();
        this.modifiedAt=LocalDateTime.now();
    }

}
