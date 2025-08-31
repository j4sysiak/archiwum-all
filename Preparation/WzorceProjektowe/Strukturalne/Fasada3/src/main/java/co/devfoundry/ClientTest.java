package co.devfoundry;

import co.devfoundry.bank.Facade;
import org.junit.Test;

public class ClientTest {

    @Test
    public void test() {

        Facade facade = new Facade();
        facade.withdrawMoney();

    }

}
