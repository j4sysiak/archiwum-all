package com.company;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamTest {

    public final static void main(String[] args) {

        Predicate<String> pr = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
        //lambda
        Predicate<String> prl = s -> s.length()>0;

        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.printf(s);
            }
        };
        //lambda
        Consumer conl = s -> System.out.printf(s.toString());
        Consumer conref = System.out::println;

        Stream.of("Alex", "April", "Edward")
                .filter(s -> {
                    return s.length()>5;})
                .forEach(s -> System.out.println(s));

        // "map	przekształca element na inny	Function<T, R>	R apply(T t)"

        Function<String, String> fun = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "";
            }
        };
        Function<String, String> funl = s -> s.toUpperCase();

        //"anyMatch/allMatch/noneMatch	sprawdza warunek logiczny	Predicate<T>	boolean test(T t)"

        Predicate<String> pre = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
        Predicate<String> prel = s -> s.startsWith("A");

                Boolean b = Stream.of("Alex", "April", "Edward")
                .map(s -> s.toUpperCase())
                .anyMatch(s -> {
                    System.out.println(s);return s.startsWith("E");}); // konczy jak znajdzie pierwszy na "A"

       // System.out.println(b);
    }



}
