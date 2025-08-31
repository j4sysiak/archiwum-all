package com.company;

public class PdfGenerator extends Generator {

    @Override
    protected void preparedData() {
        System.out.println("PdfGenerator: prepare data for PDF ...");
    }

    @Override
    protected void generateFile() {
        System.out.println("PdfGenerator: generate PDF ...");
    }

    //ponieważ, uważamy, że dla pdf inaczej pobieramy dane niż dla innych metod wysyłki
    //więc musimy w tej klasie utworzyć specyficzny sposób generowania tych danych
    //nadpisujemy więc tą metodę z klasy Generate
    @Override
    protected void getData() {
        System.out.println("PdfGenerator: get Data for PDF ...");
    }
}
