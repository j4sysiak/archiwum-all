package lab;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Q2_1738 {
    public static void main(String[] args) {

        /* 5
        Here are several parts to this: (QID 2.1738)
a. Using 1, 2 and 3 create a List of Integers.
    i. Stream the list and calculate the sum, using the sum() method from IntStream.
    ii. Stream the list again and calculate the maximum value, using the max() method from IntStream.
b. Given the Person class (in the zip file), declare a List typed for Person with the following Person’s:
    i. “Alan”, “Burke”, 22
    ii. “Zoe”, “Peters”, 20
    iii. “Peter”, “Castle”, 29
Using the max(Comparator) from Stream, calculate the oldest person in the list.
c. Using 10, 47, 33 and 23 create a List of Integers. Stream the list and using the following versions of reduce(), calculate the maximum value:
    i. Optional<T> reduce(BinaryOperator<T> accumulator)
    ii. T reduce(T identity, BinaryOperator<T> accumulator)
        */

       // IntStream mapToInt(ToIntFunction<? super T> mapper);
       // ToIntFunction<? super T> mapper>  ma metodę:      int applyAsInt(T value);

//        ToIntFunction<Integer> function = new ToIntFunction<Integer>() {
//            @Override
//            public int applyAsInt(Integer v) {
//                return v;
//            }
//        };
//        // lambda
//        ToIntFunction<Integer> mapper = v -> v;
//
//         Stream<Integer> streamI = new Stream<Integer>() {
//             @Override
//             public IntStream mapToInt(ToIntFunction<? super Integer> mapper) {
//                 return null;
//             }
//
//         };
         // lambda
        int i  = Arrays.asList(1)
                .stream()
                .mapToInt(v -> v)
                .max()
                .orElse(0);
        System.out.println(i);



        // 1a. sum() is not in Stream it is in IntStream
        List<Integer> li2 = Arrays.asList(1,2,3);
        Integer sum = li2.stream()
                // IntStream mapToInt(ToIntFunction)
                // ToIntFunction is a functional interface:
                //      int applyAsInt(T value)
                .mapToInt(j -> j) // unboxing
                .sum();
        System.out.println("sum == "+sum);


        // 1b. max() in IntStream
        int max = li2.stream()
                .mapToInt(a -> a.intValue())
                .max()
                .getAsInt();
        System.out.println("max == "+max);




        // 2. max(Comparator) in Stream
        List<Person> people = Arrays.asList(
                        new Person("Alan", "Burke",22),
                        new Person("Zoe", "Peters",20),
                        new Person("Peter", "Castle",29));



        Person oldestPerson = people.stream()
                // Optional<Person> max(Comparator)
                // Comparator Comparator.comparing(Function that returns a Comparable)
                // comparing() takes the functional interface Function:
                //      R apply(T t)
                //      p.getAge() returns an Integer (is a Comparable)
                .max(Comparator.comparing(p -> p.getAge()))
                .get();

        Function<Person, Integer> function2 = new Function<Person, Integer>() {
            @Override
            public Integer apply(Person p) {
                return p.getAge();
            }
        };
        Function<Person, Integer> lambda = p -> p.getAge();
        Function<Integer, Integer> lambda2 = p -> p;


        System.out.println(oldestPerson);
                
        List<Integer> li = Arrays.asList(22,13,34);
        Optional<Integer> oi = li.stream()
                .max(Comparator.comparing(v -> v));// Integer is a Comparable as Integer implements Comparable

        // 3. reduce

//        Optional<Integer> reduce(BinaryOperator<T> accumulator);
//        public interface BiFunction<T, U, R> { ma metodę R apply(T t, U u);

        BiFunction<Integer, Integer, Integer> accumulator =  new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer i1, Integer i2) {
                return Integer.max(i1, i2);
            }
        };
        BiFunction<Integer, Integer, Integer> accumulator2 = (i1, i2) -> Integer.max(i1, i2);


        List<Integer> ls = Arrays.asList(10, 47, 33, 23);
        Optional<Integer> i1 = ls.stream()
                // Optional<Integer> reduce(BinaryOperator<Integer> acc)
                // BinaryOperator<T> extends functional interface BiFunction<T,U,R>
                //    BiFunction's functional method is R apply(T t, U u)
//                .reduce((a, b)->a>b?a:b)
                .reduce((a, b)->Integer.max(a, b));
                int max2 = i1.get();
        System.out.println(max2);

        int max3 = ls.stream()
                // Integer reduce(Integer identity, BinaryOperator<Integer> acc)
                // The identity element is both the initial value of the reduction 
                // and the default result if there are no elements in the stream. 
                .reduce(Integer.MIN_VALUE, (a, b)->Integer.max(a, b));
        System.out.println(max3);

    }
    
}
