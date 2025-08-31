package lab;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class Q2_1810 {
    public static void main(String[] args) {

        /*
        Given the Person class (in the zip file), declare a List typed for Person with the following Person’s:
            a. name=”Bob”, age=31
            b. name=”Paul”, age=32
            c. name=”John”, age=33
        Pipeline the following where the return type is double: (QID 2.1810)
            - stream the people
            - filter the stream for Person’s whose age is < 30
            - map to int primitives
            - calculate the average age.
        This should generate a NoSuchElementException. Using orElse(), fix the pipeline (not the filter) so that 0.0 is returned instead of an exception being generated.
        */
        
        List<Person> friends = 
                Arrays.asList(  new Person("Bob", "Kelly", 31),
                                new Person("Paul", "Landers", 32),                                 
                                new Person("John", "Paters", 33));

        double d = friends.stream()
                .filter(p -> p.getAge() < 30)    // public interface Predicate<T> {  ma metode:  boolean test(T t);
                .mapToDouble(v -> v.getAge())    ///public interface ToDoubleFunction<T> {  // double applyAsDouble(T value);
                .average()
                .orElse(0)
                ;
        System.out.println(d);

        Predicate<Person> predicate = new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getAge() < 30;
            }
        };
        Predicate<Person> lamPredicate = p -> p.getAge() < 30;

        ToDoubleFunction<Integer> function = new ToDoubleFunction<Integer>() {
            @Override
            public double applyAsDouble(Integer v) {
                return v;
            }
        };
        ToDoubleFunction<Integer> lamFunction = v -> v;



        double averageAge = friends.stream()
                                // Stream<Person> filter(Predicate)
                                .filter(person->person.getAge()<30)     
                                // IntStream mapToInt(ToIntFunction)
                                //    ToIntFunction
                                //       int applyAsInt(T t)
                                .mapToInt(person->person.getAge())   
                                // OptionalDouble average()
                                .average()  
//                                .getAsDouble(); // NoSuchElementException: No value present
                                .orElse(0.0);//0.0
        System.out.println(averageAge);    }
    
}
