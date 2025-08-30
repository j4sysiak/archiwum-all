package com.company;

class Base {
    public static void log() {
        System.out.println("From Base ...");
    }
}

class Derived extends Base {
    public static void log() {
        System.out.println("From Derived ...");
    }
}

public class Test {
    public static void main(String[] args) {
        Base derived = new Derived();
        derived.log(); //Line n2
    }
}