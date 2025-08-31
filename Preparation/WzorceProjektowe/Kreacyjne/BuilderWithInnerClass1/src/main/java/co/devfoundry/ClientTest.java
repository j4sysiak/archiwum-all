package co.devfoundry;

import co.devfoundry.house.House;

public class ClientTest {

    @org.junit.Test
    public void test() {

//        House house1 = new House("walls", "floors", "rooms", "windows", "doors", "garage");
//        House house2 = new House("")

        House house = new House.HouseBuilder()
                .buildWalls("walls")
                .buildFloors("floors")
                .buildRoof("roof")
                .buildRooms("rooms")
                .build();

        System.out.println(house);

    }

}
