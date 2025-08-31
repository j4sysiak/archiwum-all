package lab;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Q2_1847 {
    public static void main(String[] args) {

        /*
        Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
            a. title=”Gone with the wind”, price=5.0
            b. title=”Gone with the wind”, price=10.0
            c. title=”Atlas shrugged”, price=15.0

        In a pipeline which has no return type: (QID 2.1847)
        - stream the books
        - using the collect() method, generate a Map that maps the book title to its price
        - using forEach(), output the title and price of each entry in the map
        What happened and why? Fix this by using the Collectors.toMap(Function, Function, inaryOperator) method.
        */

        List<Book> books = Arrays.asList(
                new Book("Gone with the wind", 10.0),
                new Book("Gone with the wind", 20.0),
                new Book("Atlas Shrugged", 15.0));

        Map<String, Double> map = books.stream()
                .collect(Collectors.toMap(e -> e.getTitle(), e -> e.getPrice(), (d1, d2) -> d1 * d2));


        BinaryOperator<Double> operator = new BinaryOperator<Double>() {
            @Override
            public Double apply(Double d1, Double d2) {
                return d1 * d2;
            }
        };
        BinaryOperator<Double> lamoperator = (d1, d2) -> d1 * d2;


        // mamy 2 mozliwosci wyswietlania zawartosci mapy map (biorac pod uwage notacje w lambda):
        //   a. forEach z klasy Map<K, V>
        //   b. forEach z klasy Stream<T>

        //a.
        map.forEach((s, i) -> System.out.println(s + " : " + i));   // argument  default void forEach(BiConsumer<? super K, ? super V> action) {

        BiConsumer<String, Integer> consumer = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer i) {
                System.out.println(s + i);
            }
        };
        BiConsumer<String, Integer> lamconsumer = (s, i) -> System.out.println(s + " : " + i);

        //b
        // robimy set
        Set<Map.Entry<String, Double>> set = map.entrySet();
        set.stream().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));    //  argument   public interface Consumer<T> { ma metodę: void accept(T t);

        Consumer<Map.Entry<Double, String>> entry = new Consumer<Map.Entry<Double, String>>() {
            @Override
            public void accept(Map.Entry<Double, String> e) {
                System.out.println(e.getKey() + " : " + e.getValue());
            }
        };
        Consumer<Map.Entry<Double, String>> lamentry = e -> System.out.println(e.getKey() + " : " + e.getValue());
    }
}
