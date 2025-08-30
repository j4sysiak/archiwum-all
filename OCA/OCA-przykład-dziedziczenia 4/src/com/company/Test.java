package com.company;

class Base {
    int id = 1000; //Line n1

    Base() {
        Base(); //Line n2
    }

    void Base() { //Line n3
        System.out.println(++id); //Line n4     1000
    }
}

class Derived extends Base {
    int id = 2000; //Line n5

    Derived() {} //Line n6

    void Base() { //Line n7
        System.out.println(id--);  //0
        System.out.println(id);//Line n8   //-1
        System.out.println(++id);   //0
        System.out.println(id);     //0
    }
}

public class Test {
    public static void main(String[] args) {
        Base base = new Derived(); //Line n9
    }
}