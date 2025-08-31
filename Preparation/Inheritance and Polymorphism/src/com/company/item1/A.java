package com.company.item1;

public class A {
    final int fi = 101;
}

  class B extends A{
    int fi = 10;

    public static void main(String[] args) {
        B b = new B();
        b.fi =20;

        System.out.println(b.fi); //20
        System.out.println(  ( (A)b ).fi    );  //101
    }
}
