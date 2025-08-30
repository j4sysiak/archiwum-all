package com.example.demo10.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer price;
    private String details;

    Dish(){}
    Dish(String name, Integer price) {
        this.name=name;
        this.price=price;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Dish))
            return false;
        Dish dish = (Dish) o;
        return Objects.equals(this.id, dish.id) && Objects.equals(this.name, dish.name)
                && Objects.equals(this.price, dish.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.price);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                '}';
    }
}































