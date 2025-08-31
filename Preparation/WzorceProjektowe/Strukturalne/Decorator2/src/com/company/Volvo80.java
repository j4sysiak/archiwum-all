package com.company;

public class Volvo80 implements ICar {

    @Override
    public float price() {
        return 800000f;
    }

    @Override
    public String description() {
        return "Volvo80";
    }
}
