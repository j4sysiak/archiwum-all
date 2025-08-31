package co.devfoundry.adapter;

import co.devfoundry.adapter.api.LibraryAPI;
import co.devfoundry.adapter.api.LibraryAPIImpl;
import co.devfoundry.adapter.api.LibraryAPIv2;
import co.devfoundry.adapter.api.LibraryAPIv2Impl;
import org.junit.Test;

public class ClientTest {

    @Test
    public void test() {

        User user = new User("Paweł","Cwik","32131212");

        // przed wprowadzeniem nowego interfejsu
        LibraryAPI libraryAPI = new LibraryAPIImpl();
        BookConnector connector1 = new BookConnector(user, libraryAPI);
        connector1.checkAviability("Harry Potter i Zakon Feniksa");

        // po wprowadzeniu nowego interfejsu versja.2 - należy teraz dostosować się do nowego interfejsu dostępowego miejskiej biblioteki.
        LibraryAPIv2 libraryAPIv2 = new LibraryAPIv2Impl();
        APIAdapter apiAdapter = new APIAdapter(libraryAPIv2, user);
        BookConnector connector2 = new BookConnector(user, apiAdapter);
        connector2.checkAviability("Harry Potter i Zakon Feniksa");
    }

}
