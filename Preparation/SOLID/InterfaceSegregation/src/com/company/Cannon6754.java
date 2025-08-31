package com.company;

public class Cannon6754 implements IPrinter, IFax {
    @Override
    public void printGray(String context) {
        System.out.println("Cannon6754 printGray ....");
    }

    @Override
    public void printColor(String context) {
        System.out.println("Cannon6754 printColor ....");
    }

    @Override
    public void fax(String context) {
        System.out.println("Cannon6754 fax ....");
    }
}
