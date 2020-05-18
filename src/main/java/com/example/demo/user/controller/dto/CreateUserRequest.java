package com.example.demo.user.controller.dto;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    String email;
    String password;
    String name;

}
