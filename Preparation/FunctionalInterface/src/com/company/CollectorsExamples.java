package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExamples {
    public static void main(String[] args) {

        //doPartitioning1();
        //doPartitioning2();
        //doPartitioning3();

        //doGroupingBy1();
        //doGroupingBy2();
        //doGroupingBy3();

        //doCollectToMap1();
        doCollectToMap2();
        //doCollectToMap1();
    }

    public static void doPartitioning1(){
        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");

        /*
        1. <R, A> R collect(Collector<? super T, A, R> collector);
        2.
          Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate) {
            return partitioningBy(predicate, toList());
        }
        */

        // w rozbiciu
        Predicate<String> pred = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
        // definicja predykatu typu lambda:
        Predicate<String> predicalLambda = s -> s.startsWith("T");

        Collector<String, ?, Map<Boolean, List<String>>> collector = Collectors.partitioningBy(predicalLambda);

        Map<Boolean, List<String>> map1 = names.collect(collector);

        // od razu
        Map<Boolean, List<String>> map =
                names.collect(
                        // pass in a Predicate
                        Collectors.partitioningBy(s -> s.startsWith("T"))
                );
        System.out.println(map);// {false=[Mike, Alan, Peter], true=[Thomas, Teresa]}
    }

    public static void doPartitioning2(){
        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, List<String>> map =
                names.collect(
                        // pass in a Predicate
                        Collectors.partitioningBy(s -> s.length() > 4)
                );
        System.out.println(map);// {false=[Mike, Alan], true=[Thomas, Teresa, Peter]}
    }

    public static void doPartitioning3(){
        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, List<String>> map =
                names.collect(
                        // forcing an empty list
                        Collectors.partitioningBy(s -> s.length() > 100)
                );
        System.out.println(map);// {false=[Thomas, Teresa, Mike, Alan, Peter], true=[]}
    }


    public static void doGroupingBy1(){
        Stream<String> names = Stream.of("Martin", "Peter", "Joe", "Tom", "Tom", "Ann", "Alan");
        Map<Integer, List<String>> map =
                names.collect(
                        // przekazując funkcję, która określa klucz na mapie
                        Collectors.groupingBy(s -> s.length()) // s -> s.length()
                );
        System.out.println(map);// {3=[Joe, Tom, Tom, Ann], 4=[Alan], 5=[Peter], 6=[Martin]}
    }



    public static void doGroupingBy2(){
        Stream<String> names = Stream.of("Martin", "Peter", "Joe", "Tom", "Tom", "Ann", "Alan");
        Map<Integer, Set<String>> map =
                names.collect(
                        getStringMapCollector() // what to do with the values
                );
        System.out.println(map);// {3=[Ann, Joe, Tom], 4=[Alan], 5=[Peter], 6=[Martin]}
    }

    private static Collector<String, ?, Map<Integer, Set<String>>> getStringMapCollector() {
        return Collectors.groupingBy(
                String::length,     // key Function
                getSetSupplier()
        );
    }

    private static Collector<String, Set<String>, Set<String>> getSetSupplier() {
        return Collector.of(
                () -> new HashSet<String>(),                    // supplier
                (set, word) -> set.add(word),                   // accumulator
                (set1, set2) -> {
                    set1.addAll(set2);
                    return set1;
                }
        );
    }


    Function<? super String, ? extends Integer> classifier = new Function<String, Integer>() {
        @Override
        public Integer apply(String s) {
            return 0;
        }
    };
    Function<? super String, ? extends Integer> classifierl = s -> s.length();

    public static void doGroupingBy3(){
        Stream<String> names = Stream.of("Martin", "Peter", "Joe", "Tom", "Tom", "Ann", "Alan");
        Map<Integer, List<String>> map =
                names.collect(
                        getStringTreeMapCollector()// downstream collector  --  R collect(Collector<? super T, A, R> collector);
                );
            // R - wyjscie  Map<Integer, List<String>>
            // T - wejscie String
            // A - the intermediate accumulation type of the Collector

        System.out.println(map);// {3=[Joe, Tom, Tom, Ann], 4=[Alan], 5=[Peter], 6=[Martin]}
        System.out.println(map.getClass());// class java.util.TreeMap

    }

    private static Collector<String, ?, TreeMap<Integer, List<String>>> getStringTreeMapCollector() {
        return Collectors.groupingBy(
                s ->s.length(),
                TreeMap::new,       // map type Supplier
                toListCollector()
        );
    }

    private static Collector<String, List<String>, List<String>> toListCollector() {
        //  return Collectors.toList();

        /*
        Collector<T, R, R> of(
                Supplier<R> supplier,
                BiConsumer<R, T> accumulator,
                BinaryOperator<R> combiner) {}
        */


        return Collector.of(               // ręczna wersja toList()
                ArrayList::new,            // supplier
                List::add,                 // accumulator
                (l1, l2) -> { l1.addAll(l2); return l1; } // combiner
        );
    }

    public static void doCollectToMap1(){
        // We want a map: dessert name -> number of characters in dessert name
        // Output:
        //   {biscuits=8, cake=4, apple tart=10}

        Stream<String> names = Stream.of("cake", "biscuits", "apple tart");

        Map<String, Integer> map =
                names.collect(
                        getMap()// Function for the value
                        );
        System.out.println(map);
    }

    private static Collector<String, ?, Map<String, Integer>> getMap() {
        return Collectors.toMap(
                s -> s,         // Function for the key  (wartosc klucza jest Srtingiem)
                s -> s.length());   // Function for the value  (wartosc Value mapy to bedzie Integer), bo:
        // We want a map: dessert name -> number of characters in dessert name
        // Output:
        //   {biscuits=8, cake=4, apple tart=10}
    }

    /*
    Function<String, String> keyMapper  = new Function<String, String>() {
        @Override
        public String apply(String s) {
            return "";
        }
    };
    Function<String, String> keyMapperl = s -> s;


    Function<String, Integer> valueMapper = new Function<String, Integer>() {
        @Override
        public Integer apply(String s) {
            return 0;
        }
    };
    Function<String, Integer> valueMapperl = s -> s.length()

    Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
                                    Function<? super T, ? extends U> valueMapper) {
        return new Collectors.CollectorImpl<>(HashMap::new,
                uniqKeysMapAccumulator(keyMapper, valueMapper),
                uniqKeysMapMerger(),
                CH_ID);

        Collector.of(

        )
    }  */


    public static void doCollectToMap2(){
        // We want a map: number of characters in dessert name -> dessert name
        // However, 2 of the desserts have the same length (cake and tart) and as 
        // length is our key and we can't have duplicate keys, this leads to an 
        // exception as Java does not know what to do...
        //    IllegalStateException: Duplicate key 4 (attempted merging values cake and tart)
        // To get around this, we can supply a merge function, whereby we append the 
        // colliding keys values together.
        Map<Integer, String> map = 
                Stream.of("cake", "biscuits", "tart")
                .collect(
                        getMapCollector()// Merge function - what to
                                                               // do if we have duplicate keys 
                                                               //   - append the values
                );
        System.out.println(map);// {4=cake,tart, 8=biscuits}
    }

    private static Collector<String, ?, Map<Integer, String>> getMapCollector() {
        /*  Collector<T, ?, Map<K,U>>   T - zwracamy (String),  ? - Map<Integer, String>, K - key (Integer), U - value (String) */
        return Collectors.toMap(
                s -> s.length(),     // keyMapper:   key is the length
                s -> s,              // valueMapper: value is the String
                (s1, s2) -> s1 + "," + s2);  // mergeFunction

    /*
    Collector<T, ?, Map<K,U>> toMap(
                                Function<? super T, ? extends K> keyMapper,
                                Function<? super T, ? extends U> valueMapper,
                                BinaryOperator<U> mergeFunction)

    */
    }

    public static void doCollectToMap3(){
        // The maps returned are HashMaps but this is not guaranteed. What if we wanted
        // a TreeMap implementation so our keys would be sorted. The last argument
        // caters for this.
        TreeMap<String, Integer> map =
                Stream.of("cake", "biscuits", "apple tart", "cake")
                        .collect(
                                Collectors.toMap(s -> s,            // key is the String
                                        s -> s.length(),   // value is the length of the String
                                        (len1, len2) -> len1 +len2, // what to do if we have
                                        // duplicate keys
                                        //    - add the *values*
                                        () -> new TreeMap<>() ));// TreeMap::new works
        System.out.println(map);// {apple tart=10, biscuits=8, cake=8} Note: cake maps to 8
        System.out.println(map.getClass());// class java.util.TreeMap
    }

    public static void doJoining(){
        String s = Stream.of("cake", "biscuits", "apple tart")
                        .collect(Collectors.joining(", "));
        System.out.println(s);  // cake, biscuits, apple tart
    }
    
    public static void doAveragingInt(){
        Double avg = Stream.of("cake", "biscuits", "apple tart")
                        // averagingInt(ToIntFunction) functional method is:
                        //      int applyAsInt(T value);
                        .collect(Collectors.averagingInt(s -> s.length()));
        System.out.println(avg);  // 7.333333333333333  
    
    }
}
/*
    public static void doGroupingBy3(){
        
        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        TreeMap<Integer, List<String>> map =
                names.collect(
                    Collectors.groupingBy(
                            String::length,
                            TreeMap::new,       // map type Supplier
                            Collectors.toList())// downstream collector
                );
        System.out.println(map);// {3=[Joe, Tom, Tom], 4=[Alan], 5=[Peter]}
        System.out.println(map.getClass());// class java.util.TreeMap

    }
    public static void doGroupingBy2(){
        
        Stream<String> names = Stream.of("Alan", "Joe", "Tom", "Tom", "Peter");
        Map<Integer, Set<String>> map =
                names.collect(
                    Collectors.groupingBy(
                            String::length,     // key Function
                            Collectors.toSet()) // what to do with the values
                );
        System.out.println(map);// {3=[Joe, Tom], 4=[Alan], 5=[Peter]}

    }
    public static void doGroupingBy1(){
        
        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Integer, List<String>> map =
                names.collect(
                    // passing in a Function that determines the 
                    // key in the Map
                    Collectors.groupingBy(String::length) // s -> s.length()
                );
        System.out.println(map);// {3=[Joe, Tom, Tom], 4=[Alan], 5=[Peter]}

    }

*/