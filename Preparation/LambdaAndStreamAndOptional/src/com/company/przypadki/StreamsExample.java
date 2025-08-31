package com.company.przypadki;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class StreamsExample {

    Collection<LineItem> lineItems;

    @BeforeEach
    public void setUp() {
        LineItem lineItem1 = LineItem.builder().name("aaa").price(12.19f).count(1f).taxRate(22).build();
        LineItem lineItem2 = LineItem.builder().name("aaa").price(13.22f).count(2f).taxRate(23).build();
        LineItem lineItem3 = LineItem.builder().name("aaa").price(14.43f).count(3f).taxRate(24).build();
        lineItems = Arrays.asList(lineItem1, lineItem2, lineItem3);
    }

    @Test
    public void switchInStream() {

    }

    @Test
    public void sumaWszystkichElementówPriceListy() {
        Invoice invoice = Invoice.create(lineItems, "www", "sss");

        // lista z elementali float
        Collection<Float> floatItems = lineItems.stream()
                .map(lineItem -> lineItem.price)
                .collect(Collectors.toList());
        ;

        //sumujemy elementy float z tej listy
        float totFloats = floatItems.stream()
                .reduce(0f, (x, y) -> x + y);

        //lub w całości
        float totFloats2 = lineItems.stream()
                .map(lineItem -> lineItem.price)
                .reduce(0f, (x, y) -> x + y);
        ;

        System.out.println(invoice);
    }
}
