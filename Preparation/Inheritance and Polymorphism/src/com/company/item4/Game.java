package com.company.item4;

public class Game {

    public void play() throws Exception {
        System.out.println("Playing ...");
    }
}


class Socker extends Game {

    public void play(String bell) {
        System.out.println("Playing socker with " + bell);
    }

//    @Override
//    public void play() {
//        System.out.println("Playing Socker");
//    }
}


  class TestCase   {

    public static void main(String[] args) throws Exception {

        Game g = new Socker();


        Socker s = (Socker) g;

    }
}
