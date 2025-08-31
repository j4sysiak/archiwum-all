package co.devfoundry;

import co.devfoundry.house.BigIHouseBuilder;
import co.devfoundry.house.House;
import co.devfoundry.house.Director;
import co.devfoundry.house.SmallIHouseBuilder;

public class ClientTest {

    private Director director = null;

    @org.junit.Test
    public void test() {

//        House house1 = new House("walls", "floors", "rooms", "windows", "doors", "garage");
//        House house2 = new House("")

        SmallIHouseBuilder smallHouseBuilder = new SmallIHouseBuilder();
        director = new Director(smallHouseBuilder);
        director.buildHouse();
        House smallHouse = director.getHouse();
        System.out.println(smallHouse);


        BigIHouseBuilder bigHouseBuilder = new BigIHouseBuilder();
        director = new Director(bigHouseBuilder);
        director.buildHouse();
        House bigHouse = director.getHouse();
        System.out.println(bigHouse);
    }
}
