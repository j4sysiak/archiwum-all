package com.company.withdirector;

public class MotorcycleBuilder {

    private Motocycle motocycle = new Motocycle();

    public MotorcycleBuilder() {}

    public MotorcycleBuilder setBrand(String brand) {
      this.motocycle.setBrand(brand);
      return this;
    }

    public MotorcycleBuilder setdModel(String model) {
        this.motocycle.setModel(model);
        return this;
    }

    public Motocycle build() {
        return motocycle;
    }
}
