package com.company;

public abstract class CarDecorator implements ICar {

    //informacja o samochodzie, który dekorujemy
    private ICar iCar;

    //ponieważ jest to klasa abstrakcyjne, więc nie można utworzyć obiektu tej klasy
    // - dlatego dostęp do konstruktora robimy protected
    // nie może być public
    protected CarDecorator(ICar iCar) {
        this.iCar = iCar;
    }

    // każda implementacja dekoratora (ClimaCarDecorator, AbsCarDecorator, RadioCarDecorator)
    //  musi wprowadzić własną mplementację tych  właśnie metod tzn. muszą te klasy nadpisać @Override tą metodę
    public float price() {
        return iCar.price();
    };

    public String description() {
        return iCar.description();
    };
}

