package com.company;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        int   in = 0;
        byte by = 0;
        short sh = 0;
        long lo = 0;
        double dou = 0;
        float fl = 0;
        boolean bo = false;
        char ch = 0;

        in++;
        by++;
        sh++;
        lo++;
        dou++;
        fl++;
        System.out.println(bo);
        System.out.println(ch);

        in=by;
        by= (byte) in;

        in=sh;
        sh= (short) in;

        in= (int) lo;
        lo=in;

        in= (int) dou;
        dou=in;

        in= (int) fl;
        fl=in;

        in=ch;
        ch= (char) in;

        dou=fl;
        fl= (float) dou;


        Integer iN = null;
        Byte bY = null;
        Short sH = null;
        Long lO = null;
        Double dO = null;
        Float fL = null;
        Boolean bO = null;
        String sT = null;

        iN++;
        bY++;
        sH++;
        lO++;
        dO++;
        fL++;
        System.out.println(bO);
        System.out.println(sT);

        iN= Integer.valueOf(bY);
        bY=iN;

        iN= Integer.valueOf(sH);
        sH=iN;

        iN= Math.toIntExact(lO);
        lO= Long.valueOf(iN);

        iN=dO;
        dO= Double.valueOf(iN);

        iN=fL;
        fL= Float.valueOf(iN);

        iN= Integer.valueOf(sT);
        sT= String.valueOf(iN);

        dO= Double.valueOf(fL);
        fL=dO;


        //=========================   zamiana małe typy na Duże typy

       iN=in;

       iN= Integer.valueOf(by);

       iN= Integer.valueOf(sh);

       iN= Math.toIntExact(lo);

       iN=dou;
       dou=iN;

       iN=fl;
       fl=iN;

       iN= Integer.valueOf(ch);

       ch= Character.highSurrogate(iN);

        System.out.println("end");
    }
}