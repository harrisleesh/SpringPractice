package com.example.demo.user.controller.dto;

import com.example.demo.user.model.User;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

public class UserResponseDto {
    private Long id;
    private String email;
    private String password;
    private String name;

    @Builder
    public UserResponseDto(Long id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public static List<UserResponseDto> listOf(List<User> users){
        return users.stream()
                .map(UserResponseDto::from)
                .collect(Collectors.toList());
    }

    public static UserResponseDto from(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .build();
    }
}
