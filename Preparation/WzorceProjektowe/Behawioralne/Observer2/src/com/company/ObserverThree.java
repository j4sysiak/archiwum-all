package com.company;

// Observator3

public class ObserverThree implements IObserver {

    @Override
    public void notifyMe() {
        System.out.println("Zakończono wątek! " + getClass().getName());
    }
}
