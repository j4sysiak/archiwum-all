package com.company;

import org.junit.jupiter.api.Test;

/*
Kiedy mamy jakiś obiekt i chcemy poszerzyć jego zachowanie.
Strukturalny wzorzec projektowy, którego celem jest umożliwienie rozszerzania zachowania istniejących obiektów,
poprzez opakowanie ich w specjalnych obiektach, które będą zawierać dane zachowanie.
Dekorator pomorze utworzyć jakiś obiekt warstwowo, poczynając od bazy i rozszerzamy funkcjonalności.

Przykład z Pizzą:
Predefiniowanie pizzy. Zaczynamy od ciasta (wyboru np. wielkości) i to jest baza,
następnie dodajemy kolejno jakieś składniki jeden po drugim i to jest dekoratorowanie pizzy.

Przykład ze "Świata IT":
Logowanie jakiś informacji w aplikacji do pliku, konsoli, bazy danych
 i w zależności od miejsca w kodzie za pomocą dekoratora bylibyśmy na tyle elastyczni,
  że moglibyśmy dokomponować w dowolny sposób logowanie do jednego z tych trzech miejsc, czy też do połączonych dwóch lub trzech miejsc logowania.
Baza aplikacja, dekorator dodatkowe funkcjonalności (składniki pizzy) - różne logowania.

Baza:
IPizza - wspólny interfejs dla każdej z pizzy, którego zadaniem będzie obliczenie ceny każdej pizzy.
Ten interfejs implementowałby trzy rodzaje pizzy (mała, średnia i duża).
Teraz tworzymy dekorator (upiększacz) - dodajemy klasę PizzaDecorator - to jest pewna abstrakcja dekoracji.
Klasa ta będzie również implementować interfejs IPizza a oprócz tego będzie w sobie agregować jakąś pizzę bazową.
Zaczniemy od implementacji pizzy, następnie będziemy w stanie nałożyć już konkretną implementację dekoratora pizzy,
jakimi mogą być na przykład:  HamPizzaDecorator, CheesePizzaDecorator, SelamiPizzaDecorator.
Te trzy klasy (upiększające bazę "pizza") będą dziedziczyć po klasie PizzaDecorator, a więc możemy je traktować jako obiekt bazowy IPizza.
W ten sposób tworząc bazową pizzę samego ciasta, będziemy mogli nakładać nieskończoną liczbę różnych składników ("dekorować pizzę")
 poprzez opakowanie na kilku poziomach konkretne dekoratory.
Kalkulacja ceny - na każdym poziomie ta cena będzie się powiększać o konkretną wartość,
czyli pizze bazowe mają wartość zahardkodowaną a następnie poprzez dodawanie składników będziemy zwiększać tą bazową wartość pizzy.
*/
public class ClientTest {
    @Test
    public void test() {

        //baza pizzy
        MediumPizza pizzaBase = new MediumPizza();

        // do base (MediumPizza) dorzucamy ser, czyli robimy sobie średnią pizzę z serem
        CheesePizzaDecorator mediumPizzaWithCheese = new CheesePizzaDecorator(pizzaBase);
        System.out.println("Cena pizzy typu (mediumPizzaWithCheese): " + mediumPizzaWithCheese.calculatePrice());

        // do  MediumPizza (z serem) dodajemy Ham
        HamPizzaDecorator mediumPizzaCheeseHam = new HamPizzaDecorator(mediumPizzaWithCheese);
        System.out.println("Cena pizzy typu (mediumPizzaCheeseHam): " + mediumPizzaCheeseHam.calculatePrice());

        // do  MediumPizza (serem i Ham) dodajemy Salami
        SalamiPizzaDecorator mediumPizzaCheeseHamSalami = new SalamiPizzaDecorator(mediumPizzaCheeseHam);
        System.out.println("Cena pizzy typu (mediumPizzaCheeseHamSalami): " + mediumPizzaCheeseHamSalami.calculatePrice());

        // do  mediumPizzaCheeseHamSalami (z Serem i Ham i Salami)  dodajemy jeszcze raz Ser
        CheesePizzaDecorator mediumPizzaCheeseHamSalamiChees = new CheesePizzaDecorator(mediumPizzaCheeseHamSalami);
        System.out.println("Cena pizzy typu (mediumPizzaCheeseHamSalamiChees - podwojny ser): " + mediumPizzaCheeseHamSalamiChees.calculatePrice());
    }
}



























