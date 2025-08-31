package src.polimorphism;
class Vehicle {
    int x = 10;
    static int statX = 20;

    void met(){
        System.out.println("from Vehicle: met()");
    }

    static void metStat(){
        System.out.println("from Vehicle: met()");
    }
}

class Car extends Vehicle {
    int x = 100;
    static int statX = 200;

    void met(){
        System.out.println("from Car: met()");
    }

    static void metStat(){
        System.out.println("from Car: metStat()");
    }
}


public class TestPopimorphism {
    public static void main(String[]	args)	{


        Vehicle car =	new Car();
        // car is instance of Vehicle
        // car is instance of Car
        System.out.println(car instanceof Vehicle);  // true
        System.out.println(car instanceof Car);      // true

        // object car is stored in reference variable of type Vehicle. This reference points to some cell of memory in type Car.
        System.out.println(car);  //src.polimorphism.Car@880ec60

        System.out.println(car.x);      // 10 odczyt z Vehicle
        System.out.println(car.statX);  // 20 odczyt z Vehicle
        car.met();       // from Car: met()
        car.metStat();   // from Vehicle: met()


        Car car1 =	new Car();
        System.out.println(car1.x);      // 100 odczyt z Car
        System.out.println(car1.statX);  // 200 odczyt z Car
        car1.met();       // from Car: met()
        car1.metStat();   // from Car: metStat()
    }
}


