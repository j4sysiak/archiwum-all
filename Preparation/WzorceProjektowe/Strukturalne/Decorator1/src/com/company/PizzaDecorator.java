package com.company;

public abstract class PizzaDecorator implements IPizza {

    // informacja o pizzy, którą dekorujemy (duza, mala, srednia)
    private IPizza iPizza;

    // ponieważ jest to klasa abstrakcyjna, więc nie można utworzyć obiektu tej klasy
    // - dlatego dostęp do konstruktora robimy protected
    // nie może być public !!!!
    protected PizzaDecorator(IPizza iPizza) {
        this.iPizza = iPizza;
    }

    //  każda implementacja dekoratora (HamPizzaDecorator, CheesePizzaDecorator, SelamiPizzaDecorator)
    //  musi wprowadzić własną implementację tej właśnie metody tzn. muszą te klasy nadpisać @Override tą metodę
    public double calculatePrice() {
        return iPizza.calculatePrice();
    }
}
