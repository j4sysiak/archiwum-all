package com.company.item19;

/*
Odwołanie do pola statycznego (patrz: Sub.ID) powoduje inicjalizację tylko klasy (patrz: Super) lub interfejsu, który faktycznie je deklaruje,
  nawet jeśli można się do niego odwoływać poprzez nazwę podklasy (patrz: Sub.ID), podinterfejsu lub klasy implementującej interfejs.

 A reference to a static field causes initialization of only the class or interface that actually declares it,
 even though it might be referred to trough the name of a subclass, a subinterface, or a class that implements an interface.
*/
class Super {
    static String ID = "QBANK";
}

class Sub extends Super {
    static {
        System.out.println("In Sub");  // this will be never running
    }
}

public class TestCase {
    public static void main(String[] args) {
        System.out.println(Sub.ID);  // refering to ID from Sub reference
    }
}