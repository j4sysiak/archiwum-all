package co.devfoundry;

abstract public class Terrain {

    private int fuelCost; // zuzycie paliwa przez jednostkę, która przez dany teren przejeżdźa

    public Terrain(int fuelCost) {
        this.fuelCost = fuelCost;
    }

    public int fuelCost() {
        return fuelCost;
    }

}
