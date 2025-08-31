package com.company.szkolenie3;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Szkolenie3 {

    private final StremMethods stremMethods = new StremMethods();

    @Test
    public void factoryMethodOfOperation1() {

        Stream<String> stream = Stream.of("aaa", "bbb", "ccc");
        stream.forEach(System.out::println);
    }

    @Test
    public void factoryMethodOfOperation2() {

        List<String> list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ccc");
        list.add("ccc");
        list.add(null);

        Stream<String> stream1 = Stream.ofNullable(list).flatMap(Collection::stream);
        stream1.forEach(System.out::println);

        Stream<List<String>> stream2 = Stream.ofNullable(list);  //  stworzony stream2 z jedną listą, tak jakbyśmy tworzyli Optionala
        stream2.forEach(System.out::println);
    }

    @Test
    public void streamBuilderOperation3() {

        Stream.Builder<String> streamBuilder = Stream.builder();
        streamBuilder.add("aaa");
        streamBuilder.add("bbb");

        Stream<String> stream = streamBuilder
                .add("ccc")
                .add("ddd")
                .build();

        stream.forEach(System.out::println);

    }

    @Test
    public void filterOperation() {

        stremMethods.getPersonStream()
                .filter(per -> per.age > 50)
                .forEach(System.out::println);

    }

    @Test
    public void mapOperation() {

        Stream<String> stringStream = stremMethods.getPersonStream()
                .map(per -> per.getName());   // zmienia obiekt Person na String (name)

        stringStream.forEach(System.out::println);

    }

    @Test
    public void flatMapOperation() {

        /*lista list samochodów   [[car1, car2], [car3], [car4, car5]]*/
        stremMethods.getPersonStream()
                .map(Person::getCars)
                //.flatMap(list -> list.stream())
                .forEach(System.out::println);

        /* lista samochodów [car1, car2, car3, car4, car5]*/
        stremMethods.getPersonStream()
                .map(Person::getCars)
                .flatMap(list -> list.stream())
                .map(Car::getModel)
                .forEach(System.out::println);

        // lub

        /*lista list samochodów   [[car1, car2], [car3], [car4, car5]]*/
        List<List<Car>> listaList = stremMethods.getPersonStream()
                .map(Person::getCars)
                //.flatMap(list -> list.stream())
                .collect(Collectors.toList());
        //.forEach(System.out::println);

        listaList.forEach(System.out::println);

        /* lista samochodów [car1, car2, car3, car4, car5]*/
        List<String> lista = stremMethods.getPersonStream()
                .map(Person::getCars)
                .flatMap(list -> list.stream())
                .map(Car::getModel)
                .collect(Collectors.toList());
        //  .forEach(System.out::println);

        lista.forEach(System.out::println);

        System.out.println("sssssssssss");
    }

    @Test
    public void flatMapDistinctOperation() {

        Stream<String> distinctModel = stremMethods.getPersonStream()
                .map(Person::getCars)// bierze listę w której są listy samochodów przynależące do osoby
                .flatMap(list -> list.stream())   // spłaszenie Listy List  - wyciąga z listy listy wszystkie samochody i wrzuca do jednego worka - listy
                .map(Car::getModel)               // wyciąga tylko marki samochodów - w efekcie pozostanie tylko lista marek samochodów
                .distinct();                    // tylko unikalne marki samochodów

        distinctModel.forEach(System.out::println);
    }

    @Test
    public void flatMapDistinctSortOperation() {

        Stream<String> distinctModel = stremMethods.getPersonStream()
                .map(Person::getCars)// bierze listę w której są listy samochodów przynależące do osoby
                .flatMap(list -> list.stream())   // spłaszenie Listy List  - wyciąga z listy listy wszystkie samochody i wrzuca do jednego worka - listy
                .map(Car::getModel)               // wyciąga tylko marki samochodów - w efekcie pozostanie tylko lista marek samochodów
                .distinct()                    // tylko unikalne marki samochodów
                .sorted(Comparator.reverseOrder());             // i sortujem  sorted() - defaultowa od A-Z
        distinctModel.forEach(System.out::println);
    }

    @Test
    public void sortowaniePersonZaPomocaWiekuOperation() {

        stremMethods.getPersonStream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .forEach(System.out::println);
    }

    @Test
    public void sortowanie_Order_By_Age_Wage() {

        stremMethods.getPersonStream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getWage))
                .forEach(System.out::println);

