package com.example.demo.user.controller.dto;

import lombok.Builder;

public class UserResponseDto {
    private long id;
    private String email;
    private String password;
    private String name;

    @Builder
    public UserResponseDto(long id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
