package com.example.springbootclientdocker;

public class Animal {
    private Long id;
    private String name;

    public Animal() {}
    public Animal(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//    @Override
//    public boolean equals(java.lang.Object o) {
//        if (this == o)
//            return true;
//        if (!(o instanceof Animal))
//            return false;
//        Animal animal = (Animal) o;
//        return Objects.equals(this.id, animal.id) && Objects.equals(this.name, animal.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.id, this.name);
//    }
//
//    @Override
//    public String toString() {
//        return "Dish{" +
//                "id=" + id +
//                ", name='" + name +
//                '}';
//    }