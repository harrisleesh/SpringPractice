package com.example.demo.user.controller;

import com.example.demo.user.controller.dto.UserRequestDto;
import com.example.demo.user.service.UserService;
import com.example.demo.user.controller.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    //Read
    @ResponseBody
    @GetMapping
    private List<UserResponseDto> getUserAll(){
        return userService.getUserAll();
    }

    //Read
    @ResponseBody
    @GetMapping("/{id}")
    private UserResponseDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    //Create
    @PostMapping
    private ResponseEntity<Long> createUser(@RequestBody UserRequestDto userRequestDto){
        return userService.createUser(userRequestDto);
    }

    //Update

    @PutMapping("/{id}")
    private ResponseEntity<Long> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){
        return userService.updateUser(id, userRequestDto);
    }

    //Delete
    @DeleteMapping("/{id}")
    private ResponseEntity<Long> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @PostMapping("/longin")


    @PostMapping("/logout")
}
