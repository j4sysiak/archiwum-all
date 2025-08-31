package com.company;

public class HamPizzaDecorator extends PizzaDecorator {

    double HamAddinValue = 5;

    // PizzaDecorator wymusza na nas utworzenie tego konstruktora (bo w PizzaDecorator jest niedefaultowy konstruktor) do którego musimy się dopasować
    protected HamPizzaDecorator(IPizza iPizza) {
        super(iPizza);
    }

    //zwiększamy wartość pizzy dodając ten dadatek
    @Override
    public double calculatePrice() {
        //do wartości bazowej dodajemy wartość dodatku Ham =5
        return super.calculatePrice() + HamAddinValue;
    }
}
