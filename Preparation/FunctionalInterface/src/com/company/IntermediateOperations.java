package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        // doSortedOther();
          doSorted2();
        // doSortedFromBook();
        // doMap();
        // doFlatMap();
        // doLimit();
        // doDistinct();
        // doFilter();

    }

    public static void doSortedOther() {
        // Stream<T> sorted()
        // Stream<T> sorted(Comparator<T> comparator)
        // Output:
        //  0.Tim 1.Tim 0.Jim 1.Jim 0.Peter 0.Ann 1.Ann 0.Mary 2.Ann 3.Ann 2.Jim 3.Jim
        Stream.of("Tim", "Jim", "Peter", "Ann", "Mary")
                .peek(name -> System.out.print(" 0." + name))    // Tim, Jim, Peter, Ann, Mary
                .filter(name -> name.length() == 3)
                .peek(name -> System.out.print(" 1." + name))    // Tim, Jim, Ann
                .sorted()                                      // Tim, Jim, Ann (stored)
                .peek(name -> System.out.print(" 2." + name))    // Ann, Jim
                .limit(2)
                .forEach(name -> System.out.print(" 3." + name));// Ann, Jim

    }

    public static void doSorted2() {

        // Stream<T> sorted(Comparator<? super T> comparator);
        // Stream<T> sorted(Comparator<T> comparator)
        // Output:
        // Person{name=John, age=23}Person{name=Mary, age=25}

        // Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor)
        Function<Person, Integer> keyExtractor = new Function<Person, Integer>() {
            @Override
            public Integer apply(Person p) {
                return p.getAge();
            }
        } ;
        Function<Person, Integer> keyExtractorL = p -> p.getAge();

        Person john = new Person("John", 23);
        Person mary = new Person("Mary", 25);

        Stream<Person> streamPerson = Stream.of(mary, john)
                    //.sorted(Comparator.comparing(Person::getAge))
                    .sorted(Comparator.comparing(keyExtractorL));
        streamPerson.forEach(System.out::print);

        Stream.of(mary, john)
                //.sorted(Comparator.comparing(Person::getAge))
                .sorted(Comparator.comparing(p -> p.getAge()))
                .forEach(System.out::print);

        Comparator<? super Person> comparatorPerson = new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        };
        Comparator<? super Person> comparatorPersonLambda = (p1, p2) -> p1.getAge() - p2.getAge();

        Stream.of(mary, john)
                //.sorted(Comparator.comparing(Person::getAge))
                .sorted(comparatorPersonLambda)
                .forEach(System.out::print);
        System.out.printf("");


    }

    public static void doSortedFromBook() {

        // Stream<T> sorted()
        // Stream<T> sorted(Comparator<T> comparator)
        // Output:
        //  0.Toby 1.Toby - sorted() can't sort yet 
        //                  needs all the data, holds Toby
        //  0.Anna 1.Anna - sorted() can't sort yet, holds Anna 
        //  0.Leroy       - filtered out
        //  0.Alex 1.Alex - sorted() can't sort yet, holds Alex
        //                - Java tells sorted() - "its time to sort"
        //  2.Alex 3.Alex - limit() passes on Alex, Alex is output 
        //  2.Anna 3.Anna - limit() passes on Anna and lets Java know 
        //                  thats 2 of 2; Java lets forEach print Anna
        //                  and then stops the pipeline
        // Note: Toby is not output.
        Stream.of("Toby", "Anna", "Leroy", "Alex")
                .peek(s -> System.out.println(" 0." + s))
                .filter(s -> s.length() == 4)
                .peek(s -> System.out.println(" 1." + s)) // no Leroy
                .sorted() // stores Toby, Anna and Alex
                .peek(s -> System.out.println(" 2." + s))
                .limit(2)
                .forEach(s -> System.out.println(" 3." + s));// no Toby

    }

    public static void doMap() {

        // <R> Stream<R> map(Function<T,R> mapper)
        // na wejściu: String   T=String
        // na wyjściu: Stream<R> gdzie R - będzie Integer
        //     Function's functional method: R apply(T t);

        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 0;
            }
        };
        Function<String, Integer> functionL = s -> s.length();

        Stream<Integer> integerStream = Stream.of("book", "pen", "ruler")
                        .map(functionL);
        integerStream.forEach(System.out::print);

        Stream.of("book", "pen", "ruler")
                .map(s -> s.length()) // String::length
                .forEach(System.out::print);// 435
    }

    public static void doFlatMap() {
        List<String> list1 = Arrays.asList("sean", "desmond");
        List<String> list2 = Arrays.asList("mary", "ann");
        Stream<List<String>> streamOfLists = Stream.of(list1, list2);

        // Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
        // flatMap(Function(T, Stream<R>)) IN:T OUT:R
        // T = List<String>
        // R = Strin
        //  flatMap(Function(List<String>, Stream<String>))

        Function<List<String>, Stream<String>> function = new Function<List<String>, Stream<String>>() {
            @Override
            public Stream<String> apply(List<String> strings) {
                return Stream.empty();
            }
        };
        Function<List<String>, Stream<String>> functionL = strings -> strings.stream();

        Consumer<String> action = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.printf(s);
            }
        };
        Consumer<String> actionL = s -> System.out.printf(s);
        Consumer<String> actionRef = System.out::print;

                streamOfLists
                .flatMap(functionL)  // po tym mam Stream<String>
                .forEach(actionRef);// seandesmondmaryann
    }

    public static void doLimit() {

        // Stream<T> limit(long maxSize)
        // limit is a short-circuiting stateful 
        // intermediate operation. Lazy evaluation - 66, 77, 88 and 99
        // are not streamed as they are not needed (limit of 2 i.e. 44 and 55).
        // Output: 
        //  A - 11 A - 22 A - 33 A - 44 B - 44 C - 44 A - 55 B - 55 C - 55
        Stream.of(11, 22, 33, 44, 55, 66, 77, 88, 99)
                .peek(n -> System.out.print(" A - " + n))
                .filter(n -> n > 40)
                .peek(n -> System.out.print(" B - " + n))
                .limit(2)
                .forEach(n -> System.out.print(" C - " + n));
    }

    public static void doDistinct() {

        // Stream<T> distinct()
        // distinct() is a stateful intermediate operation
        // Output: 1.eagle 2.eagle 1.eagle 1.EAGLE 2.EAGLE
        Stream.of("eagle", "eagle", "EAGLE")
                .peek(s -> System.out.print(" 1." + s))
                .distinct()
                .forEach(s -> System.out.print(" 2." + s));

    }

    public static void doFilter() {

        // Stream<T> filter(Predicate<? super T> predicate);
        // na wejściu mamy String   T=String
        // Stream<String>  filter(Predicate<String> predicate);

        Predicate<String> stringPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
        Predicate<String> stringPredicateL = s -> s.length() > 5;

        // Stream<T> filter(Predicate)
        // The filter() method returns a Stream with the elements that
        // MATCH the given predicate.
        Stream.of("galway", "mayo", "roscommon")
                .filter(stringPredicateL)
                .forEach(System.out::print);// galwayroscommon
    }

}


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
