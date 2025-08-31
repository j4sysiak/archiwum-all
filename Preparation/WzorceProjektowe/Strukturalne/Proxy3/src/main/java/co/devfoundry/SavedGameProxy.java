package co.devfoundry;

public class SavedGameProxy implements SavedGame {

    private String name;
    private SavedGame sg;  // docelowo ma być obiekt SavedGameFull, ale w proxy ładujemy tylko inicjalizację gry a nie fulla z bazy


    @Override
    public void initialize() {
        this.name = "Save Game - " + String.valueOf(System.currentTimeMillis());
    }

    @Override
    public String getName() {
        return this.name;
    }


    // tą metodę odpalamy póżniej po inicjalizacji tzn. Lazy Loading (a nie od razu), jak już user wybierze sobie
    // jakąś konkretną grę, wklikuje się w nią i wdedy odpala się ta metoda  - full loading
    // na razie jej nie wywołujemy w tym przykładie
    @Override
    public void loadGame() {
        sg = new SavedGameFull();  // tworzymy pełny obiekt docelowz
        sg.initialize();
        sg.loadGame();
    }


}
