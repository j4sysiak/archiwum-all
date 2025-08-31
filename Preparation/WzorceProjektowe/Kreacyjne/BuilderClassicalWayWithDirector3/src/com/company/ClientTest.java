package com.company;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

@Setter
@Getter
public class ClientTest {

    @Test
    public void test1() {
        // budujemy obiekt Director przy użyciu lombok na bazie klasy MonthlyInvoiceBuilder
        Director director = Director
                .builder()
                .iInvoiceBuilder(new MonthlyInvoiceBuilder())
                .build();

        director.getIInvoiceBuilder().setVendor("Sanex");
        director.getIInvoiceBuilder().setNote("dupa-dupa-dupa");
        Invoice invoice = director.getIInvoiceBuilder().build();  // zwraca obiekt w ostatnim kroku
    }

    @Test
    public void test2() {
        // budujemy obiekt Director przy użyciu lombok na bazie klasy EmptyInvoiceBuilder
        Director director = Director
                .builder()
                .iInvoiceBuilder(new EmptyInvoiceBuilder())
                .build();

        director.getIInvoiceBuilder().setVendor("Sanex");
        director.getIInvoiceBuilder().setNote("dupa-dupa-dupa");
        Invoice invoice = director.getIInvoiceBuilder().build();  // zwraca obiekt w ostatnim kroku
    }

    @Test
    public void test3() {
        // budujemy obiekt Director przy użyciu lombok na bazie klasy WithOutVATInvoiceBuilder
        Director director = Director
                .builder()
                .iInvoiceBuilder(new WithOutVATInvoiceBuilder())
                .build();

        director.getIInvoiceBuilder().setVendor("Sanex");
        director.getIInvoiceBuilder().setNote("dupa-dupa-dupa");
        Invoice invoice = director.getIInvoiceBuilder().build();  // zwraca obiekt w ostatnim kroku
    }

    @Test
    public void test4() {
        // budujemy obiekt Director przy użyciu lombok na bazie klasy MonthlyInvoiceBuilder
        Director director = Director
                .builder()
                .iInvoiceBuilder(new MonthlyInvoiceBuilder())
                .build();

        director.getIInvoiceBuilder().setVendor("Sanex");
        director.getIInvoiceBuilder().setNote("dupa-dupa-dupa");
        Invoice invoice = director.getIInvoiceBuilder().build();  // zwraca obiekt w ostatnim kroku
    }
}
