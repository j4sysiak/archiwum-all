package co.devfoundry;

import co.devfoundry.units.*;
import org.junit.Test;

public class ClientTest {

    @Test
    public void test() throws Exception {

        Factory factory = new UnitFactory();

        Unit tank = factory.createUnit(UnitType.TANK);
        Unit infantryman = factory.createUnit(UnitType.RIFLEMAN);

    }

}
