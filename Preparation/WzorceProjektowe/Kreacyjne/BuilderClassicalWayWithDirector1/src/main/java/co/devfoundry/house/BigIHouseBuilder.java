package co.devfoundry.house;

public class BigIHouseBuilder implements IHouseBuilder {

    private House house;

    public BigIHouseBuilder() {
        this.house = new House();
    }

    public void buildWalls() {
        this.house.setWalls("big walls");
    }

    @Override
    public void buildFloors() {
        this.house.setFloors("big floors");
    }

    public House getHouse() {
        return house;
    }

}
