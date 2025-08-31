package com.company;

import org.junit.Test;


public class Client {
    /*
      Prototyp:
      kreacyjny wzorzec projektowy, który umożliwia kopiowanie istniejących już obiektów  (shallow and deep cloning)
      (shallow copy - kopiujemy obiekty jak leci, czyli referencje do obiektow tworzacych glowny obiekt nie beda zmienione)
      (deep copy - nie kopiujemy referencji tylko tworzymy nowe obiekty powiązane)
      bez tworzenia zależności pomiędzy kodem programu, a klasami obiektów.
    */

    @Test
    public void testShallowCloning() {
        //KlonowaniePlytkie
        Adres adres = new Adres("Główna", 123);
        Osoba osoba1 = new Osoba("Jan Kowalski", adres);

        Osoba osoba2 = (Osoba) osoba1.cloning();  //KlonowaniePlytkie
        System.out.println("Osoba 1: " + osoba1.getImie() + ", Adres: " + osoba1.getAdres().getUlica());
        System.out.println("Osoba 2: " + osoba2.getImie() + ", Adres: " + osoba2.getAdres().getUlica());

        if (osoba2.equals(osoba1)) {
            System.out.println("equals");
        }

        if (osoba2 == osoba1) {
            System.out.println("==");
        }

        // Zmieniamy adres w jednym z obiektów
        osoba2.getAdres().setUlica("Nowa");
        osoba2.getAdres().setNumerDomu(456);

        System.out.println("Osoba 1 po zmianie adresu w osobie 2: " + osoba1.getAdres().getUlica());
        System.out.println("Osoba 2 po zmianie adresu w osobie 2: " + osoba2.getAdres().getUlica());
    }

    @Test
    public void testDeepCloning() {
        //KlonowanieGlebokie
        Adres adres = new Adres("Główna", 123);
        Osoba osoba1 = new Osoba("Jan Kowalski", adres);
        Osoba osoba2 = (Osoba) osoba1.clone();
    }
}
