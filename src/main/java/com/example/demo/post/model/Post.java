package com.example.demo.post.model;

import com.example.demo.user.model.User;
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
    private int likeCount;
    private User author;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
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
