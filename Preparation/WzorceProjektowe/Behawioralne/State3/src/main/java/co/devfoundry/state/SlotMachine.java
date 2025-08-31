package co.devfoundry.state;

public class SlotMachine {

    State currentState;

    public SlotMachine() {
        this.currentState = new NoCoinState();  // stann podstawowy defaultowy
    }

    public void insertTheCoin() {
        currentState.insertTheCoin(this);
    }

    public void pushTheLever() {
        currentState.pushTheLever(this);
    }

    public void collectTheWinnings() {
        currentState.collectTheWinnings(this);
    }

    public void currentState() {
        currentState.currentState(this);
    }
}
