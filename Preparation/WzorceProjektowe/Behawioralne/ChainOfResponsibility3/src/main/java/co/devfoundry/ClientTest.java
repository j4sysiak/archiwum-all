package co.devfoundry;

import co.devfoundry.children.*;
import co.devfoundry.request.MotherRequest;
import org.junit.Test;

public class ClientTest {

    @Test
    public void test() {

        MotherRequest motherRequest = new MotherRequest(Shelf.HIGH);

        Child tomek = new Tomek();
        Child ania = new Ania();
        Child antek = new Antek();

        tomek.setTallerChild(ania);
        ania.setTallerChild(antek);

        tomek.processRequest(motherRequest);

    }

}
