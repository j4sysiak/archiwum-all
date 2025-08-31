package com.company;

public class Volvo40 implements ICar {

    @Override
    public float price() {
        return 300000f;
    }

    @Override
    public String description() {
        return "Volvo40";
    }
}
