package lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Q2_1826 {

    public static Optional<String> getGrade(int marks){
        Optional<String> grade = Optional.empty();
        if(marks>50){
            grade = Optional.of("PASS");
        }
        else {
            grade.of("FAIL");// Optionals are immutable!
        }
        return grade;
    }
    public static void main(String[] args) {




        /*
        Code a method public static Optional<String> getGrade(int marks) (QID 2.1826)
    a. in the method getGrade:
        i. declare an empty optional, typed for String called grade
        ii. insert the following code:
            if (marks > 50) {grade = Optional.of(“PASS”);} else {grade.of(“FAIL”);}
    b. in main():
        i. declare an Optional, typed for String named grade1 which is initialised to the return value of calling getGrade(50)
        ii. declare an Optional, typed for String named grade2 which is initialised to the return value of calling getGrade(55)
        iii. using orElse() on grade1, output the value of grade1 or “UNKNOWN”
        iv. if(grade2.isPresent()) is true: use ifPresent(Consumer) to output the contents of grade2; if false, use orElse() to output the contents of grade2 or “Empty”
        v. Notes:
            1. Optional’s are immutable.
            2. Optional.of(null); // NullPointerException
            3. Optional.ofNullable(null); // Optional.empty returned
        */



        Optional<String> grade1 = getGrade(50);// returns an empty Optional
        Optional<String> grade2 = getGrade(55);// returns "PASS" Optional
        System.out.println(grade1.orElse("UNKNOWN"));// UNKNOWN
        if(grade2.isPresent()){
            grade2.ifPresent(x -> System.out.println(x));// PASS
        }else{
            System.out.println(grade2.orElse("Empty"));
        }


       //Możesz zastąpić warunek if-else używając Optional i strumieni (Stream) w następujący sposób:

        IntStream intStream = Stream.of(99, 22)
                .map(val -> Stream.of(22, 99, 11)
                        .filter(v -> v.equals(val))
                        .findAny()
                        .orElse(null))
                .mapToInt(v -> v);
        int[] ints = intStream.toArray();


        //ToIntFunction<? super T> mapper  ma metodę    int applyAsInt(T value);
        ToIntFunction<Integer> function22 = new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
        };
        ToIntFunction<Integer> function222 = i -> i;

        Supplier<Integer> supplier11 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return null;
            }
        };

        List<String> list = Stream.of("Wartość", "Wartość 2")
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        List<String> list2 = Stream.of("Wartość", "Wartość 2")
                .map(val -> Stream.of("Wartość 1", "Wartość 2")
                        .filter(v -> v.equals(val))
                        .findAny()
                        .orElse("KAK"))
                .collect(Collectors.toCollection(ArrayList::new));

        Supplier<List<String>> supplier22 = new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                return new ArrayList<>();
            }
        };



        Function<String, Optional<String>> function = new Function<String, Optional<String>>() {
            @Override
            public Optional<String> apply(String val) {
                return Stream.of("Wartość", "Wartość 2")
                        .filter(s -> s.equals(val))
                        .findAny()
                        ;
            }
        };
        Function<String, Optional<String>> function2 = val -> (Stream.of("Wartość", "Wartość 2")
                .filter(s -> s.equals(val))
                .findAny());

        // public interface Function<T, R> { ma tedodę: R apply(T t);
        //public interface Predicate<T> {  ma tedodę:  boolean test(T t);
        //public interface Supplier<T> {  T get();

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Brak dopasowania";
            }
        };
        Supplier<String> supplier2 = () ->  "Brak dopasowania";
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("kaka");
            }
        };

        Optional<String> optionalValue = Optional.of("Wartość 1");

        //Optional<Optional<String>> wartość ;
        Optional<Optional<String>> s1 = optionalValue.map(val -> Stream.of("Wartość", "Wartość 2")
                                                        .filter(v -> v.equals(val))
                                                        .findAny() );

        Optional<String> s12 = optionalValue.map(val -> Stream.of("Wartość 1", "Wartość 2")
                                                            .filter(v -> v.equals(val))
                                                            .findAny()
                                                            .orElse("KAK") );
        s12.ifPresent(System.out::println);  //"Wartość 1"
        String s = s12.toString();


        String kak1 = optionalValue.map(val -> Stream.of("Wartość 1", "Wartość 2")
                .filter(v -> v.equals(val))
                .findAny()
                .orElse("KAK")).toString();

        Optional<Stream<String>> wartość = optionalValue.map(val -> Stream.of("Wartość", "Wartość 2"));
        Consumer<String> action = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        s1.ifPresent(System.out::println);


        optionalValue
                .map(val -> Stream.of("Wartość", "Wartość 2")
                        .filter(v -> v.equals(val))
                        .findAny()
                        .orElse("Brak dopasowania"))
                .ifPresent(System.out::println);

    }




}

