package com.company;

public class CardInsertedState extends State {

    protected CardInsertedState(Context context) {
        super(context);
    }

    @Override
    public void insertCard() {
        System.out.println("You have allready inserted a card");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected");
        context.changeState(new NoCardState(context)); // powstaje nowy stan -> NoCardState
    }

    @Override
    public void insertPin(int pin) {
        if (pin == 8888) {
            System.out.println("Correct PIN inserted");
            context.changeState(new PinInsertedState(context)); // powstaje nowy stan -> PinInsertedState
        } else {
            System.out.println("Incorrect PIN inserted");
            context.changeState(new NoCardState(context));   // powstaje nowy stan -> NoCardState
        }
    }

    @Override
    public void withdrawalCash(int amount) {
        System.out.println("Insert Pin first.");
    }
}
