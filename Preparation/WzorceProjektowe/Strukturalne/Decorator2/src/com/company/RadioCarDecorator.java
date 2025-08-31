package com.company;

public class RadioCarDecorator extends CarDecorator {
    protected RadioCarDecorator(ICar iCar) {
        super(iCar);
    }

    @Override
    public float price() {
        return super.price() + 1000f;
    }
}
