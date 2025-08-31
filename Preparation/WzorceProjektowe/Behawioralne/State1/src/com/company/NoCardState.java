package com.company;

public class NoCardState extends State {

    protected NoCardState(Context context) {
        super(context);
    }

    //zmieniaczka stanów
    @Override
    public void insertCard() {
        System.out.println("Card inserted");
        context.changeState(new CardInsertedState(context)); // powstaje nowy stan -> CardInsertedState
    }

    @Override
    public void ejectCard() {
        System.out.println("No card inserted yet");
    }

    @Override
    public void insertPin(int pin) {
        System.out.println("No card inserted yet");
    }

    @Override
    public void withdrawalCash(int amount) {
        System.out.println("No card inserted yet");
    }
}
