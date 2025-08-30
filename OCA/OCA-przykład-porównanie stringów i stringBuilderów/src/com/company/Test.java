package com.company;


public class Test {
    public static void main(String[] args) {

        String str1 = new String("Game on");
        String str2 = new String("Game on");
        System.out.println(str1.equals(str2));   // true
        //metoda equals w klasie String
        //sprawdzenie 1:  jeżeli są to identyczne obiekty  - nie są więc dodatkowe sprawdzenie 2
        //sprawdzenie 2:  jeżeli str2 jest obiektem typu (instanceOf) String - tak jest więc  dodatkowe sprawdzenie 3
        //sprawdzenie 3:  jeżeli zawartość znak po znaku obiektu str1 i str2 są takie same to true - zgada się - na ekranie pojawi się true


        String str3 = "Game on";
        String str4 = "Game on";
        System.out.println(str3.equals(str4));   // true
        //metoda equals w klasie String
        //sprawdzenie 1:  jeżeli są to identyczne obiekty  - zgada się - na ekranie pojawi się true


        System.out.println(str1.equals(str3));   // true
        //metoda equals w klasie String
        //sprawdzenie 1:  jeżeli są to identyczne obiekty  - nie są więc dodatkowe sprawdzenie 2
        //sprawdzenie 2:  jeżeli str3 jest obiektem typu (instanceOf) String - tak jest więc  dodatkowe sprawdzenie 3
        //sprawdzenie 3:  jeżeli zawartość znak po znaku obiektu str1 i str3 są takie same to true - zgada się - na ekranie pojawi się true

        StringBuilder sb1 = new StringBuilder(str1);
        System.out.println(str1.equals(sb1));
        //metoda equals w klasie String
        //sprawdzenie 1:  jeżeli są to identyczne obiekty  - nie są więc dodatkowe sprawdzenie 2
        //sprawdzenie 2:  jeżeli sb1 jest obiektem typu (instanceOf) String - nie jest - więc wychodzimy od razu z false - na ekranie pojawi się false

        System.out.println(sb1.equals(str1));
        //metoda equals w klasie Obiekt
        //sprawdzenie:  jeżeli sb1 jest identyczny obiekt jak str1 - nie jest i od razu mamy false - na ekranie pojawi się false

        StringBuilder sb2 = new StringBuilder(str2);
        System.out.println(sb1.equals(sb2));
        //metoda equals w klasie Obiekt
        //sprawdzenie:  jeżeli sb1 jest identyczny obiekt jak sb2 - nie jest i od razu mamy false - na ekranie pojawi się false



        System.out.println(str1.contentEquals(str2));   //true
        //metoda contentEquals w klasie String
        //sprawdzenie 1:  jeżeli str2 jest typu StrinBuilder - nie jest więc dodatkowe sprawdzenie 2
        //sprawdzenie 2:  jeżeli str2 jest obiektem typu (instanceOf) String - tak jest więc  dodatkowe sprawdzenie 3
        //sprawdzenie 3:  jeżeli zawartość znak po znaku obiektu str1 i str2 są takie same to true - zgada się - na ekranie pojawi się true


        System.out.println(str1.contentEquals(sb1));    //true
        //metoda contentEquals w klasie String
        //sprawdzenie 1:  jeżeli sb1 jest typu StrinBuilder - tak jest więc dodatkowe sprawdzenie 2
        //sprawdzenie 2:  jeżeli zawartość znak po znaku obiektu sb1 i str1 są takie same to true - zgada się - na ekranie pojawi się true

        System.out.println(sb1.contentEquals(str1));    //true
        //ERROR klasa StringBuilder nie ma metody contentEquals


    }
}


























