package com.company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Osoba implements Cloneable {
    private String imie;
    private Adres adres;

    public Osoba(String imie, Adres adres) {
        this.imie = imie;
        this.adres = adres;
    }

    public Object cloning()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    //deepCopy  - nadpisujemy sobie oryginalną metodę clone() z klasy Object
    public Object clone() {
        Osoba osoba = null;
        try {
            //Note that the super.clone() call returns a shallow copy of an object,
            // but we set deep copies of mutable fields manually, so the result is correct:
            osoba = (Osoba) super.clone();
        } catch (CloneNotSupportedException e) {
            //only shallow clone
            osoba = new Osoba(
                    this.imie, this.getAdres());
        }
        //deep clone
        osoba.adres = (Adres) this.adres.clone();
        return osoba;
    }
}