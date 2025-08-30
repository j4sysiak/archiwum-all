package com.example.demo11;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer age;

    Student(){}
    Student(String name, Integer age) {
        this.name=name;
        this.age=age;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Student))
            return false;
        Student dish = (Student) o;
        return Objects.equals(this.id, dish.id) && Objects.equals(this.name, dish.name)
                && Objects.equals(this.age, dish.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.age);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + age +
                ", details='" + age + '\'' +
                '}';
    }
}
