package com.company.lab;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicLambdasRart1 {

    public static void main(String[] args) {
    // C:\Users\Jacek\Documents\JAVA\SpringBoot\Preparation\FunctionalInterface\Lambdas+Lab.pdf
    // https://www.udemy.com/course/java8_lambdasandstreams/learn/practice/1439110/introduction#overview

        BasicLambdasRart1 basicLambdas = new BasicLambdasRart1();

        /* 1.
        In main() invoke the consumer() method; in consumer() do the following:
        a) Using a lambda expression, implement the Printable interface (typed for String).
           The relevant method just prints out the String argument it receives.
                Invoke the relevant method, passing in "Printable lambda".
        b) Using both a lambda expression and a method reference, implement 1a using a Consumer.
        */
        basicLambdas.consumer();


       /*
        2. In main() invoke the supplier() method; in supplier() do the following:
        a) Using a lambda expression, implement the Retrievable interface (typed for Integer).
        The relevant (odpowiednia) method just returns 77. Invoke the relevant method.
        b) Using a lambda expression, implement 2a using a Supplier.
        */
        basicLambdas.supplier();

        /*
        3. In main() invoke the predicate() method; in predicate() do the following:
        a) Using a lambda expression, implement the Evaluate interface (typed for Integer). The relevant
        method returns true if the argument passed is < 0, otherwise it returns false. Invoke the relevant
        method twice – the first time pass in -1 and the second time pass in +1
        b) Using a lambda expression, implement 3a using a Predicate.
        c) Declare a generically-typed check() method (not in UML). The first parameter is generic and the
        second parameter is a Predicate, also generically typed. The check() method returns true/false.
        Invoke the check() method with the following Predicate lambda expressions:
             we want to know if a number is even (true) – invoke check() with 4 and 7 (true and false).
             we want to know if a String begins with “Mr.” – invoke check() with “Mr. Joe Bloggs” and “Ms. Ann Bloggs”
             we want to know if a person is an adult (age >= 18) – invoke check() with “Mike” who is 33
              and 1.8 (metres assumed) in height; and “Ann” who is 13 and 1.4 (metres) in height.
        */
        basicLambdas.predicate();

        /* 4.
        In main() invoke the function() method; in function() do the following:
        a) Using a lambda expression, implement the Functionable interface - the input type is Integer and the
        return type is String. The relevant method returns the number passed in appended to the String
        “Number is: ”. Invoke the relevant method passing in 25.
        b) Using a lambda expression, implement 4a using a Function
        */
        basicLambdas.function();

    }

    private void function() {
        // Functionable <T, R> is a functional interface - has one abstract method
        //    R applyThis(T t)  is similar to java.util.function.Function
        //a.
        Functionable <Integer, String> lambda = i -> "Number is: "  + i;
        System.out.println(lambda.applyThis(25));

        // Function <T, R> is a functional interface - has one abstract method
        //    R apply(T t)
        //a.
        Function <Integer, String> function = i -> "Number is: "  + i;
        System.out.println(function.apply(11));
    }

    private void predicate() {
        // Evaluation<T> is a functional interface - has one abstract method
        //    boolean isNegative(T t)  is similar to java.util.function.Predicate
        // a.
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println(lambda.isNegative(-1));
        System.out.println(lambda.isNegative(1));

        // b.
        // Predicate<T> is a functional interface - has one abstract method
        // boolean test(T t)
        Predicate<Integer> predicate = i -> i < 0;
        System.out.println(predicate.test(-1));
        System.out.println(predicate.test(1));

        int x = 4;
        System.out.println("Is: " + checking(x, n -> n % 2 == 0));

        Person person = new Person("Ann", 19, 1.8);
        System.out.println(person.getName() + " " + checking(person, n -> n.getAge() > 20));

        System.out.println(checking("Jacek", n -> n.startsWith("Ja")));

    }

    private static <T> boolean checking(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    private void consumer() {

        Printable<String> printable = new Printable<String>() {
            @Override
            public void print(String s) {
                System.out.println(s);
            }
        };
        Printable<String> mylambda = s -> System.out.println(s);

        // Printable<T> is a functional interface - has one abstract method
        // void print(T t)  is similar to java.util.function.Consumer
        //a.
        Printable<String> lambda = s -> System.out.println(s);
        lambda.print("Printable lambda");

        //b.
        // Consumer is a functional interface  - has one abstract method
        //   void accept(T t)  is similar to java.util.function.Consumer
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Consumer lambda");

        Consumer<String> consumerMR = System.out::println;
        consumerMR.accept("Consumer method reference");
    }

    private void supplier() {
        // Retrievable<T> is a functional interface - has one abstract method
        //   T retrieve()  is similar to java.util.function.Supplier
        //a.
        Retrievable<Integer> lambda = () -> 77;
        System.out.println("Retrievable generated: " + lambda.retrieve());

        //b.
        // Supplier is a functional interface  - has one abstract method
        //   T get()
        Supplier<Integer> supplier = () -> 77;
        System.out.println("Supplier generated: " + supplier.get());

    }
}





































