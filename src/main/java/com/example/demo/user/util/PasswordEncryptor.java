package com.example.demo.user.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordEncryptor {
    private static final String SHA_256 = "SHA-256";

    public static String encrypt(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SHA_256);
            messageDigest.update(password.getBytes());
            return bytesToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("비밀번호 암호화 실패");
        }
    }

    private static String bytesToHex(byte[] digest) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }
}
