package com.company.item3;

public class Base {
//    Base(){
//        System.out.println("Base");
//    }
    public Object getValue() {
        return new Object();
    }
}
class Base2 extends Base {
//    Base2(){
//        System.out.println("Bas2");
//    }
    public String getValue() {
        return "hello";
    }
}

  class TestCase {

    public static void main(String[] args) {
        Base b = new Base2();
        System.out.println(b.getValue());
    }
}
