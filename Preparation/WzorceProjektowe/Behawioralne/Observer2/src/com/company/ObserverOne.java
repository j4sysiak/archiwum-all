package com.company;


// Observator1

public class ObserverOne implements IObserver {

    @Override
    public void notifyMe() {
        System.out.println("Zakończono wątek! " + getClass().getName());
    }
}
