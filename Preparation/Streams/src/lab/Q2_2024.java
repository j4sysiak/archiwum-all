package lab;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Q2_2024 {
    public static void main(String[] args) {

        /*
        There are two parts:
            a. Generate a DoubleStream using the of() method consisting of the numbers 0, 2 and 4.
            Note that this stream is a stream of primitives and not a stream of types.
            Filter in odd numbers (niepazyste) only and sum the remaining stream.
            You should get 0. (QID 2.2024)

            b. Using 1.0 and 3.0, generate a stream of Double’s.
            Map them to primitive double’s.
            Filter in even numbers (parzyste) only and calculate the average.
            Output the result without running the risk of generating an exception.
        */

       // a.
        double sum = DoubleStream.of(0, 2, 4)
                .filter(v -> v % 2 != 0)  // public interface DoublePredicate {  // boolean test(double value);
                .sum()  // 0.0
        ;

        // b.
        Stream<Double> doubleStream = Stream.of(1.0, 3.0);

        Stream.of(1.0, 3.0)
                .mapToDouble(d -> d)  // public interface ToDoubleFunction<T> {  // double applyAsDouble(T value);
                .filter(v -> v % 2 == 0)   // public interface DoublePredicate {   // boolean test(double value)
                .average()
                .ifPresent(v -> System.out.println(v));   // public interface DoubleConsumer {  // void accept(double value);


        DoublePredicate predicate = new DoublePredicate() {
            @Override
            public boolean test(double v) {
                return v % 2 == 0;
            }
        };
        DoublePredicate predicate2 = v -> v % 2 == 0;

        DoubleConsumer consumer = new DoubleConsumer() {
            @Override
            public void accept(double value) {
                System.out.println(value);
            }
        };
        DoubleConsumer consumer2 = v -> System.out.println(v);




                // 1. sum()
        DoubleStream is = DoubleStream.of(0, 2, 4); //1 
        double sum1 = is.filter( i->i%2 != 0 ).sum(); // sum() is a terminal operation (reduction also)
        System.out.println("sum is "+sum); // 0.0

        // 2. average()
        OptionalDouble od = Stream.of(1.0,3.0)
                // DoubleStream mapToDouble(ToDoubleFunction)
                //      ToDoubleFunction
                //          double applyAsDouble(T value);
                                .mapToDouble(n->n.doubleValue())
                                .filter(n -> n%2 == 0)
                                .average();// terminal operation (reduction also)
        if(od.isPresent()){
            System.out.println("average == "+od.getAsDouble());
        }
    }
    
}
