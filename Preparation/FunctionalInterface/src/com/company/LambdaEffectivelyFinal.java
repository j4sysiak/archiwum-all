package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEffectivelyFinal {

    String name = "";
    
    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>();
        al.add ("John");

        int x = 12; // final or effectively final
        // x++;  cannot change
        // Lambdas take a snapshot/picture of local variables; these local
        // variables MUST NOT change. Only setting up lambda here.

        /*
        Predicate<T> predicate = new Predicate<T>() {
            @Override
            public boolean test(T t) {
                return false;
            }
        };
        // lambdas
        Predicate<String> lamPredicate = (String) -> false;
        Boolean b = lamPredicate.test("dupa");
        System.out.println(b);
        */

        Predicate<String> lambda = s -> {
            //x++;
            new LambdaEffectivelyFinal().name = "Kennedy";  // instance/class vars are ok
            System.out.println("x == " + x);
            return s.isEmpty() && x % 2 == 0;
        };

        filterData(al, lambda);// lambda views 'x' as 12
        System.out.println(al);
        
        new LambdaEffectivelyFinal().name = "Sean"; // instance/class vars are ok
        
        // If 'x' was allowed to change, then the method and the lambda would 
        // have 2 different views of 'x'!
        // x++;
        filterData(al, lambda);// lambda views 'x' as 12
        // some code...
        
    }

    public static void filterData(List<String> list, Predicate<String> lambda) {
       Iterator<String> i = list.iterator();
       while(i.hasNext()) {
            if(lambda.test(i.next())) {  // executing lambda here
                 i.remove();
            }
       }
    }
    
}
