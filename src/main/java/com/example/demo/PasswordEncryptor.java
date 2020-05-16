package com.example.demo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordEncryptor {
    public static String encrypt(String password){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            return bytesToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e){
            throw new IllegalArgumentException("비밀번호 암호화 실패: 알 수 없는 암호화 알고리즘입니다.");
        }
    }
    public static String bytesToHex(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        for(byte b : bytes)
            builder.append(String.format("%02x", b));
        return builder.toString();
    }
}
