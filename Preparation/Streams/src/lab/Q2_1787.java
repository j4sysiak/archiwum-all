package lab;
// Stream is a sequence of objects
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Q2_1787 {

    public static void main(String[] args) {

        /*
        Generate a Stream<List<String>> using the Stream.of(Arrays.asList(“a”, “b”), Arrays.asList(“a”,“c”)) method call.
        Filter the stream so that only list’s that contain “c” make it through the filter.
        Flatten the Stream<List<String>> to a Stream<String> using the flatMap() operation.
        Note that flapMap() states in the API “Each mapped stream is closed after its contents have been placed intothis [new] stream.”.
        Use forEach() to output the new stream.
         */

        Stream<List<String>> streamOfLists = Stream.of(
                Arrays.asList("a", "b"),
                Arrays.asList("d", "c"),
                Arrays.asList("a", "c"));


        //filter
        //Stream<T> filter(Predicate<? super T> predicate);
        //public interface Predicate<T> {  has method: boolean test(T t);
        Predicate<List<String>> predicate = new Predicate<List<String>>() {
            @Override
            public boolean test(List<String> list) {
                return list.contains("c");
            }
        };
        // lambda
        Predicate<List<String>> predicate2 = l -> l.contains("c");

        //flatMap
        //<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
        //public interface Function<T, R> {  ma metodę: R apply(T t);

        Function<List<String>, Stream<String>> function = new Function<List<String>, Stream<String>>() {
            @Override
            public Stream<String> apply(List<String> l) {
                return l.stream();
            }
        } ;
        //lambda
        Function<List<String>, Stream<String>> function2  =  l -> l.stream();

//        Stream<List<String>> stream = new Stream<List<String>>() {
//            @Override
//            public <R> Stream<R> flatMap(Function<? super List<String>, ? extends Stream<? extends R>> mapper) {
//                return null;
//            }
//        }


                streamOfLists
                // Stream<List<String>> filter(Predicate)   Predicate == boolean test(T t)
                .filter(list -> list.contains("c"))
                // Stream<List<String>> peek(Consumer)
                .peek(list -> System.out.println("\n"+list)) // 1. [d,c]    2. [a,c]
                // Stream<String> flatMap(Function)  
                //      Function<T,R> == R apply(T t)
                //          Stream<String> apply(List<String> l)
                .flatMap(list -> list.stream())
//                .flatMap(List::stream)
               //     forEach() is a terminal operation
                .forEach(str -> System.out.print(str+ " ")); // 1.  d c     2.  a c  
        System.out.println();



            List<String> list = Arrays.asList("a", "b", "c");
            list.forEach(s -> System.out.println(s)); // Consumer == void accept(T t)
            // OR
            list.forEach(System.out::println);

            Stream<String> stream = list.stream();
            stream.forEach(System.out::println);
    }

}
