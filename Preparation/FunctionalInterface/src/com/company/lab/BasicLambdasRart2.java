package com.company.lab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BasicLambdasRart2 {

    public static void main(String[] args) {
        // C:\Users\Jacek\Documents\JAVA\SpringBoot\Preparation\FunctionalInterface\Lambdas+Lab.pdf
        // https://www.udemy.com/course/java8_lambdasandstreams/learn/practice/1439110/introduction#overview

        BasicLambdasRart2 basicLambdasRart2 = new BasicLambdasRart2();

        // 5.
        // In main(), invoke the getPeople() – store the result in a variable named listPeople.
        List<Person> listPeople = getPeople();

        //6
        /*
        In main(), invoke the sortAge() method passing down listPeople; in sortAge() do the following:
        a) Using the Iterable sort() method (note: List extends Iterable), and the Comparator.comparing()
        method, sort the Person objects in ascending age order. Note that the argument to
        Comparator.comparing() requires a Function (In, Out) that returns a Comparable (a class that implements Comparable).
        From that, the comparing() method generates a Comparator that it passes to the sort() method.
         Note that as of Java 8, the List interface supports the sort() method directly so there is no
        need to use the Collections.sort(): i.e. instead of Collections.sort(list, comparatorRef); we now have list.sort(comparatorRef);
        b) Output the sorted list using the Iterable forEach() method passing in a lambda expression.
        */
        basicLambdasRart2.sortAge(listPeople);

        //7
        /*
        In main(), invoke the sortName() method passing down listPeople; in sortName() do the following:
        a) As in 6a except sort the Person objects in ascending name order.
        b) Output the sorted list using the Iterable forEach() method passing in a lambda expression.
        */
        basicLambdasRart2.sortName(listPeople);

        //8
        /*
        In main(), invoke the sortHeight() method passing down listPeople; in sortHeight() do the following:
        a) As in 6a except sort the Person objects in ascending height order.
        b) Output the sorted list using the Iterable forEach() method passing in a lambda expression.
        */
        basicLambdasRart2.sortHeight(listPeople);

    }




    private void sortAge(List<Person> listPeople) {
        // sort by age
        // Note. java.util.List interface supports the sort method directly
        // we do not need use Collection.sort anymore

        // Comparator<? super E> c

        //1-krok
        //  listPeople.sort(    potrzebujemy Comparator<? super E> c     )
        //Comparator comparator = new Comparator() {

        // potrzebujemy jakąś metodę z interfejsem funkcyjnym, który zróci int
        //np  comparing(...)
        //public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
        //        Function<? super T, ? extends U> keyExtractor)

        // Function<Integer, Person> function = new Function() {
        //     @Override
        //      public Integer apply(Person person) {
        //         return person.getAge();
        //     }
        // };

        // doprowadzamy do lambda
        //Function<Person, Integer> function = p -> p.getAge();

        // to nam zwraca Comerator<T> i jesteśmy w domu
        //Comparator<Integer> comparing(p -> p.getAge())


        listPeople.sort(Comparator.comparing(p -> p.getAge()));
        listPeople.sort(Comparator.comparing(Person::getAge));


        // listPeople.forEach(   Consumer<T> c    );
        // potrzebujemy w parametrze obiektu Consumer<T>

        //Consumer<Person> consumer = new Consumer<Person>() {
        //    @Override
        //    public void accept(T t) {
        //       System.out.println(t.getName());
        //    }

        // redukujemy do lambda
        //Consumer<String> consumer = p -> System.out.println(p)

        listPeople.forEach(   p -> System.out.println(p)    );
        listPeople.forEach(    System.out::println     );

    }

    private void sortName(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(p -> p.getName()));
        listPeople.sort(Comparator.comparing(Person::getName));
        listPeople.forEach(   p -> System.out.println(p.getName())    );
    }

    private void sortHeight(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(p -> p.getHeight()));
        listPeople.sort(Comparator.comparing(Person::getHeight));
        listPeople.forEach(   p -> System.out.println(p.getHeight())    );
    }



    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }
}
















































