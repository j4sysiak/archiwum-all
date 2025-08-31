package co.devfoundry;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    // to rozwiązuje problem wielowątkowości za pomocą
    // utworzenia instancji klasy (jedynej) przy pierwszym wejściu do klasy
    // loader zaczytuje klasę tworzy instancję i jest git
    private static GuessGame instance = new GuessGame();



    private int score = 0;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    // musi byc private constructor
    private GuessGame() {}

    public static GuessGame getInstance() {
        return instance;
    }

    // to rozwiązuje problem serializacji
    // to wywoła się za każdym razem, kiedy obiekt klasy będzie odserializowany
    //  i wtedy zawsze zwracamy tą samą instancję - a bez tego po odserializowaniu
    // jakiś bandyta może utworzyć sobie wiele kopii naszej instancji :(
    protected Object readResolve() {
        return instance;
    }


    public int getScore() {
        return score;
    }

    public void play() {

        for(int i  = 0; i<2; i++) {
            int number = random.nextInt(9);
            System.out.print("Zgadnij cyfre: ");
            int quess = scanner.nextInt();

            if(number==quess) {
                System.out.println("Udalo sie!");
                score++;
            } else {
                System.out.println("Przykro mi, myslalem o " + number);
            }
        }

        System.out.println("Twoj wynik: " + score);


    }
}
