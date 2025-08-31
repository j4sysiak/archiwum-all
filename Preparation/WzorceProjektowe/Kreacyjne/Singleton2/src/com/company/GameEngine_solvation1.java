package com.company;


// Rozwiązje problem wielowątkowości za pomocą synchronizacji

/* klasa singletona */
/* może być tylko jedna instancjja tej klasy */
/* jeden globalny obiekt danej klasy */
public class GameEngine_solvation1 {

    private static GameEngine_solvation1 instance = null;  // to ciekawe: referencja obiektu do samego siebie !
    public int hp = 100;
    public String characterName = "";

    // musi być modyfikator dostępu: private
    // tylko metoda getInstance będzie miała możliwość tworzenia obiektu - tylko jednego
    private GameEngine_solvation1() {
    }

    public void run() {
        while (true) {
            // czekamy na input gracza
            // zmieniamy stan gry
            // renderujemy grafikę
        }
    }

    // Zabezpieczenie, żeby był tylko jeden obiekt typu GameEngine_solvation1
    // chronimy tylko wtedy, gdy nowy obiekt jest tworzony
    // każde inne wywołanie przebiega bez synchronizacji
    public static GameEngine_solvation1 getInstatnce() {
        if (instance == null) {
            synchronized (GameEngine_solvation1.class) {

                if (instance == null) {
                    instance = new GameEngine_solvation1();
                }
            }
        }
        return instance;
    }
}
