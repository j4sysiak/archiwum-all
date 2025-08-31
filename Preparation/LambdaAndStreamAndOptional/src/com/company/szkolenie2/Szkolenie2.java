package com.company.szkolenie2;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Szkolenie2 {

    List<String> names = Arrays.asList("Dorota", "Paweł", "Wojtek", "Karolina");

    @Test
    public void firstSream() {

        Stream<String> stream1 = names.stream();

        // System.out.println(stream1);

        /*pierwszy prymitywy sposób*/
//        Stream<String> stream2 = stream1.filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.endsWith("a");
//            }
//        });
//        stream2.forEach(System.out::println);

        /*drugi sposób*/
//        Stream<String> stream3 = stream1
//                .filter(s -> s.endsWith("a"));
//        stream3.forEach(System.out::println);

        /*trzeci sposób*/
        names.stream()
                .filter(s -> s.endsWith("a"))
                .forEach(System.out::println);

    }

    @Test
    public void filterSream() {

        Set<String> filterNames = names.stream()
                .filter(n -> n.startsWith("D"))
                .collect(Collectors.toSet());

        System.out.println(filterNames);
    }

    @Test
    public void filteredMapSream() {

        List<User> listOfUsers = names.stream()
                .filter(usr -> usr.endsWith("a"))
                .map(name -> new User(name, new Random().nextInt(70)))
                //  .filter(usr -> usr.getName().endsWith("a"))  //lub
                .collect(Collectors.toList());

        System.out.println(listOfUsers);
    }

    @Test
    public void sortedFilteredMapSream() {

        List<User> listOfUsers = names.stream()
                .filter(usr -> usr.endsWith("a"))
                .map(name -> new User(name, new Random().nextInt(70)))
//                .sorted(new Comparator<User>() {
//                    @Override
//                    public int compare(User o1, User o2) {
//                        return o1.getName().compareTo(o2.getName());
//                    }
//                })
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                //   .sorted(Comparator.comparing(User::getAge))  //lub
                //  .filter(usr -> usr.getName().endsWith("a"))  //lub
                .collect(Collectors.toList());

        System.out.println(listOfUsers);


        Comparator<User> comparator = Comparator.comparing(User::getName);
        List<User> list2OfUsers = names.stream()
                .filter(usr -> usr.endsWith("a"))
                .map(name -> new User(name, new Random().nextInt(70)))
                .sorted(comparator.reversed())
                //   .sorted(Comparator.comparing(User::getAge))  //lub
                //  .filter(usr -> usr.getName().endsWith("a"))  //lub
                .collect(Collectors.toList());

        System.out.println(list2OfUsers);

    }
}
