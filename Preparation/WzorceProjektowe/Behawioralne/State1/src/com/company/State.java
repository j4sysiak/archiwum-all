package com.company;

public abstract class State {

    //Referencja do kontekstu, która będzie przechowywała konkretny stan
    protected Context context;

    protected State(Context context) {
        this.context = context;
    }

    //metody abstrakcyjne, żeby każda klasa nadpisała sobie te metody i robiła własną implementację

    public abstract void insertCard();
    public abstract void ejectCard();
    public abstract void insertPin(int pin);
    public abstract void withdrawalCash(int amount);
}
