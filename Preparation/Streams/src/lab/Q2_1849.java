package lab;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Q2_1849 {
    public static void main(String[] args) {

        /* (QID 2.1849)
        A question about Optional. Let us look at this in parts:
            a. Declare an Optional, typed for Double, named ‘price’ using the Optional.ofNullable(20.0).
                Output the Optional value for ‘price’ 3 times:
                - using ifPresent(Consumer),
                - orElse(T)
                - orElseGet(Supplier).
            b. declare a new Optional, typed for Double, named ‘price2’ (or comment out (a) and re-use ‘price’). Use Optional.ofNullable again but this time, pass in null.
                i. Output ‘price2’ in a normal System.out.println().
                ii. check to see if price2 isEmpty() and if so output “empty”.
                iii. do (ii) again except this time use the more functional “ifPresent(Consumer)” method.
                iv. initialise a Double x to the return of “price2.orElse(44.0)”. Output and observe the value of x.
            c. declare a new Optional, typed for Double, named ‘price3’ (or comment out (b) and re-use ‘price’).
               Use Optional.ofNullable passing in null.
                i. initialise a Double z to the return of “price3.orElseThrow(() -> new RuntimeException(“Bad Code”). Output and observe the value of z.
        */

        //a

        Optional<Double> price = Optional.ofNullable(null);

         price.ifPresent(d -> System.out.println(d));  //public interface Consumer<T> {  ma tetodę: void accept(T t);

        Consumer<Double> consumer = new Consumer<Double>() {
            @Override
            public void accept(Double d) {
                System.out.println(d);
            }
        };
        Consumer<Double> lamconsumer = d -> System.out.println(d);


        double dobl1 = price.orElseGet(() -> Double.NaN) ; // public interface Supplier<T> {  ma metodę:  T get();
        double dobl2 = price.orElse(Double.NaN) ;

        Supplier<Double> supplier = new Supplier<Double>() {
            @Override
            public Double get() {
                return Double.NaN;
            }
        };
        Supplier<Double> lamsupplier = () -> Double.NaN;



        //b
//         declare a new Optional, typed for Double, named ‘price2’ (or comment out (a) and re-use ‘price’).
//           Use Optional.ofNullable again but this time, pass in null.
//                i. Output ‘price2’ in a normal System.out.println().
//                ii. check to see if price2 isEmpty() and if so output “empty”.
//                iii. do (ii) again except this time use the more functional “ifPresent(Consumer)” method.
//                iv. initialise a Double x to the return of “price2.orElse(44.0)”. Output and observe the value of x.

        Optional<Double> price2 = Optional.ofNullable(null);
        System.out.println("price2: " + price2);

        if (price2.isEmpty()) {
            System.out.println("price2: " + price2);
        }

        price2.ifPresent(d -> System.out.println(d));
        price2.ifPresent(System.out::println);


        //public interface Consumer<T> {  ma matode:  void accept(T t
        Consumer<Double> consumer1 = new Consumer<Double>() {
            @Override
            public void accept(Double d) {
                System.out.println(d);
            }
        };
        Consumer<Double> lamconsumer1 = d -> System.out.println(d);

        Optional<Double> price3 = Optional.ofNullable(20.0);
        Double v = price3.orElse(44.0);

        Optional<Double> price5 = Optional.of(21.1);
        price5.ifPresent(System.out::println);
        price5.ifPresent(d -> System.out.println(d));


        Optional<Double> price6a = Optional.ofNullable(null);

        // Handle the exception gracefully NullPointerException
        try {
            Double x =null;
            Optional<Double> price6b = Optional.of(x);  // if we get null
            price6b.ifPresent(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: Value is null");
            // Handle the exception gracefully
        }

      //  Optional<Double> price7 = Optional.of(null); //  java.lang.NullPointerException
         Optional<Double> price7= Optional.ofNullable(null);
         Double z = price7.orElseThrow(()->new RuntimeException("Bad Code"));//java.lang.RuntimeException: Bad Code





        // Q asked on YT:
//        Optional<Double> price = Optional.ofNullable(null); // null passed in
//        System.out.println(price); // Optional.empty
//        Double x = price.orElse(null);
//        System.out.println(x); // null
//        Double x2 = price.orElseGet(()->null);// Supplier
//        System.out.println(x2); // null
        
        
        // ofNullable explained:
        //      Optional o = Optional.ofNullable(value)
        //          is the same as:
        //      Optional o = (value == null) ? Optional.empty() : Optional.of(value)
//        Optional<Double> price = Optional.ofNullable(20.0);
//        price.ifPresent(System.out::println);// 20.0
//        Double x = price.orElse(22.0);
//        System.out.println(x);// 20.0
//        Double x2 = price.orElseGet(()->33.0);// Supplier
//        System.out.println(x);// 20.0

//        Optional<Double> price = Optional.ofNullable(null); // null passed in
//        System.out.println(price); // Optional.empty
//        if (price.isEmpty()){
//            System.out.println("empty");// "empty"
//        }
//        price.ifPresent(System.out::println);// nothing
//        Double x = price.orElse(44.0);
//        System.out.println(x);// 44.0
        
        // Option 1 generates a java.lang.NullPointerException; use ofNullable
//        Optional<Double> price = Optional.of(null);
        
        // Option 4 does not compile - Optional.of(T t) takes one argument
//        Optional<Double> price = Optional.of(21.1, 10.0);

        // Option 5
//        Optional<Double> price = Optional.of(null); //  java.lang.NullPointerException
//        Optional<Double> price = Optional.ofNullable(null); 
        // Note: no "throw" in Supplier in next statement
//        Double z = 
//          price.orElseThrow(()->new RuntimeException("Bad Code"));//java.lang.RuntimeException: Bad Code
//        System.out.println(z);
    }
    
}