//        Person(name=Bodybuild, surname=Creamsicle, age=19, wage=1000, cars=[Car(model=Toyota, year=2018), Car(model=Lancia, year=2026), Car(model=Audi, year=2025)])
//        Person(name=Buckingham, surname=Banglesnatch, age=19, wage=7000, cars=[Car(model=Toyota, year=2018)])
//        Person(name=Bourgeoisie, surname=Capitalist, age=19, wage=8900, cars=[Car(model=Toyota, year=2018)])
//        Person(name=Rumblesacka, surname=Concubine, age=44, wage=6655, cars=[Car(model=Prawi, year=2021), Car(model=Beta, year=2027)])
//        Person(name=Congleton, surname=Carrotpatch, age=55, wage=2345, cars=[Car(model=Lewi, year=2022), Car(model=Gamma, year=2028)])
//        Person(name=Liverswort, surname=Creamsicle, age=66, wage=8877, cars=[Car(model=Magia, year=2023), Car(model=Zaporożec, year=2028)])
    }

    @Test
    public void sortowanie_Order_By_Age_Wage_isReverse() {

        stremMethods.getPersonStream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Comparator.comparing(Person::getWage).reversed()))
                .forEach(System.out::println);

        // lub
        Comparator<Person> personComparator = Comparator.comparing(Person::getWage).reversed();
        stremMethods.getPersonStream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(personComparator))
                .forEach(System.out::println);

