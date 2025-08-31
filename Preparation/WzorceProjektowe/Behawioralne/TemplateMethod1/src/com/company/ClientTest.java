package com.company;

import org.junit.jupiter.api.Test;


public class ClientTest {

/*
Behawioralny wzorzec projektowy definiujący szkielet algorytmu w klasie bazowej, jednocześnie pozwalający podklasom napisać
konkretne etapy tego algorytmu bez konieczności zmiany jego struktury.
Zadanie w programie.
Utworzyć rozwiązanie wysyłki raportu w trzech sposobach.
Tworzymy funkcjonalności wspólne dla tych trzech zadań.
Jeżeli różnią się zachowaniem - to robimy oddzielnie dla każdej metody wysyłki.
Metoda wspólna jako abstract a specyficzne działanie programu pod konkretny sposób wysyłki w osobnych podklasach dla pdf, excela, czy csv.
Te specyficzne metody definiujemy we wspólnej klasie abstrakcyjnej.
Każda z podklas będzie musiała w specyficzny dla siebie sposób zaimplementować rozwiązanie.
*/

    @Test
    public void test() {

        System.out.println("**** PDF ****");
        var pdfGenerator = new PdfGenerator();
        pdfGenerator.generateReport();

        System.out.println("**** CSV ****");
        var csvGenerator = new CsvGenerator();
        csvGenerator.generateReport();
    }
}
