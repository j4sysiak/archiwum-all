package co.devfoundry;

import org.junit.Test;

public class ClientTets {

    @Test
    public void test() {
        generateMap();
    }

    private static void generateMap() {

        //base terain
        Hill hill = new Hill();
        System.out.println("hill " + hill.fuelCost());


        //wpuszczamy go w bagna, więc mamsz do pokonania hills (30) w bagnach (15) = 45 zł
        Terrain hillAndSwamp = new SwampDecorator(hill);
        System.out.println("hillAndSwamp " + hillAndSwamp.fuelCost());

        //i dodatkowo wpuszczamy go w jeszcze do lasu za (5):  więc suma 45 + 5 = 50 zł
        Terrain hillAndSwampAndForest = new ForestDecorator(hillAndSwamp);
        System.out.println("hillAndSwampAndForest " + hillAndSwampAndForest.fuelCost());

        // lub hurtowo w jednym wierszu
        Terrain terrain = new ForestDecorator(new SwampDecorator(new Hill()));
        System.out.println("terrain " + terrain.fuelCost());
    }

}
