package com.company;

import java.time.LocalTime;
import java.util.function.Supplier;

public class TestSupplier {

    public static void  main(String [] args) {

        // Supplier<T> is a functional interface i.e. one abstract method:
        //      T get()
        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("Supplier SB: " + supSB.get().append("SK"));// Supplier SB: SK

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Supplier time: " + supTime.get());//Supplier time: 09:11:39.121101600

        Supplier<Double> sRandom = () -> Math.random();
        System.out.println(sRandom.get());// e.g. 0.782467864130131

    }

}