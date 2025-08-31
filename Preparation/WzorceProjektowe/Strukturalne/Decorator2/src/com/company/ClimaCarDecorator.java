package com.company;

public class ClimaCarDecorator extends CarDecorator {
    protected ClimaCarDecorator(ICar iCar) {
        super(iCar);
    }

    @Override
    public float price() {
        return super.price() + 2000f;
    }
}
