package co.devfoundry;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClientTest {
    //public static final void main(String[] args) {
   @Test
   public void test() {
        List<SavedGame> savedGames = loadSavedGames();
        listSavedGames(savedGames);
    }

    public static List<SavedGame> loadSavedGames() {

        int savedGamesCount = 20;
        List<SavedGame> savedGames = new ArrayList<>(savedGamesCount);
        for (int i = 0; i < 11; i++) {
                SavedGame sg =   new SavedGameProxy(); // takie szybkie odpalneie inicjalizacji gry
                // SavedGame sg =   new SavedGameFull(); // takie całościowe odpalneie inicjalizacji gry, ładuje wszystkoo z bazy 888 ms * 11
                sg.initialize();
                savedGames.add(sg);
        }

        return savedGames;
    }

    private static void listSavedGames(List<SavedGame> savedGames) {
        for (SavedGame savedGame : savedGames) {
            System.out.println(savedGame.getName());
        }
    }

}
