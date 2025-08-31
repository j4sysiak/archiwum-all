package com.company;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
class Adres    {
    private String ulica;
    private int numerDomu;

    public Adres(String ulica, int numerDomu) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
    }


    public Object clone() {
        Adres adres = null;
        try {
            // Note that the super.clone() call returns a shallow copy of an object,
            // but we set deep copies of mutable fields manually, so the result is correct:
            adres = (Adres) super.clone();
        } catch (CloneNotSupportedException e) {
            //depp clone
            adres = new Adres(
                    this.getUlica(), this.getNumerDomu());
        }
        return adres;
    }
}