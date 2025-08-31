package com.company;

public class Client {

    /*
      Prototyp:
      kreacyjny wzorzec projektowy, który umożliwia kopiowanie istniejących już obiektów
      bez tworzenia zależności pomiędzy kodem programu, a klasami obiektów.
    */


    public static void main(String[] args) {

        Circle c1 = Circle.builder()
                .radius(5)
                .x(1)
                .y(2)
                .border(Border.builder()
                        .color("Red")
                        .size("2px")
                        .build())
                .build();

        System.out.println(c1);

    }
}
