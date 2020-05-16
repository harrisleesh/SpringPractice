package com.example.demo.user;

import com.example.demo.user.dto.CreateUserRequest;
import com.example.demo.user.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();
    private Long nextId = 0L;

    public UserResponse create(CreateUserRequest createUserRequest){
        User user = User.builder()
                .id(nextId)
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .name(createUserRequest.getName())
                .build();

        users.add(user);
        System.out.println(users.size());
        return getUserResponse(user);
    }

    public User getUser(int id) {
        return users.stream()
                .filter(user-> user.getId() == id)
                .findFirst().get();
    }

    public User updateUser(int id, String name) {
        User renameUser = users.stream()
                .filter(user-> user.getId() == id)
                .findFirst().get();
        renameUser.setName(name);
        return renameUser;
    }

    public String deleteUser(int id) {
        users = users.stream()
                .filter(user->user.getId() != id)
                .collect(Collectors.toList());
        return "Delete Success " + id;
    }
}
