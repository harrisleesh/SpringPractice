package com.example.demo.user.dto;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    String email;
    String password;
    String name;

}
