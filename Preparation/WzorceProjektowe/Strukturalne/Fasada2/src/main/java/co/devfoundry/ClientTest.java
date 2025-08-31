package co.devfoundry;

import co.devfoundry.deliverybox.DeliveryBoxFacade;
import org.junit.Test;

public class ClientTest {

    @Test
    public void test() {

        DeliveryBoxFacade deliveryBoxFacade = new DeliveryBoxFacade();
        deliveryBoxFacade.pickupPackage();

    }

}
