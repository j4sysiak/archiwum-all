package com.company;

public enum GetEngineEnum {
    INSTANCE("Jacek");

    public int hp = 100;
    public String characterName = "";

    // musi być modyfikator dostępu: private
    // tylko metoda getInstance będzie miała możliwość tworzenia obiektu - tylko jednego
    private GetEngineEnum(String name) {
        this.characterName = name;
    }

    public void run() {
        while (true) {
            // czekamy na input gracza
            // zmieniamy stan gry
            // renderujemy grafikę
        }
    }

}
