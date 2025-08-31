package lab;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q2_1846 {
    public static void main(String[] args) {

        /*
        Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
            a. title=”Atlas Shrugged”, price=10.0
            b. title=”Freedom at Midnight”, price=5.0
            c. title=”Gone with the wind”, price=5.0
        Stream the books and instantiate a Map named ‘bookMap’ that maps the book title to its price.
        To do this use the collect(Collectors.toMap(Function fnToGetKey, Function fnToGetValue)).
        Iterate through ‘bookMap’ (using the Map forEach(BiConsumer) method). The BiConsumer only outputs
        prices where the title begins with “A”.
        */


        List<Book> books = Arrays.asList(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0));

        Function<Book, String> function = new Function<Book, String>() {
            @Override
            public String apply(Book book) {
                return book.getTitle();
            }
        };

        Function<Book, Double> function2 = new Function<Book, Double>() {
            @Override
            public Double apply(Book book) {
                return book.getPrice();
            }
        };

        Map<String, Double> bookMap2 = books.stream()
                .collect(Collectors.toMap(
                        b -> b.getTitle(), b -> b.getPrice()
                ));
        bookMap2
                .forEach((s, d) -> {
                    if (s.startsWith("A")) {
                        String s1 = s;
                        Double d1 = d;
                        System.out.println(d);
                    }
                });


        // public interface BiConsumer<T, U> {  void accept(T t, U u);

        BiConsumer<String, Double> consumer = new BiConsumer<String, Double>() {
            @Override
            public void accept(String s, Double d) {
                if (s.startsWith("A")) {
                    String s1 = s;
                    Double d1 = d;
                    System.out.println(d1);
                }
            }
        };
        BiConsumer<String, Double> consumer2 = (s, d) -> {
            if (s.startsWith("A")) {
                String s1 = s;
                Double d1 = d;
                System.out.println(d1);
            }
        };


        // API:
        //   An object that maps keys to values. 
        //   A map cannot contain duplicate keys; each key can map to at most one value.
        Map<String, Double> bookMap =
                books.stream()
                        .collect(Collectors.toMap((b -> b.getTitle()), b -> b.getPrice()));
        //System.out.println("Map == "+bookMap);
        BiConsumer<String, Double> funcBC = (a, b) -> { //define the lambda (not executing yet)
            if (a.startsWith("A")) {
                System.out.println(b);
            }
        };
        bookMap.forEach(funcBC);// execute lambda;   Map::forEach(BiConsumer) 

        // option D
        // using a Set here as opposed to a Map


        List<Book> books1 = Arrays.asList(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0));
        Map<String, Double> bookMap1 =
                books1.stream()
                        .collect(Collectors.toMap((b -> b.getTitle()), b -> b.getPrice()));

        //public interface BiConsumer<T, U> {  ma metodę:   void accept(T t, U u);
        BiConsumer<String, Double> biConsumer = new BiConsumer<String, Double>() {
            @Override
            public void accept(String s, Double d) {
                if (s.startsWith("A")) {
                    d.doubleValue();
                    System.out.println(s + ":" + d.doubleValue());
                }

            }
        };
        BiConsumer<String, Double> biConsumer2 = (s, d) -> {
            if (s.startsWith("A")) {
                System.out.println(s + ":" + d.doubleValue());
            }
        };

        bookMap.forEach(biConsumer2);


        Set<Map.Entry<String, Double>> bookSet = bookMap.entrySet();
        //  bookSet.stream().forEach(Consumer<? super T> action);  // we need Consumer<? super T> action
        Consumer<Map.Entry<String, Double>> funcConsumer = (entry) -> {
            if (entry.getKey().startsWith("A")) {
                System.out.println(entry.getValue());
            }
        };

        bookSet.forEach(funcConsumer); // Set::forEach(Consumer)
        bookSet.forEach((entry) -> {
                                        if (entry.getKey().startsWith("A")) {
                                            System.out.println(entry.getValue());
                                        };
                                    }
                         ); // Set::forEach(Consumer)


            Map<String, Integer> map = new HashMap<>();
            map.put("key1", 1);
            map.put("key2", 2);

// Using forEach
            map.forEach((key, value) -> System.out.println(key + " : " + value));

            //  explanation
            map.forEach((key, value) -> System.out.println(key + ":" + value));  // needs BiConsumer<String, Double

            BiConsumer<String, Double> biConsumer3 = (key, value) -> {
                System.out.println(key + ":" + value);
            };


// Using Streams
            map.entrySet().stream()
                    .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

            //  explanation


            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            entries.stream().forEach( e -> System.out.println(e.getKey() + e.getValue()) );

        Consumer<Entry<String, Integer>> entryConsumer = new Consumer<Entry<String, Integer>>() {
            @Override
            public void accept(Entry<String, Integer> e) {
                System.out.println(e.getKey() + ":" + e.getValue());
            }
        };
        // lambda
        Consumer<Entry<String, Integer>> entryConsumerWithLambda = (e)  -> System.out.println(e.getKey() + e.getValue());
    }
    }
