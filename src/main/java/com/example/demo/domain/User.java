package com.example.demo.domain;

import lombok.Getter;

public class User {

    private long id;

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    User(int id){
        this.id = id;
        this.name = "User" + id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static User of(int id){
        return new User(id);
    }
}
