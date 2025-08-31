package com.company;


import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Welcome {
    void welcomeMessage();  // only one abstract method allowed !

    //moze byc
    default void methodOne(){
        System.out.println("Hello One");
    }

    //moze byc
    default void methodTwo(){
        System.out.println("Hello Two");
    }

    //moze byc
    static void methodThree(){
        System.out.println("Hello Two");
    }


    //nie moze byc - może być tylko jedna metoda ABSTRAKCYJNA, więc albo methodOne() alba ta - wybór należy do Ciebie kolego
    //void absMethod();
}

@FunctionalInterface
interface WelcomeWithOneParam {
    void welcomeMessage(String message);
}

@FunctionalInterface
interface WelcomeWithOneParamAndReturnValue {
    String welcomeMessage(String message);
}

@FunctionalInterface
interface WelcomeWithTwoParam {
    void welcomeMessage(String message1, String message2);
}


//Kazdy interface funkcyjny musi mieć:
//        Some key point -
//        1. >= It's a Java 8 Feature
//        2. Exactly ONE Abstract method in an Interface
//        3. Single Abstract Method Interface (SAM)
//        4. @FunctionalInterface java annotation is used (not necessery)



public class DemoFI {

    public static void main(String[] args) {

        Welcome welcome1 = new Welcome() {
            @Override
            public void welcomeMessage() {
                System.out.println("Welcome Interface is implemented");
            }
        };
        welcome1.welcomeMessage();
        // lub
        /* warunek, interface Welcome musi być funkcyjny  */
        Welcome welcome = () -> System.out.println("Welcome Interface is implemented");
        welcome.welcomeMessage();




        WelcomeWithOneParam welcomeWithOneParam = (message)
                -> System.out.println("Welcome Interface is implemented " + message);
        welcomeWithOneParam.welcomeMessage("KAKA");


        WelcomeWithTwoParam welcomeWithTwoParam = (message1, message2)
                -> System.out.println("Welcome Interface is implemented " + message1 + ":" + message2);
        welcomeWithTwoParam.welcomeMessage("KAKA1", "KAKA2");


        WelcomeWithOneParamAndReturnValue welcomeWithOneParamAndReturnValue =  (m) ->  "some string " + m;
        System.out.println(welcomeWithOneParamAndReturnValue.welcomeMessage("KAKA"));

        //iteration using Lambda
        List<String> listOfStrings
                = new ArrayList<>(Arrays.asList("one", "two", "three"));

        listOfStrings.forEach( (v) -> System.out.println(v)  );

    }

}

































