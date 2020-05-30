package com.example.demo.user.service;

import com.example.demo.user.controller.dto.UserResponseDto;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {


    private final UserRepository userRepository;

    public List<UserResponseDto> getUserAll() {
        userRepository.findAll();
        return null;
    }

    public UserResponseDto createUser(CreateUserRequest createUserRequest){
        User user = User.builder()
                .id(nextId++)
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .name(createUserRequest.getName())
                .build();

        users.add(user);
        System.out.println(users.size());
        return getUserResponse(user);
    }

    private UserResponseDto getUserResponse(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .build();
    }

    public UserResponseDto getUser(int id) {
        return getUserResponse(
                users.stream()
                .filter(user-> user.getId() == id)
                .findFirst().get()
        );
    }

    public UserResponseDto updateUser(int id, String name) {
        User renameUser = users.stream()
                .filter(user-> user.getId() == id)
                .findFirst().get();
//        users.remove(renameUser);
        renameUser.setName(name);
        //      users.add(renameUser);
        return getUserResponse(renameUser);
    }
    public String deleteUser(int id) {
        users = users.stream()
                .filter(user->user.getId() != id)
                .collect(Collectors.toList());
        return "Delete Success " + id;
    }

}
