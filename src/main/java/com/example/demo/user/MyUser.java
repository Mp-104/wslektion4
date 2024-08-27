package com.example.demo.user;

public record MyUser(
        int id,
        String username,
        String password,
        boolean isEnabled
) {
}
