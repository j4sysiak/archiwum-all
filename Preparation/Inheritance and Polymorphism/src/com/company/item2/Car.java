package com.company.item2;

public class Car {
    public int gearRatio = 8;
    public String accelerate() {
        return "Acccelerate Car";
    }
}

  class SportCar extends Car{
      public int gearRatio = 9;
      public String accelerate() {
          return "Acccelerate SportCar";
      }

    public static void main(String[] args) {
        Car car = new SportCar();
        System.out.println(car.gearRatio + " " + car.accelerate() );
    }
}
