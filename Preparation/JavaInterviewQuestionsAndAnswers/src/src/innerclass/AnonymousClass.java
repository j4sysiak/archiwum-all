package src.innerclass;

import java.util.Arrays;
import java.util.Comparator;

class Animal {
    void bark() {
        System.out.println("Animal Bark");
    }
}

class Vehicle {
    void go() {
        System.out.println("Vehicles go ...");
    }
}

public class AnonymousClass {

    private static String[] reverseSort(String[] array) {

        Comparator<String> reverseComparator = new Comparator<>() {
            /* Anonymous Class */
            @Override
            public int compare(String string1, String string2) {
                return string2.compareTo(string1);
            }

        };
		Comparator<String> reverseComparatorLambda1 = (s1, s2) -> s2.compareTo(s1);
		Comparator<String> reverseComparatorLambda2 = Comparator.reverseOrder();

        Arrays.sort(array, reverseComparator);
        return array;
    }

    public static void main(String[] args) {

        String[] array = {"Apple", "Cat", "Boy"};

        System.out.println(Arrays.toString(reverseSort(array))); // [Cat, Boy, Apple]

        /* Second Anonymous Class - SubClass of Animal */
        Animal animal = new Animal() {
            @Override
            void bark() {
                System.out.println("Subclass bark");
            }
        };

        animal.bark();// Subclass bark

        Animal animal1 = new Animal();
        animal1.bark();


        Vehicle vehicle = new Vehicle() {
			/* Anonymous Class Vehicle  - SubClass of Vehicle */
            @Override
            void go() {
                System.out.println("Vehicles goes from Anonymous Class");
            }
        };

        vehicle.go();  //Vehicles goes from Anonymous Class

		Vehicle vehicle2 = new Vehicle();
		vehicle2.go();  //Vehicles go ...
    }

}
