package com.company.szkolenie1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public
class StreamsExample {

    //https://www.youtube.com/watch?v=q4s0aE3FnCA

    List<Employee> employees = new ArrayList();

    @BeforeEach
    public void setUp() {
        Employee employees1 = new Employee("Buckingham", "Banglesnatch", 19, List.of("aaa", "bbb", "ccc"));
        Employee employees2 = new Employee("Bourgeoisie", "Capitalist", 44, List.of("bbb", "ccc", "ddd"));
        Employee employees3 = new Employee("Bodybuild", "Creamsicle", 41, List.of("ggg", "ddd", "iii"));
        Employee employees4 = new Employee("Rumblesacka", "Concubine", 55, List.of("sss", "bbb", "ccc"));
        Employee employees5 = new Employee("Congleton", "Carrotpatch", 22, List.of("hhh", "bbb", "ooo"));
        Employee employees6 = new Employee("Syphilis", "Pumpkinpatch", 33, List.of("aaa", "jjj", "ccc"));
        Employee employees7 = new Employee("Liverswort", "Creamsicle", 76, List.of("eee", "sss", "ccc"));

        employees.add(employees1);
        employees.add(employees2);
        employees.add(employees3);
        employees.add(employees4);
        employees.add(employees5);
        employees.add(employees6);
        employees.add(employees7);
    }

    @Test
    public void firstSream() {
        employees.stream().forEach(empl -> System.out.println("employee: " + empl));

        employees.forEach(System.out::println);
    }

    @Test
    public void mapOperation() {
        employees.stream()
                .map(empl -> empl.getFirstName() + " " + empl.getLastName())
                .forEach(empl -> System.out.println("empl: " + empl));

        employees.stream().map(Employee::getFirstName).forEach(System.out::println);
    }

    @Test
    public void flatMapOperation() {

        //lista list: List<List<String>>
        List<List<String>> list1OfSkills = employees.stream()
                .map(empl -> empl.getSkills())
                .collect(Collectors.toList());

        System.out.println(list1OfSkills);  // [[aaa, bbb, ccc], [bbb, ccc, ddd], [ggg, ddd, iii], [sss, bbb, ccc], [hhh, bbb, ooo], [aaa, jjj, ccc], [eee, sss, ccc]]

        /*płaska lista: flatMap  List<String>*/
        List<String> list2OfSkills = employees.stream()
                .map(Employee::getSkills)
                .flatMap(list -> list.stream())
                .distinct()  /*niepowtarzalne wartości*/
                .collect(Collectors.toList());

        System.out.println(list2OfSkills);
    }


    @Test
    public void filterOperation() {
        employees.stream()
                .filter(empl -> empl.getFirstName().startsWith("B"))
                .forEach(System.out::println)
        ;
    }


    @Test
    public void sortedOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(System.out::println)
        ;
    }

    @Test
    public void limitOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .limit(2)
                .forEach(System.out::println)
        ;
    }

    @Test
    public void skipOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .skip(2)  // pomijamy dwa pierwsze elementy
                .forEach(System.out::println)
        ;
    }

    @Test
    public void countOperation() {

        long numberOfEmployees = employees.stream()
                .filter(empl -> empl.getFirstName().startsWith("B"))
                .count();

        System.out.println(numberOfEmployees);
    }

    @Test
    public void minMaxOperation() {

        Employee youngestEmployees = employees.stream()
                .min(Comparator.comparing(Employee::getAge)).get();

        System.out.println(youngestEmployees);

        Employee oldestEmployees = employees.stream()
                .max(Comparator.comparing(Employee::getAge)).get();

        System.out.println(oldestEmployees);
    }


    @Test
    public void findAnyFindFirstOperation() {

        Employee findAnyEmployees = employees.stream()
                .filter(empl -> empl.getFirstName().startsWith("B"))
                .findAny().get();

        System.out.println(findAnyEmployees);
    }

    @Test
    public void matchOperation() {

        Boolean isMatchEmployees = employees.stream()
//            .allMatch(empl -> empl.getFirstName().startsWith("B"));
//        .anyMatch(empl -> empl.getFirstName().contains("a"));
                .noneMatch(empl -> empl.getFirstName().contains("Z"));

        System.out.println(isMatchEmployees);
    }

    @Test
    public void reduceOperation() {

        Integer sumOfAllAges1 = employees.stream()
                .map(Employee::getAge)
                //.reduce((age1, age2) -> age1 + age2)   lub
                .reduce(Integer::sum)
                .get();

        System.out.println(sumOfAllAges1);


        int sumOfAllAges2 = employees.stream()
                .map(Employee::getAge)
                //.reduce(0, (age1, age2) -> age1 + age2)   LUB
                .reduce(0, Integer::sum)
                .intValue();
        System.out.println(sumOfAllAges2);


        Integer sumOfAllAges3 = employees.stream()
                .reduce(0, (tmpAge, empl) -> tmpAge + empl.getAge(), Integer::sum);

        System.out.println(sumOfAllAges2);


        String allNamesWithColons = employees.stream()
                .map(Employee::getFirstName)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .get();
        System.out.println(allNamesWithColons);  //Buckingham, Bourgeoisie, Bodybuild, Rumblesacka, Congleton, Syphilis, Liverswort
    }

    @Test
    public void takeWhileOperation() {
        /*bierze elementy streama dopóki spełniony jest predykat*/
        /*wyświetla pracowników do 30 roku życia*/
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))  // musi być posortowany stream
                .takeWhile(empl -> empl.getAge() < 30)
                .forEach(System.out::println);
    }

    @Test
    public void dropWhileOperation() {
        /*pomija elementy streama dopóki spełniony jest predykat*/
        /*wyświetla pracowników od 30 roku życia*/
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))  // musi być posortowany stream
                .dropWhile(empl -> empl.getAge() < 30)
                .forEach(System.out::println);
    }

    @Test
    public void forEachOrdered() {
        String sentence = "Jak nauczyć się programowania";

        /*Wyświetl wszystkie znaki zdania*/
        sentence.chars().forEach(s -> System.out.print((char) s));

        System.out.println("");

        /*Wielowątkowo*/
        sentence.chars().parallel().forEachOrdered(s -> System.out.print((char) s));
    }

    @Test
    public void peekOperation() {
        /*zmiana orginalnej kolekcji - tylko do debuga bo orginalnej kolekcji nie można modyfikować !!!!!!!!!!!!!*/

        List<Employee> newEmployees = employees.stream()
                .peek(empl -> empl.setFirstName("Jacek"))
                .collect(Collectors.toList());

        System.out.println(newEmployees);
        System.out.println(employees);

        employees.stream().forEach(s -> System.out.println(s));  // lub
        newEmployees.forEach(System.out::println);

    }

    @Test
    void findEmployee() {
        System.out.println("sssssssssss");
        Person person = new Person(1, "aa");
        assertNotNull(person);
    }

}

























