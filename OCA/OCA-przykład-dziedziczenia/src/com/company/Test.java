package com.company;

class Auto {
    String notation = "auto";

    //    @Override
    public String toString() {
        return "Auto{" +
                "notation='" + notation + '\'' +
                '}';
    }

    String getNotation() {
        return notation;
    }
    String getTyp() {
        return null;
    }
}

class Mazda extends Auto {
    String notation = "sedan";
    String marka = "MAZDA";
    String typ = "Supra626";

    //    @Override
    public String toString() {
        return "Mazda{" +
                "notation='" + notation + '\'' +
                ", marka='" + marka + '\'' +
                ", typ='" + typ + '\'' +
                '}';
    }

//    @Override
    String getNotation() { //Line n4
        return notation;
    }

    String getMarka() { //Line n4
        return marka;
    }

//    @Override
    String getTyp() { //Line n4
        return typ;
    }
}

public class Test {
    public static void main(String[] args) {

        Auto myAuto = new Mazda();
        System.out.println(myAuto.toString());  //com.company.Mazda@11028347
        System.out.println(myAuto.notation);
        System.out.println(myAuto.getTyp());
        System.out.println(myAuto.getNotation());
    }
}

