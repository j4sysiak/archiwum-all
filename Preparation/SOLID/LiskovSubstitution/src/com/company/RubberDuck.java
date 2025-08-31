package com.company;

public class RubberDuck extends Duck {
    @Override
    public void swim() {
        System.out.println("RubberDuck swim ...");
    }

    @Override
    public void kwak() {
        System.out.println("RubberDuck kwak ...");
    }

    @Override
    public void fly() {
        // nie jest w stanie reprezentować bazowej klasy Duck
        // bo gumowa kaczka nie będzie latać
        // nie mozna w prawidłowy sposób zaimplementować tej metody
        throw new RuntimeException("RubberDuck cannot fly :) ...........!!!!");
    }
}
