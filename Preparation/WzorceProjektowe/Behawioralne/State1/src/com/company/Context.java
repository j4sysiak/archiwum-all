package com.company;

// jej zadaniem będzie oddelegowanie konkretnej implementacji do poszczególnego stanu

import lombok.Setter;

@Getter
@Setter
public class Context {
    public int availebleCash=2000;

    private State currentState;

    public Context() {
        // domyślny stan bankomatu - karta jeszcze nie została wprowadzona
        currentState = new NoCardState(this);
    }

    public void changeState(State newState) {
        currentState = newState;
    }

    public void insertCard() {
        currentState.insertCard();
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    public void insertPin(int pin) {
        currentState.insertPin(pin);
    }

    public void withdrawalCash(int amount) {
        currentState.withdrawalCash(amount);
    }

}
