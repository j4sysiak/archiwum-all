package com.company;

import org.junit.jupiter.api.Test;

public class ClientTest {
    @Test
    public void test() throws Exception {

    /*
    Udostępniany jest interface IShape (lub klasa abstrakcyjna Shape) do tworzenia obiektów w ramach klasy bazowej.
    Jednocześnie pozwala podklasom zmieniać typ tworzonych obiektów.

    Fabryka oddziela kod implementacyjny (ShapeFactory: tworzący dany obiekt) od kodu, który korzysta z tego obiektu - Clienta.
    Dodanie nowego kształtu nie powoduje zmiany kodu klienta (klasa ClientTest)
                - dodajemy tylko w fabryce (ShapeFactory) nowy case i budujemy klasę nowego obiektu.
    */


        ShapeFactory shapeFactory = new ShapeFactory();

        var circle = shapeFactory.createShape(ShapeType.Circle);
        circle.render();

        IShape triangle = shapeFactory.createShape(ShapeType.Triangle);
        triangle.render();

        IShape rectangle = shapeFactory.createShape(ShapeType.Rectangle);
        rectangle.render();
    }
}
