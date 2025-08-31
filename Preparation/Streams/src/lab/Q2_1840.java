package lab;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Q2_1840 {
    public static void main(String[] args) {

        /*
        This question demonstrates lazy evaluation.
        Declare the following list :
         List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);

            a. stream the List (note that this is possible because List is a Collection and Collection defines astream() method);
            ensure only distinct (unique) numbers are streamed;
            check if “any match”. You should get true for this.

            b. stream the List again (this is necessary because once a stream is closed by a previous terminaloperation,
            you must re-create the stream);
            check to see if “none match” the expression x%11>0.
            Note that the terminal operation noneMatch(Predicate) needs to return false for every element
            in the stream for noneMatch() to return true.
            In other words, “none of them match this….that’s correct, none of them do; return true”.
            You should get true here as well.
        */

        List<Integer> ls = Arrays.asList(11, 12, 22, 33, 33, 55, 66);
          boolean b1 = ls.stream()
                .distinct()
                .peek(p -> System.out.println("case-a: " + p))
                .anyMatch(i -> i != null) ;// public interface Predicate<T> {  //  boolean test(T t);


        boolean b2 = ls.stream()
                .peek(p -> System.out.println("case-b: " + p))
                .noneMatch(i -> i % 11 > 0)    // nieparzyste // public interface Predicate<T> {  //  boolean test(T t);
                ;



        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i != null;
            }
        };
        Predicate<Integer> predicate2 = i -> i != null;




                // 1. distinct()
//        System.out.println("distinct");
//        ls.stream()
//            .distinct()
//            .forEach(n -> System.out.println(n));  // 11, 22, 33, 55, 66
        // Java only generates the amount of stream you need (lazy evaluation).
//        System.out.println("\nanyMatch");
//        System.out.println(ls.stream()
//                            .distinct()
//                            .peek(System.out::println)
//                            .anyMatch(x -> x==11));// true
        
        System.out.println("\nnoneMatch");
        System.out.println(ls.stream()
                            .peek(System.out::println)
                            .noneMatch(x -> x%11>0));// true
    }
    
}
