package com.company;

public class CityDuck extends Duck {
    @Override
    public void swim() {
        System.out.println("CityDuck swim ...");
    }

    @Override
    public void kwak() {
        System.out.println("CityDuck kwak ....");
    }

    @Override
    public void fly() {
        System.out.println("CityDuck fly ....");
    }
}
