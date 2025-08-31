package com.company;

public class SalamiPizzaDecorator extends PizzaDecorator {

    double SalamiAddinValue = 7;

    // PizzaDecorator wymusza na nas utworzenie tego konstruktora (bo w PizzaDecorator jest niedefaultowy konstruktor) do którego musimy się dopasować
    protected SalamiPizzaDecorator(IPizza iPizza) {
        super(iPizza);
    }

    //zwiększamy wartość pizzy dodając ten dadatek
    @Override
    public double calculatePrice() {
        //do wartości bazowej dodajemy wartość dodatku Salami = 7
        return super.calculatePrice() + SalamiAddinValue;
    }
}
