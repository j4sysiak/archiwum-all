package com.company;

public class NoCashState extends State {

    protected NoCashState(Context context) {
        super(context);
    }

    @Override
    public void insertCard() {
        System.out.println("Sorry, we are out of cash");
    }

    @Override
    public void ejectCard() {
        System.out.println("Sorry, we are out of cash");
    }

    @Override
    public void insertPin(int pin) {
        System.out.println("Sorry, we are out of cash");
    }

    @Override
    public void withdrawalCash(int amount) {
        System.out.println("Sorry, we are out of cash");
    }
}
