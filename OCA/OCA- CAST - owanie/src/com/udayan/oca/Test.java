package com.udayan.oca;

interface I1 {
    void test();
}

class Base implements I1 {
    @Override
    public void test() {
        System.out.println("sss");
    }
}

class Derived1 extends Base {
}
class Derived2 extends Base {
}
class Derived3 extends Base {
}
class Derived4 extends Base {
}


public class Test  {
    public static void main (String ... s) throws Throwable {

      //  Derived2 d = new Derived2();
      //  Base b = new Base();
      //  b = (Base) d;    rzutowanie opcjonalne ----------------- OK
      //  d = (Derived2) b; --------------- kompiluje sie ale: ClassCastException

        int a=10;
        double d = a;

        double d1=10;
        int a1= (int) d1;

        //Going from float to long
        float f=10;
        double l =  f; // Manual casting: double to int

     
    }
}


/*
        Widening Casting (automatically) - converting a smaller type to a larger type size
        byte -> short -> char -> int -> long -> float -> double
        int a=10;
        double b = a;  // Automatic casting: int to double

        Derived1 -> Derived2 -> Derived3 -> Derived4 -> Base
        Derived2 d = new Derived2();
        Base b = (Base) d;  // rzutowanie opcjonalne



        Narrowing Casting (manually) - converting a larger type to a smaller size type
        double -> float -> long -> int -> char -> short -> byte

        double d=10;
        int a = (double) d; // Manual casting: double to int

        Base -> Derived4 -> Derived3 -> Derived2 -> Derived1
        Base b = new Base();
        Derived2 d = (Derived2) b;  // MUSI być jawne rzutowannie,  bez błedu kompilacji ale błąd w Runtime: (ClassCastException)


 */
