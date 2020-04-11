package com.example.demo.service;

import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();
    private int id = 0;

    public User getUser(int id) {
        return users.stream()
                .filter(user-> user.getId() == id)
                .findFirst().get();
    }

    public User createUser(){
        User user = User.of(id++);
        users.add(user);
        System.out.println(users.size());
        return user;
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
