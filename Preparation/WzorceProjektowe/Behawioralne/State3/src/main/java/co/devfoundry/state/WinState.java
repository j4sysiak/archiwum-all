package co.devfoundry.state;

public class WinState implements State {

    public void insertTheCoin(SlotMachine context) {
        System.out.println("Przed ponowną grą zabierz swoją nagrodę.");
    }

    public void pushTheLever(SlotMachine context) {
        System.out.println("Przed ponowną grą zabierz swoją nagrodę.");
    }

    public void collectTheWinnings(SlotMachine context) {
        System.out.println("Zabrano monety. Gratulacje.");
        context.currentState = new NoCoinState();
    }

    public void currentState(SlotMachine context) {
        System.out.println("Aktualny stan - WYGRANA");
    }
}
