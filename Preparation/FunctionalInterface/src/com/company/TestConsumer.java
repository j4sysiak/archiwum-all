package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TestConsumer {

    public static void  main(String [] args) {

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("kaka");

        //using lambda
//        Consumer<String> consumerlmbd = s -> System.out.println(s);
//        consumerlmbd.accept("kka");




        // Consumer<T> is a functional interface i.e. one abstract method:
        //      void accept(T t)
        Consumer<String> printC = s -> System.out.println(s);// lambda
        printC.accept("To be or not to be, that is the question");

        List<String> names = new ArrayList<>();
        names.add("John");names.add("Mary");
        names.forEach(printC);  // John, Mary
        //lub
        names.forEach(s -> System.out.println(s));



        // BiConsumer<T, U> is a functional interface i.e. one abstract method:
        //      void accept(T t, U u)
        Map mapCapitalCities = new HashMap<String, String>();
        // Note: The return value of put(k,v) is just ignored (and not returned from the lambda)
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
        biCon.accept("Dublin", "Ireland");
        biCon.accept("Washington D.C.", "USA");
        System.out.println(mapCapitalCities);// {Dublin=Ireland, Washington D.C.=USA}

        BiConsumer<String, String> mapPrint = (key, value) ->
                System.out.println(key + " is the capital of: "+value);
        mapCapitalCities.forEach(mapPrint); // Dublin is the capital of: Ireland
        // Washington D.C. is the capital of: USA
        //lub
        mapCapitalCities.forEach((key, value) -> System.out.println(key + " is the capital of: "+value));
    }
}


