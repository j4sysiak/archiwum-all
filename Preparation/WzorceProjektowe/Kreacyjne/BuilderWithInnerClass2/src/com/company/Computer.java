package com.company;

public class Computer {

    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
    }

    private String HDD;
    private String RAM;



    //ComputerBuilder Class  (inner class)
    public static class ComputerBuilder {

        // required parameters
        private String HDD;
        private String RAM;

        public ComputerBuilder setHDD(String hdd) {
            this.HDD = hdd;
            return this;
        }

        public ComputerBuilder setRAM(String ram) {
            this.RAM = ram;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}