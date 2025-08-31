package com.company;

import org.junit.Test;

public class ClientTest {

    @Test
    public void test() {

        //wybieramy bazowy model
        var v1 = new Volvo40();

        //  i dorzucamy/dekorujemy ABS'em (dodajemy ABS)
        var absCarDecorator = new AbsCarDecorator(v1);
        System.out.println("Cena volvo40 typu (a ABS): " + absCarDecorator.description() + ' ' + absCarDecorator.price());

        //  i dorzucamy/dekorujemy radio
        var v2 = new RadioCarDecorator(absCarDecorator);
        System.out.println("Cena volvo40 typu (ABS + Radio): " + absCarDecorator.description() + ' ' + v2.price());

        //  i dorzucamy/dekorujemy klime
        var v3 = new ClimaCarDecorator(v2);
        System.out.println("Cena volvo40 typu (ABS + Radio + Klima): " + absCarDecorator.description() + ' ' + v3.price());
    }
}
