package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q2_1858 {
    public static void main(String[] args) {

        /*
        Given the AnotherBook class (in the zip file), declare a List typed for AnotherBook namely ‘books’ ith the following AnotherBook’s:
            a. title=”Gone with the wind”, genre=”Fiction” (QID 2.1858)
            b. title=”Bourne Ultimatum”, genre=”Thriller”
            c. title=”The Client”, genre=”Thriller”
        Declare the following: List<String> genreList = new ArrayList<>();
        Stream books so that genreList refers to a List containing the genres of the books in the books List.
        */


        List<AnotherBook> books = Arrays.asList(  
                new AnotherBook("Gone with the wind", "Fiction"),        
                new AnotherBook("Bourne Ultimatum", "Thriller"),         
                new AnotherBook("The Client", "Thriller") );

        List<List<String>> list1 = books.stream()
                .map(b -> Arrays.asList(b.getGenre()))   // public interface Function<T, R> {  // R apply(T t);
                .collect(Collectors.toList());

        List<String> genreList = new ArrayList<>();

        Function<AnotherBook, List<String>> function = new Function<AnotherBook, List<String>>() {
            @Override
            public List<String> apply(AnotherBook books) {
                genreList.add(books.getGenre());
                return genreList;
            }
        };
        Function<AnotherBook, List<String>> lamfunction1 = b -> Arrays.asList(b.getGenre());
        Function<AnotherBook, List<String>> lamfunction2 = b -> genreList;


        Stream<List<String>> stream = books.stream()
                 // .map(book -> book.getGenre())     // lambda
                .map(b -> genreList)     // lambda
                ;

        List<String> list2 = books.stream()
                // .map(book -> book.getGenre())     // lambda
                //.map(b -> genreList)     // lambda
                .map(AnotherBook::getGenre)
                .collect(Collectors.toList());




        //public interface Consumer<T> {  void accept(T t);
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };


        Stream<String> stream1 = books.stream()
                .map(book -> book.getGenre());// lambda
//               .map(AnotherBook::getGenre)       // method reference
//                .map(                           // anonymous inner class
//                    new Function(){
//                        @Override
//                        public String apply(Object o){
//                            return ((AnotherBook)o).getGenre();
//                        }
//                    }
//                )
//            .forEach(s->genreList.add(s));    // lambda

        stream1.forEach(genreList::add);  // void  tylko dodaje elementy do istniejącej już listy Stringów
        System.out.println(genreList);


        books.stream()
//            .map(book -> book.getGenre())     // lambda
            .map(AnotherBook::getGenre)       // method reference
//                .map(                           // anonymous inner class
//                    new Function(){
//                        @Override
//                        public String apply(Object o){
//                            return ((AnotherBook)o).getGenre();
//                        }
//                    } 
//                )
//            .forEach(s->genreList.add(s));    // lambda
            .forEach(genreList::add);         // method reference (bound)
//            .forEach(ArrayList::add);         // does not compile!
//                .forEach (                      // anonymous inner class
//                    new Consumer(){
//                        @Override
//                        public void accept(Object o){
//                            genreList.add((String)o);
//                        }
//                    }
//                );
        System.out.println(genreList);
    }

}
