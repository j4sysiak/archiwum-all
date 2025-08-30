package com.company;

class Auto {
    String notation;

    public Auto(String notation) {
        this.notation = notation;
    }

    public Auto() {
        this.notation = "XXXXXXXXXXXXXXXXXXXXXXXX";
    }

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



class Sedan extends Auto {
    String notation="default";
    String marka;
    String typ;

    public Sedan(String marka, String typ) {
//        super();   nie musi być bo mamy defaultowy konstruktor w klasie bazowej Auto
        this.marka = marka;
        this.typ = typ;
    }
    public Sedan(String notation) {
//        super();   nie musi być bo mamy defaultowy konstruktor w klasie bazowej Auto
        this.notation = notation;
    }

    //    @Override
    public String toString() {
        return "Sedan{" +
                "notation='" + notation + '\'' +
                ", marka='" + marka + '\'' +
                ", typ='" + typ + '\'' +
                '}';
    }

    @Override
    String getNotation() { //Line n4
        return notation;
    }

    String getMarka() { //Line n4
        return marka;
    }

    @Override
    String getTyp() { //Line n4
        return typ;
    }
}



public class Test {
    public static void main(String[] args) {

        Auto myAuto = new Sedan("sedan");
//        Auto myAuto = new Sedan("Toyota", "Corolla");
        System.out.println(myAuto.toString());  //com.company.Sedan@11028347
        System.out.println(myAuto.notation);
        System.out.println(myAuto.getTyp());
        System.out.println(myAuto.getNotation());
    }
}

