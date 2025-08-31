package com.company.lab;

public class Person {
    private final String name;
    private final Integer age;
    private final double height;

    public Person(String name, Integer age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public Integer getAge() {
        return age;
    }
}
