package com.company;

class Base {
    String msg = "INHALE"; //Line n1
}

class Derived extends Base {
    Object msg = "EXHALE"; //Line n2
}

public class Test {
    public static void main(String[] args) {
        Base obj1 = new Base(); //Line n3
        Base obj2 = new Derived(); //Line n4
        Derived obj3 = (Derived) obj2; //Line n5


        if(obj1 instanceof Base && obj1 instanceof Derived) {
            System.out.println("obj1 instanceof Base AND Derived");
        }
        if(obj2 instanceof Base && obj2 instanceof Derived) {
            System.out.println("obj2 instanceof Base AND Derived");
        }
        if(obj3 instanceof Base && obj3 instanceof Derived) {
            System.out.println("obj3 instanceof Base AND Derived");
        }

        String text = obj1.msg + "-" + obj2.msg + "-" + obj3.msg; //Line n6
        System.out.println(text); //Line n7
    }
}