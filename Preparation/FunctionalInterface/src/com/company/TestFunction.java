package com.company;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TestFunction {

    public static void  main(String [] args) {

        // Function<T, R> is a functional interface i.e. one abstract method:
        //      R apply(T t)
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println("Function: " + fn2.apply("Moscow"));// 6

        // BiFunction<T, U, R> is a functional interface i.e. one abstract method:
        //      R apply(T t, U u)
        BiFunction<String, String, Integer> biFn   = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFn.apply("William", "Shakespeare"));// 18

        BiFunction<String, String, String> biFn2   = (s1, s2) -> s1.concat(s2);
        System.out.println("BiFunction: " + biFn2.apply("William ", "Shakespeare"));// William Shakespeare

    }

}
