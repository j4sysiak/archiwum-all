package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {

        //--------------------------- example 1
        List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3,4));
        intList.stream().forEach(v -> System.out.println(v));
        intList.stream()
                .filter(i -> i>3)
                .forEach(v -> System.out.println(v));


        //--------------------------- example 2
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "haskhsf", 22, Address.GERMANY));
        employees.add(new Employee(1, "sdfadf", 11, Address.POLAND));
        employees.add(new Employee(1, "bcvnbv", 44, Address.BANGLADESH));

        employees.stream()
                .filter(i -> i.getAddress() == Address.BANGLADESH)
                .map(e -> e.getName().toUpperCase())
                .sorted()
                .forEach( n -> System.out.println("Empl. name: " + n));

        //--------------------------- example 3
        // count the occurance of each name from the given list
        List<String> listOfNames = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc", "ddd", "bbb", "ccc", "ddd", "ccc", "ddd", "ddd"));
        Map<String, Long> mapOfNames = listOfNames.stream()
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );
        mapOfNames.forEach( (keyOfNames, valueOfCount) -> System.out.println(keyOfNames + " : " + valueOfCount));

        //--------------------------- example 3
        // count the occurance of each number from the given list
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,2,3,4,5,6,3,4,5,6,4,5,6,5,6,6));
        Map<Integer, Long> mapOfNumbers = numberList.stream()
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );
        mapOfNumbers.forEach((keyOfNumbers, valueOfCount) -> System.out.println(keyOfNumbers + " : " + valueOfCount));
    }
}



















































