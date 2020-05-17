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

    public UserResponse createUser(CreateUserRequest createUserRequest){
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

    private UserResponse getUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .build();
    }

    public UserResponse getUser(int id) {
        return getUserResponse(
                users.stream()
                .filter(user-> user.getId() == id)
                .findFirst().get()
        );
    }

    public UserResponse updateUser(int id, String name) {
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
