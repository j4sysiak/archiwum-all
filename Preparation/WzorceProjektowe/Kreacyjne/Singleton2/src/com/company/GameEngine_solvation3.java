package com.company;

// rozwiązuje problem deserializacji



import java.io.Serializable;

/* klasa singletona */
/* może być tylko jedna instancjja tej klasy */
/* jeden globalny obiekt danej klasy */
public class GameEngine_solvation3 implements Serializable {

    private static final long serialVersionUID =  223349827;

    // TO WAŻNE
    private static GameEngine_solvation3 instance = new GameEngine_solvation3();  // to ciekawe: referencja obiektu do samego siebie !
    public int hp = 100;
    public String characterName = "";


    // to wywoła się za każdym razem, kiedy obiekt klasy będzie odserializowany
    //  i wtedy zawsze zwracamy tą samą instancję - a bez tego po odserializowaniu
    // jakiś bandyta może utworzyć sobie wiele kopii naszej instancji :(
    protected Object readResolve() {
        return instance;
    }




    // musi być modyfikator dostępu: private
    // tylko metoda getInstance będzie miała możliwość tworzenia obiektu - tylko jednego
    private GameEngine_solvation3() {
    }

    public void run() {
        while (true) {
            // czekamy na input gracza
            // zmieniamy stan gry
            // renderujemy grafikę
        }
    }

    // Zabezpieczenie, żeby był tylko jeden obiekt typu GameEngine_solvation2
    // ponieważ zmienna instance jest statyczna, to wchodząc do tej klasy od razu loader ją łapie
    // i mamy od razu instancję new GameEngine_solvation2();
    // i tutaj nie musimy nic sprawdzać - tylko pobieramy instancję
    public static GameEngine_solvation3 getInstatnce() {
        return instance;
    }
}
