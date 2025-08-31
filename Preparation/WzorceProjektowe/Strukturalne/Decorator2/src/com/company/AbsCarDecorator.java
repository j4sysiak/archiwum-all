package com.company;

public class AbsCarDecorator extends CarDecorator {

    protected AbsCarDecorator(ICar iCar) {
        super(iCar);
    }

    @Override
    public float price() {
        return super.price() + 4000f;
    }
}
