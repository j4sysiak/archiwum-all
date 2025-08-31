package com.company.withdirector;

import org.junit.Test;

public class ClientTest {

    @Test
    public void test1() {
        Director director = new Director();
        MotorcycleBuilder motocycleBuilder = new MotorcycleBuilder();

        Motocycle honda = director.createHondaMotorcycle(motocycleBuilder);
        Motocycle yamaha = director.createYamahaMotorcycle(motocycleBuilder);
    }

    @Test
    public void test2() {
        MotorcycleBuilder motocycleBuilder = new MotorcycleBuilder();
        Director2 director = new Director2(motocycleBuilder);

        Motocycle honda = director.createHondaMotorcycle();
        Motocycle yamaha = director.createYamahaMotorcycle();
    }

}
