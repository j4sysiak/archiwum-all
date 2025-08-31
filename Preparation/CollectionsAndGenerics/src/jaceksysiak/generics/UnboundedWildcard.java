package jaceksysiak.generics;

import jaceksysiak.model.Cat;
import jaceksysiak.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcard {
//    public static void showList(List<Object> list){ 
    public static void showList(List<?> list){ // any type is ok
        for(Object o : list){
            System.out.println(o);
        }
       // list.add("test"); // <?> implies read-only
    }
    public static void main(String[] args) {
        // A different variation
        List<String> names = new ArrayList<String>();
        names.add("Sean");
        showList(names); // List<?> list = new ArrayList<String>();
        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        showList(dogs); // List<?> list = new ArrayList<Dog>();
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        showList(cats); // List<?> list = new ArrayList<Cat>();

        List<String> names2 = new ArrayList<String>();
        names2.add("Sean");
        showList(names2);
    }    
}


