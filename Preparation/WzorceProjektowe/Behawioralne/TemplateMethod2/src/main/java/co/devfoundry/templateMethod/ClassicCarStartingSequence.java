package co.devfoundry.templateMethod;

public class ClassicCarStartingSequence extends CarStartingSequence {

    @Override
    public void setTheGear() {
        System.out.println("Ustawiamy bieg");
    }

    @Override
    public void startTheIgnition() {
        System.out.println("Przekrecamy kluczyk");
    }
}
