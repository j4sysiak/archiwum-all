package com.company;

public class Volvo60 implements ICar {

    @Override
    public float price() {
        return 600000f;
    }

    @Override
    public String description() {
        return "Volvo60";
    }
}
