package co.devfoundry;

public class CoffeeMachine {

    State currentState;

    public CoffeeMachine() {
        currentState = new NoCoinState();
    }

    public void insertTheCoin() {
        currentState.insertTheCoin(this);
    }

    public void pushTheButton() {
        currentState.pushTheButton(this);
    }

    public void takeTheCup() {
        currentState.takeTheCup(this);
    }

    public void returnTheCoin() {
        currentState.returnTheCoin(this);
    }
}