//        Person(name=Bourgeoisie, surname=Capitalist, age=19, wage=8900, cars=[Car(model=Toyota, year=2018)])
//        Person(name=Buckingham, surname=Banglesnatch, age=19, wage=7000, cars=[Car(model=Toyota, year=2018)])
//        Person(name=Bodybuild, surname=Creamsicle, age=19, wage=1000, cars=[Car(model=Toyota, year=2018), Car(model=Lancia, year=2026), Car(model=Audi, year=2025)])
//        Person(name=Rumblesacka, surname=Concubine, age=44, wage=6655, cars=[Car(model=Prawi, year=2021), Car(model=Beta, year=2027)])
//        Person(name=Congleton, surname=Carrotpatch, age=55, wage=2345, cars=[Car(model=Lewi, year=2022), Car(model=Gamma, year=2028)])
//        Person(name=Liverswort, surname=Creamsicle, age=66, wage=8877, cars=[Car(model=Magia, year=2023), Car(model=Zaporożec, year=2028)])
    }

    @Test
    public void peekOperation() {

        stremMethods.getPersonStream()
                .peek(person -> toService(person))
                .forEach(System.out::println);
    }

    private void toService(Person person) {
        //do sth with element Person
        System.out.println("Załadowano nazwisko osoby: = " + person.getName());
    }

    @Test
    public void limitOperation() {

        stremMethods.getPersonStream()
                .skip(2)   // zaczynając od drugiego elemntu
                .limit(2)  // pokazuje tylko 2 elemnty
                .forEach(System.out::println);
    }

    @Test
    public void funkcjaZbierajacaCollect() {

        Set<String> collect = stremMethods.getPersonStream()
                .map(Person::getName)
                .collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println(collect.getClass());

        List<BigDecimal> linkedListCollection = stremMethods.getPersonStream()
                .map(Person::getWage)
                //.collect(Collectors.toCollection(() -> new LinkedList<BigDecimal>()));  // lub
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(linkedListCollection);
        System.out.println(linkedListCollection.getClass());
    }

    @Test
    public void stworzenieStringaZeStreamu() {

        String string = stremMethods.getPersonStream()
                .map(Person::getName)
                .collect(Collectors.joining(" - ", "s: [", "]"));
        System.out.println(string);  //  s: [Buckingham - Bourgeoisie - Bodybuild - Rumblesacka - Congleton - Liverswort]
    }

    @Test
    public void mapToInt() {

        IntStream intStream = stremMethods.getPersonStream()
                .mapToInt(Person::getAge);   // lub .mapToInt(p -> p.getAge());

        System.out.println(intStream.min());
    }

    @Test
    public void takeWhile() {

        /* musi być jednak stream posortowany*/
        stremMethods.getPersonStream()
                .takeWhile(person -> person.getAge() > 18)  // pobiera elementy po kolei, aż ten warunek przestaje być spełniony: czyli bierze wszystkich z wiekiem > 20
                // jeżeli natrafi na osobę, której wiek jest <20 to przerywa stream i wychodzi z pętli !!!
                .forEach(System.out::println);
    }

    @Test
    public void dropWhile() {

        /* musi być jednak stream posortowany*/
        stremMethods.getPersonStream()
                .dropWhile(person -> person.getAge() > 18)  // ucina początkowe elementy, które spełniają warunek wiek > 20
                // zaczyna przetwarzanie elementów, gdy warunek jest prawdziwy
                .forEach(System.out::println);
    }

    @Test
    public void min() {

        Optional<Person> _max = stremMethods.getPersonStream()
                .min(Comparator.comparing(Person::getAge));
        System.out.println(_max);
    }

    @Test
    public void parallel() throws ExecutionException, InterruptedException {

        stremMethods.getPersonStream()
                .parallel()  // obiekty są przetwarza nierównolegle - nie mam kolejności
                .map(Person::getName)
                .sorted() // nie będzie używany - chociaż jest - chyba, że użyjemy forEachOrdered(System.out::println)
                .forEachOrdered(System.out::println);

        List<String> list = Stream.generate(new AtomicInteger()::getAndIncrement)
                .parallel()
                .limit(10)
                .map(integer -> integer + " " + Thread.currentThread().getName())
                .collect(Collectors.toList());

        //System.out.println(list);  //lub
        list.forEach(System.out::println);


        System.out.println("--------------- obsługa wyjątków, parallel()");
        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        List<String> list2 = customThreadPool.submit(() ->
                Stream.generate(new AtomicInteger()::getAndIncrement)
                        .parallel()
                        .limit(1000)
                        .map(integer -> integer + " " + Thread.currentThread().getName())
                        .collect(Collectors.toList())
        ).get();

        //System.out.println(list2);  //lub
        list2.forEach(System.out::println);
    }

    @Test
    public void reduce() {

        Optional<Double> d = Optional.of(stremMethods.getPersonStream()
                .map(Person::getWage)
                .mapToDouble(BigDecimal::doubleValue).sum());

        System.out.println(d);  //34777.0


        System.out.println("-------------------reduce2");
        //lub z reduce
        Optional<BigDecimal> reduce2 = stremMethods.getPersonStream()
                .map(Person::getWage)
                //.reduce(BigDecimal::add);  // zebrać wszystkie pinią   //lub
                //.reduce((bigDecimal, dec) -> bigDecimal.add(dec));  // lub
                .reduce((bigDecimal, dec) -> {
                    return bigDecimal.add(dec);
                });
        System.out.println(reduce2);  //Optional[34777]

        System.out.println("-------------------reduce4");
        BigDecimal reduce4 = stremMethods.getPersonStream()
                .map(Person::getWage)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce4);  //Optional[34777]


        System.out.println("-------------------reduce5");
        BigDecimal reduce5 = stremMethods.getPersonStream()
                .map(Person::getWage)
                .reduce(BigDecimal.ZERO,
                        BigDecimal::add,
                        (bigDecimal, accum) -> bigDecimal.add(accum))  // to jest to samo co wyżej
                ;
        System.out.println(reduce5);

        System.out.println("-------------------reduce6");
        BigDecimal reduce6 = stremMethods.getPersonStream()
                .map(Person::getWage)
                .reduce(BigDecimal.ZERO,
                        (bigDecimal, accum) -> {
                            System.out.println(Thread.currentThread().getName() + " accumulator " + bigDecimal + " " + accum);
                            return bigDecimal.add(accum);
                        });
        System.out.println(reduce6);

        System.out.println("-------------------reduce7");
        BigDecimal reduce7 = stremMethods.getPersonStream()
                .parallel()
                .map(Person::getWage)
                .reduce(BigDecimal.ZERO,
                        (bigDecimal, accum) -> {
                            System.out.println(Thread.currentThread().getName() + " accumulator " + bigDecimal + " " + accum);
                            return bigDecimal.add(accum);
                        },
                        (bigDecimal, accum) -> {
                            System.out.println(Thread.currentThread().getName() + " combiner " + bigDecimal + " " + accum);
                            return bigDecimal.add(accum);
                        });
        System.out.println(reduce7);


        System.out.println("-------------------reduce8");
        BigDecimal reduce8 = stremMethods.getPersonStream()
                .reduce(BigDecimal.ZERO,
                        (bigDecimal, person) -> {
                            System.out.println(Thread.currentThread().getName() + " accumulator " + bigDecimal + " " + person);
                            return bigDecimal.add(person.getWage());
                        },
                        (bigDecimal, accum) -> {
                            System.out.println(Thread.currentThread().getName() + " combiner " + bigDecimal + " " + accum);
                            return bigDecimal.add(accum);
                        });
        System.out.println(reduce8);
    }

    @Test
    public void collectMap_v1() {

        Map<String, Integer> collect = stremMethods.getPersonStream()
                .collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println(collect);
        System.out.println(collect.getClass());

        // jak się zabezpieczyć przed Duplicate key 19
        Map<Integer, String> collect2 = stremMethods.getPersonStream()
                .collect(Collectors.toMap(Person::getAge, Person::getName, (s, s1) -> s1));
        System.out.println(collect2);
        System.out.println(collect2.getClass());
    }

    @Test
    public void collectMapGroupingBy() {

        Map<Boolean, List<Person>> collect = stremMethods.getPersonStream()
                .collect(Collectors.groupingBy(person -> person.getAge() >= 18));
        System.out.println(collect);

        Map<Boolean, Set<Person>> collect2 = stremMethods.getPersonStream()
                .collect(Collectors.groupingBy(person -> person.getAge() >= 18, Collectors.toSet()));
        System.out.println(collect2);
    }

    @Test
    public void collectMapGroupingByMapping() {

        // mapping na osobę, więc w mapie będą dwie listy: {false=[Rumblesacka], true=[Buckingham, Bourgeoisie, Bodybuild, Congleton, Liverswort]}
        Map<Boolean, List<String>> collect = stremMethods.getPersonStream()
                .collect(Collectors.groupingBy(person -> person.getAge() >= 18, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(collect);
    }

    @Test
    public void collectMapGroupingByCounting() {

        // ilość osób, które spełniają i niespełniają warunku: {false=1, true=5}
        Map<Boolean, Long> collect = stremMethods.getPersonStream()
                .collect(Collectors.groupingBy(person -> person.getAge() >= 18, Collectors.counting()));
        System.out.println(collect);
    }

    @Test
    public void collectTee() {

//        HashMap<String, Person> collect = stremMethods.getPersonStream()
//                .collect(
//                     Collectors.teeing(
//                        Collectors.minBy(Comparator.comparing(Person::getWage)),
//                        Collectors.maxBy(Comparator.comparing(Person::getWage)),
//                        (min, max) -> {
//                            HashMap<String, Person> myMap = new HashMap<>();
//                            min.isPresent(p -> {
//                                return myMap.put("min", p);
//                            });
//                            max.isPresent(p -> myMap.put("max", p));
//                            return myMap;
//                        }
//                ));
//        System.out.println(collect);
    }

    @Test
    public void fileException() throws IOException {

        Stream<String> lines = Files.lines(Paths.get("README.txt"));
        //UWAGA:  Pozostaje otwarty stream na pliku :((((
        lines.forEach(System.out::println);

        //fileException
        try {
            Stream<String> lines2 = Files.lines(Paths.get("README.txt"));
            lines2.forEach(System.out::println);
        } finally {
            //po wyjściu z  stream na pliku automatycznie się zamknie
        }
    }


}

















