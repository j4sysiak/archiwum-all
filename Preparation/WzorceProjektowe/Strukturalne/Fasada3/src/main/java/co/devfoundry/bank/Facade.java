package co.devfoundry.bank;

public class Facade {

    private AtmMachine atmMachine;
    private BankSystem bankSystem;

    public Facade() {
        atmMachine = new AtmMachine();
        bankSystem = new BankSystem();
    }

    public void withdrawMoney() {
        atmMachine.enterPin();
        if (bankSystem.validatePin() && bankSystem.validateTransaction()) {
            atmMachine.withdrawCash();
        }
    }

}
