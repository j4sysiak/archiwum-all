package com.company;


import org.junit.Test;

public class TestClient {

    @Test
    public void test() {


//        Mediator - behawioralny wzorzec projektowy, pozwalający zredukować liczbę zależności pomiędzy różnymi obiektami.
//        Ogranicza bezpośrednią komunikację pomiędzy obiektami input<-->button<-->checkbox i wymusza komunikację miedzy nimi za pomocą obiektu zwanego mediatorem.
//        Dobrym przykłedem może być wieża kontroli lotów


        Button button = new Button();
        Checkbox checkbox = new Checkbox();
        Input input = new Input();

        //  klasa mediatora:  konkretna implementacja mediatora poprzez klasę RegisterClientView
        //  nie potrzebujemy konkretnego obiektu tej klasy mediatora
        new RegisterClientView(checkbox, button, input);

        button.click();
        checkbox.select();
        input.select();
    }
}
