package co.devfoundry.state;

public class NoCoinState implements State {

    public void insertTheCoin(SlotMachine context) {
        System.out.println("Wrzucono monetę.");
        context.currentState = new CoinInsertedState();  // tworzymy nowy stan
    }

    public void pushTheLever(SlotMachine context) {
        System.out.println("Wrzuć monetę by zagrać.");
    }

    public void collectTheWinnings(SlotMachine context) {
        System.out.println("Wrzuć monetę by dać sobie szansę na wygraną.");
    }

    public void currentState(SlotMachine context) {
        System.out.println("Aktualny stan - BRAK MONETY");
    }
}
