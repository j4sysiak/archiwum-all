package com.company.item8;

public class ABCD {
    static int stat = 200;
    int x = 100;

    static void staticMethod() {
        System.out.println("Calling from staticMethod() in ABCD");
    }

    void noneStaticMethod() {
        System.out.println("Calling from noneStaticMethod() in ABCD");
    }
}
