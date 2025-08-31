package com.company;

public abstract class Duck {

    public abstract void swim();

    public abstract void kwak();

    // nie możemy zaimplementować metody fly w RubberDuck
    // nie jest w stanie reprezentować bazowej klasy Duck  - naruszamy zasadę LESKOV
    // throw new RuntimeException("RubberDuck cannot fly :) ...........!!!!");
     public abstract void fly();
}
