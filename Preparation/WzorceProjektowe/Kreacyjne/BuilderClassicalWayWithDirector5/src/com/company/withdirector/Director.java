package com.company.withdirector;

public class Director {

    public Motocycle createHondaMotorcycle(MotorcycleBuilder motocycleBuilder) {
        return motocycleBuilder
                .setBrand("Honda")
                .setdModel("650W")
                .build();
    }

    public Motocycle createYamahaMotorcycle(MotorcycleBuilder motocycleBuilder) {
        return motocycleBuilder
                .setBrand("Yamaha")
                .setdModel("1200CC Power")
                .build();
    }
}
