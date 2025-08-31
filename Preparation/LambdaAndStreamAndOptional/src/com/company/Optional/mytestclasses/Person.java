package com.company.Optional.mytestclasses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
@Builder
public class Person {
    private String name;
    private int age;
    private String password;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }

    public static Person create(String name, int age, String password) {
        return Person.builder()
                .name(name)
                .age(age)
                .password(password)
                .build();
    }

    // normal constructors and setters
}
