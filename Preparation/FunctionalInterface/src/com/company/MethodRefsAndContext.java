package com.company;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefsAndContext {
    public static void main(String[] args) {
        // No Person being passed in => Supplier
        Supplier<Integer> lambda1 = () -> Personen.howMany();
        Supplier<Integer> mr1     = Personen::howMany;
        System.out.println(lambda1.get());  // 0
        System.out.println(mr1.get());      // 0

        // One Person to be passed in => Function
        Function<Personen, Integer> lambda2 = personen -> Personen.howMany(personen);
        Function<Personen, Integer> mr2     = Personen::howMany;
        System.out.println(lambda2.apply(new Personen()));  // 1
        System.out.println(mr2.apply(new Personen()));      // 1

        // Two Person's to be passed in => BiFunction
        BiFunction<Personen, Personen, Integer> lambda3 = (p1, p2) -> Personen.howMany(p1, p2);
        BiFunction<Personen, Personen, Integer> mr3     = Personen::howMany;
        System.out.println(lambda3.apply(new Personen(), new Personen()));  // 2
        System.out.println(mr3.apply(new Personen(), new Personen()));      // 2
    }
}
class Personen {
    public Personen(String john, int i) {
    }

    public Personen() {

    }

    public static Integer howMany(Personen... people){
        return people.length;
    } 
}