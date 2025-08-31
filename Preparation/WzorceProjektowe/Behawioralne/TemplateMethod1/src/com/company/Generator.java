package com.company;

public abstract class Generator {

    // szkielet algorytmu
    //to jest metoda szablonowa - wykonywana będzie dla każdego z trzech algorytmów (pdf, cvs, excel) w poszczególnych klasach
    public void generateReport() {
        getData();
        preparedData();
        generateFile();
        sendFile();
    }

    //dla pdf specyficzna metoda wysyłki (@ w pdfGenerator) dla pozostałych taka sama - tzn excel i csv korzysta z tej metody
    protected void getData() {
        System.out.println("Base: Get Data ...");
    }

    //każda metoda wysyłki ma inny sposób przygotowania danych
    protected abstract void preparedData();

    //każda metoda wysyłki ma inny sposób generowania pliku
    protected abstract void generateFile();



    //dla wszystkich metod wysyłki taka sama
    protected void sendFile() {
        System.out.println("Base: Sending generated report");
    }
}
