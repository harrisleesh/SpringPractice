package com.example.demo.user;

import org.junit.jupiter.api.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void passwordEncryption () throws NoSuchAlgorithmException {
        String password = "abc";
        MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes());
    }

}