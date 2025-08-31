package com.company;

import java.util.function.Predicate;

@FunctionalInterface
interface Evaluate<T> {
    boolean isNegative(T t); // similar to Predicate
}

public class  TestPredicate {

     public static void  main(String [] args) {

         //classic behaving
         Evaluate<Integer> evaluate = new Evaluate<>() {
             @Override
             public boolean isNegative(Integer i) {
                 return i < 0;
             }
         };
         evaluate.isNegative(1);

         // lambda behave
         Evaluate<Integer> evaluate2 = (i) -> i < 0;
         evaluate2.isNegative(1);
         System.out.println(evaluate2.isNegative(-1));

         someCheck(1, evaluate2);
         someCheck(-1, evaluate2);
         someCheck(-1, i -> i < 0);
         someCheck(4, i -> i % 2 == 0);


         // Predicate<T> is a functional interface i.e. one abstract method:
         //      boolean test(T t)
         Predicate<Integer> predicate = i -> i < 0;
         System.out.println("Predicate: " + predicate.test(-1));//true
         System.out.println("Predicate: " + predicate.test(+1));//false

         int x = 4;
         System.out.println("Is "+x+" even? "+someCheck(4, n -> n % 2 == 0));//true
         x=7;
         System.out.println("Is "+x+" even? "+someCheck(7, y -> y % 2 == 0));//false

         String name="Mr. Joe Bloggs";
         System.out.println("Does "+name+" start with Mr. ? "+
                 someCheck("Mr. Joe Bloggs", s -> s.startsWith("Mr.")));//true
         name="Ms. Ann Bloggs";
         System.out.println("Does "+name+" start with Mr. ? "+
                 someCheck("Ms. Ann Bloggs", s -> s.startsWith("Mr.")));//false
     }

    private static <T> boolean someCheck(T t, Evaluate<T> myLambda) {
         return myLambda.isNegative(t);
    }
}









































