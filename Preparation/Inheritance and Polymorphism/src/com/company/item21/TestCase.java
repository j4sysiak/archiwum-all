package com.company.item21;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
ERROR:
  GOLDEN RULE: overriding method cannot add another new checked exception even parent one (IOException parent of FileNotFoundException)
*/

class Graet {
    public void doStuff() throws FileNotFoundException {
        System.out.println("in Great");
    }
}

class Amazing extends Graet {

    @Override
    // public void doStuff() throws FileNotFoundException {  // OK - same exception
    // public void doStuff() throws NullPointerException {  // OK - NullPointerException is RuntimeException not checked exception
      public void doStuff()     {  // OK - it is possible to not have any exception thrown
    // public void doStuff() throws EOFException {  // ERROR: GOLDEN RULE: overriding method cannot add another new checked exception even parent one (EOFException parent of FileNotFoundException)
    // public void doStuff() throws IOException {  // ERROR: GOLDEN RULE: overriding method cannot add another new checked exception even parent one (IOException parent of FileNotFoundException)
        System.out.println("in Amazing");
    }
}

public class TestCase {
    public static void main(String[] args) throws IOException {

        /*
         The compiler always looks at the reference type -  Graet in this example.
         Thus, the compiler works off the signature of doStuff() in class Graet.
         (Zatem kompilator wykorzystuje signature funkcji doStuff() w klasie Graet.)
         However, at runtime, we are dynamically binding (polymorphism) to the object Amazing.
         If the overriding method in Amazing was allowed to throw extra checked exceptions
         that the compiler was not expecting .... will be ERROR.
          Remember, the compiler has verified the code based on exception signature of
         doStuff() in class Graet NOT in doStuff() in class Amazing!!!
        */


        Graet g = new Amazing();
        g.doStuff();

    }
}
















