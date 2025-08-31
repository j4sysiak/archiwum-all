package co.devfoundry.house;

public class SmallIHouseBuilder implements IHouseBuilder {

    private House house;

    public SmallIHouseBuilder() {
        this.house = new House();
    }

    public void buildWalls() {
        this.house.setWalls("small walls");
    }

    @Override
    public void buildFloors() {
        this.house.setFloors("small floors");
    }

    public House getHouse() {
        return house;
    }
}
