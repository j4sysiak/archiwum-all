package com.company.withdirector;

public class Director2 {

    private MotorcycleBuilder motocycleBuilder;

    public Director2(MotorcycleBuilder motocycleBuilder) {
        this.motocycleBuilder = motocycleBuilder;
    }

    public Motocycle createHondaMotorcycle() {
        return this.motocycleBuilder
                .setBrand("Honda")
                .setdModel("650W")
                .build();
    }

    public Motocycle createYamahaMotorcycle() {
        return this.motocycleBuilder
                .setBrand("Yamaha")
                .setdModel("1200CC Power")
                .build();
    }
}
