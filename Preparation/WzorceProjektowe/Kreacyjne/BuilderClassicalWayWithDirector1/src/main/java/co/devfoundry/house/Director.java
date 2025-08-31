package co.devfoundry.house;

public class Director {

    private IHouseBuilder ihouseBuilder;

    public Director(IHouseBuilder IHouseBuilder) {
        this.ihouseBuilder = IHouseBuilder;
    }

    public void buildHouse() {
        ihouseBuilder.buildWalls();
        ihouseBuilder.buildFloors();
    }

    public House getHouse() {
        return this.ihouseBuilder.getHouse();
    }

}
