package com.company;

class Furniture {
    public Furniture(String val) { }

    public Furniture() {

    }
}

class Chair extends Furniture {
    public Chair() {
        super();   //1 sposób - ale musi być konstruktor defaultowy w Furniture
//        this(1);   2 sposób - nie musi być konstruktor defaultowy w Furniture  (bo super() nie będzie wywoływane w ogóle (niejawnie))
    }

    public Chair(int val) {
        this("1");
    }

    public Chair(String val) {
        super(val);
    }
}

public class Test {
    public static void main(String[] args) {

        Furniture myFurniture = new Chair();

    }
}