package com.company;


// Rozwiązje problem wielowątkowości za pomocą tworzenia od razu przez loadera tylko jednego obiektu naszej klasy
// poprzes wejście do statycznego pola na początku i utworzenie instancji za pomocą new GameEngine()

/* klasa singletona */
/* może być tylko jedna instancjja tej klasy */
/* jeden globalny obiekt danej klasy */
public class GameEngine_solvation2 {

    // TO WAŻNE
    private static GameEngine_solvation2 instance = new GameEngine_solvation2();  // to ciekawe: referencja obiektu do samego siebie !
    public int hp = 100;
    public String characterName = "";

    // musi być modyfikator dostępu: private
    // tylko metoda getInstance będzie miała możliwość tworzenia obiektu - tylko jednego
    private GameEngine_solvation2() {
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
    public static GameEngine_solvation2 getInstatnce() {
        return instance;
    }
}
