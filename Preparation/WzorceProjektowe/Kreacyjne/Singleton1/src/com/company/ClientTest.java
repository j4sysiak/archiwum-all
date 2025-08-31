package com.company;

import org.junit.Test;

public class ClientTest {

    /*
    Kreacyjny wzorzec projektowy, którego celem jest ograniczenie możliwości tworzenia obiektów danej klasy do jednej instancji.
    Może być tylko jeden obiekt tej klasy.
    Singleton zapewnia też globalny dostęp do stworzonego obiektu.

    Zalety: jeden globalny obiekt danej klasy - globalny dostęp do niego (może być używany do zapewnienia transakcyjności, persystencji)
    Wady: łamie zasady SOLID: SingleResponsibility, OpenClose i może utrudnić pisanie testów jednostkowych
    */

    @Test
    public void test() {

        // musi być prywatny konstruktor Configuration, żeeeeeby nie było można tworzyć obiektów Configuration
        // var cfg = new Configuration();  E R R O R
        var cfg1 = Configuration.getInstatnce();
        var cfg2 = Configuration.getInstatnce();

        if (cfg1 == cfg2) {
            System.out.println("cfg1 == cfg2  ->  to znaczy, że jest to jeden obiekt, czyli singleton");
        }
    }
}
