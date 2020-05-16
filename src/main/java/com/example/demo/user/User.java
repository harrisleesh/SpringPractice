package com.example.demo.user;

import lombok.Builder;

import java.time.LocalDateTime;

public class User {

    private long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime nameModifiedaAt;

    @Builder
    public User(Long id, String email, String password, String name){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }
}