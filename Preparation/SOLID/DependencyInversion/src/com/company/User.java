package com.company;

import lombok.*;

@Setter
@Getter
@Builder
public class User {
    public String name;
    public String email;
    public String password;
    public String phoneNumber;

    public static User create() {
        return User.builder()
                .build();
    }

    public static User create(String pass) {
        return User.builder()
                .password(pass)
                .build();
    }

    public static User create(String name, String email, String password, String phoneNumber) {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .build();
    }
}
