package com.company;

public class CheesePizzaDecorator extends PizzaDecorator {

    double CheeseAddinValue = 2.1;

    // PizzaDecorator wymusza na nas utworzenie tego konstruktora (bo w PizzaDecorator jest niedefaultowy konstruktor) do którego musimy się dopasować
    protected CheesePizzaDecorator(IPizza iPizza) {
        super(iPizza);
    }

    // zwiększamy wartość pizzy dodając ten dadatek
    @Override
    public double calculatePrice() {
        //do wartości bazowej dodajemy wartość dodatku Cheese = 2.1
        return super.calculatePrice() + CheeseAddinValue;
    }
}
