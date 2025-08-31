package com.company;

import org.junit.Test;

public class ClientTest {

    /*
    Kreacyjny wzorzec projektowy, którego celem jest ograniczenie możliwości tworzenia obiektów danej klasy do jednej instancji.
    Może być tylko jeden obiekt tej klasy.
    Singleton zapewnia też globalny dostęp do stworzonego obiektu.

    Zalety: jeden globalny obiekt danej klasy - globalny dostęp do niego (może być używany do zapewnienia transakcyjności, persystencji)
    Wady: łamie zasady SOLID: SingleResponsibility, OpenClose i może utrudnić pisanie testów jednostkowych
    */

    @Test
    public void test() {

        // musi być prywatny konstruktor GameEngine_solvation1, żeeeeeby nie było można tworzyć obiektów GameEngine_solvation1
        // GameEngine_solvation1 gameEngine = new GameEngine_solvation1();  E R R O R
        var gameEngine1 = GameEngine_solvation1.getInstatnce();
        var gameEngine2 = GameEngine_solvation1.getInstatnce();

        System.out.println(gameEngine1 == gameEngine2);  //true

    }
}
