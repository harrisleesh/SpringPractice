package com.example.demo.user.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    @Builder
    public User(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
