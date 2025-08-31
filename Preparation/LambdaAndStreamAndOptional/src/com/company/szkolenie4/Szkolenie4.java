package com.company.szkolenie4;

import com.company.szkolenie3.StremMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Szkolenie4 {

    private final StremMethods stremMethods = new StremMethods();

    @Test
    public void shouldGenerateBySupplierV1() {

        Supplier<Integer> supplier  = new AtomicInteger()::getAndIncrement;
        //lub
//        Supplier<Integer> supplier = new Supplier<Integer>() {
//            final AtomicInteger atomicInteger = new AtomicInteger();
//
//            @Override
//            public Integer get() {
//                return atomicInteger.getAndIncrement();
//            }
//        };

    //    List<Integer> list = Stream.generate(supplier)  // lub
        List<Integer> list = Stream.generate(new AtomicInteger()::getAndIncrement)
                .limit(10)
                .collect(Collectors.toList());

        Assertions.assertIterableEquals(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), list);
        System.out.println(list);
    }


    @Test
    public void shouldGenerateByIterate() {

        List<String> list = Stream.iterate("a", i -> "-" + i)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(list);
        Assertions.assertIterableEquals(List.of("a", "-a", "--a", "---a", "----a"), list);
    }

    @Test
    public void shouldGenerateByIterateWithFinishCondition() {

        List<String> list = Stream.iterate("a", i -> i.length() <= 5, i -> "-" + i)
                //.limit(5) już nie potrzebne
                .collect(Collectors.toList());
        System.out.println(list);
        Assertions.assertIterableEquals(List.of("a", "-a", "--a", "---a", "----a"), list);
    }
}
