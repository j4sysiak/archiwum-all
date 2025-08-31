package com.example.demo.service;

import com.example.demo.model.Car;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//obiekt takiej klasy to Singleton - tylko jedna instancja może być w obrębie całego oprogramowania
//instancja tworzona tylko raz
//to jest Beat Springa zarządzany przez Context Springa
@Service
@Getter
@Setter
public class CarService {

    private List<Car> carList;

    public CarService() {
        this.carList = new ArrayList();
        carList.add(new Car("Polo", "VW"));
        carList.add(new Car("Starlet", "Toyota"));
    }

    public boolean addCar(Car car) {
        return carList.add(car);
    }
}
