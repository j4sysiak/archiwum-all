package com.company;

public class HPLaserJet2233  implements IPrinter, IScanner, IFax {
    @Override
    public void printGray(String context) {
        System.out.println("HPLaserJet2233 printGray  ...");
    }

    @Override
    public void printColor(String context) {
        System.out.println("HPLaserJet2233 printColor ...");
    }

    @Override
    public void scan(String context) {
        System.out.println("HPLaserJet2233 scan ...");
    }

    @Override
    public void fax(String context) {
        System.out.println("HPLaserJet2233 fax ...");
    }
}
