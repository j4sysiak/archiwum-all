package com.company;

import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceExample {

    public static void main(String[] args) {

        // reduce to taki sumator
        int length0 = Stream.of("car", "bus", "train", "aeroplane")
                .mapToInt(String::length)
                .sum();  // daje dokładnie to samo co reduce()


        /*
        Element	        Typ	                            Rola
        identity	    Integer	                        wartość początkowa (tu: 0)
        accumulator	    (Integer, String) -> Integer	dodaje długość stringa do sumy
        combiner	    (Integer, Integer) -> Integer	scala cząstkowe wyniki (np. przy parallel())
        końcowy wynik	Integer	                        suma długości wszystkich słów
        */
        Stream<String> myStringStream = Stream.of("car", "bus", "train", "aeroplane");

        int length = myStringStream.reduce(
                0,                                  // identity: Integer
                (n, str) -> n + str.length(),       // accumulator: Integer + String = Integer
                (n1, n2) -> n1 + n2                  // combiner: Integer + Integer = Integer
        );
        System.out.println(length);

    /*
    Dlaczego w accumulatorze n to Integer, a str to String?
    Bo to wynika z generyków tej wersji reduce():

    Typy:
       T – typ elementów streama = String
       U – typ wyniku = Integer

    Czyli:
        identity → Integer
        accumulator → (Integer, String) -> Integer
        combiner → (Integer, Integer) -> Integer

        <U> U reduce (
                U identity,                              // Integer
                BiFunction<U, ? super T, U> accumulator, // (Integer, String) -> Integer
                BinaryOperator<U> combiner)              // (Integer, Integer) -> Integer

    */

        /*
        T reduce(T identity, BinaryOperator<T> accumulator);
        Typy:
        T – typ elementów streama = String
        */
        Stream<String> myStringStream2 = Stream.of("car", "bus", "train", "aeroplane");

        String length2 = myStringStream2.reduce(
                "-",                                  // identity: Integer
                (n1, n2) -> n1 + n2        // accumulator: Integer + String = Integer
        );
        System.out.println(length2); //"-carbustrainaeroplane"



        /*
        T reduce(T identity, BinaryOperator<T> accumulator);
        Typy:
        T – typ elementów streama = Integer
        */
        Stream<Integer> myStringStream3 = Stream.of(1, 2, 3, 4);

        Integer length3 = myStringStream3.reduce(
                0,                                  // identity: Integer
                (n1, n2) -> n1 + n2        // accumulator: Integer + String = Integer
        );
        System.out.println(length3); //10


        /* prostrza wersja */
        /*
        IntStream mapToInt(ToIntFunction<? super T> mapper);

        @FunctionalInterface
        public interface ToIntFunction<T> {
        int applyAsInt(T value);
        }
         */

        ToIntFunction<String> tif = new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return 0;
            }
        };
        ToIntFunction<String> tifl = s -> s.length();
        ToIntFunction<String> tifref = String::length;

        IntStream intStream = Stream.of("car", "bus", "train", "aeroplane")
                .mapToInt(String::length);
        System.out.println(intStream.sum());

        int length4 = Stream.of("car", "bus", "train", "aeroplane")
                .parallel() // nawet tutaj!
                .mapToInt(String::length)  // zmieni typ na IntStream
                .sum();
        System.out.println(length4);
    }
}
