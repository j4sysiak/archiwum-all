package co.devfoundry;

import co.devfoundry.state.SlotMachine;
import org.junit.Test;

public class ClientTest {

    @Test
    public void test () {

        SlotMachine slotMachine = new SlotMachine();   //tak jak Context() --  new NoCoinState();  stan podstawowy defaultowy

        slotMachine.insertTheCoin();
        slotMachine.currentState();
        slotMachine.pushTheLever();
        slotMachine.currentState();
        slotMachine.collectTheWinnings();
        slotMachine.currentState();

    }

}
