package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.time.LocalDateTime.now;

public class ClientTest {


    @Test
    public void test1() {
        /*
        Można tworzyć etapami złożone obiekty.
        Rozdziela sposób tworzenia obiektów od ich reprezentacji.
        Przykład z budowaniem złożonego obiektu "faktura" (klasa Invoice).
        Nie tworzymy takiego obiektu jednym konstruktorem, tylko budujemy poszczególne elementy i dokładamy do
        obiektu "faktura" (klasa Invoice).
        Do obiektu (klasy Invoice) "faktura" wprowadzamy klasę pomocnicza InvoiceBuilder, której celem będzie utworzenie konkretnej faktury
        poprzez udostępnienie takich metod jak:
        - setVendor()  -- dodaje do faktury invoice vendora
        - setVendee()  --  itp
        - setNotes()   --  itp
        - setLineItems()  --  itp
        Każda z tych metod, przyjmuje konkretne elementy (obiekty), które ustawiają te parametry na fakturze.
        Wszystkie metody set, w pewien sposób modyfikują fakturę, którą chcemy otrzymać.
        Końcowym momentem do wygenerowania tej faktury jest metoda build(), zwróci konkretną fakturę, którą klient chce uzyskać.
        */

        // pierwszy sposób - mega prymitywny
        /*InvoiceBuilder ale lepiej var*/
        var invoiceBuilder = new InvoiceBuilder(); // tworzymy tutaj na początku pusty obiekt faktury: wstrzykujemy invoice w konstruktorze InvoiceBuilder()
        // dokładamy poszczególne elementy do faktury:
        invoiceBuilder.setDate(now());
        invoiceBuilder.setInvoiceNumber("A13132-2022");
        invoiceBuilder.setVendor("Ford Motors Company Co. Limited");
        invoiceBuilder.setVendee("Jacek");
        invoiceBuilder.setNote("flsjdfjlsjdlfjlsjdfjsdjfsdlflsj");
        invoiceBuilder.setLineItems(List.of("Line item1", "Line item2"));

        // i mamy naszą piękną fakturę
        Invoice invoice = invoiceBuilder.build();  // i odbieramy naszą fakturę
        System.out.println(invoice);
    }

    @Test
    public void test2() {
        var invoiceBuilder = new InvoiceBuilder();
        // tak zwane płynne wywołanie (łańcuchowe)
        // drugi sposób - to w sumie to samo co powyżej ale szybciej i ładniej
        Invoice invoice = invoiceBuilder
                .setDate(now())
                .setInvoiceNumber("A13132-2022")
                .setVendor("Ford Motors Company Co. Limited")
                .setVendee("Jacek")
                .setNote("flsjdfjlsjdlfjlsjdfjsdjfsdlflsj")
                .setLineItems(List.of("Line item1", "Line item2"))
                .build();  // i odbieramy naszą fakturę
        System.out.println(invoice);
    }

    @Test
    public void test3() {
        // korzystamy z lomboka w klasie Invoice
        // UWAGA - nie uzywamy tutaj invoiceBuildera - to tylko bezposrednie tworzenie klasy Invoice (taki przyklad tylko)
        // trzeci sposób - używa anotacji @Builder Lomboka w bezpośrednio klasie Invoice: ale pamietaj, że kazde pole w Invoice musi byc oznaczone: @Builder.Default
        // i musimy jaks wartosc domyslna podac
        Invoice invoice = Invoice.builder()
                .date(now())
                .number("A13132-2022")
                .vendor("Ford Motors Company Co. Limited")
                .vendee("Jacek")
                .note("flsjdfjlsjdlfjlsjdfjsdjfsdlflsj")
                .lineItems(List.of("Line item1", "Line item2"))
                .build();  // lombok
        System.out.println(invoice);
    }
}
