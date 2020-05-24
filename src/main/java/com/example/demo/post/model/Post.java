package com.example.demo.post.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long viewCount;
    private Long likeCount;
    private Long authorId;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime lastUpdatedAt;

    @Builder
    public Post(String title, String content, Long authorId){
        this.title=title;
        this.content=content;
        this.viewCount=0L;
        this.likeCount=0L;
        this.authorId =authorId;
        this.createdAt=LocalDateTime.now();
        this.lastUpdatedAt =LocalDateTime.now();
    }

    public void update(Post postToUpdate){
        this.title=postToUpdate.getTitle();
        this.content=postToUpdate.getContent();
        this.authorId=postToUpdate.getAuthorId();
    }
}
