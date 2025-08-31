package co.devfoundry;

import static java.lang.Thread.sleep;

public class SavedGameFull implements SavedGame{

    private String name;
    private String gameData;


    public void initialize() {
        this.name = "Save Game - " + String.valueOf(System.currentTimeMillis());
        this.gameData = loadFromStorage();
    }

    public String getName() {
        return this.name;
    }

    public void loadGame() {
        System.out.println("Game loaded");
    }

    private String loadFromStorage() {
        try {
            sleep(777);  // load From Storage: Data base
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Loaded";
    }
}
