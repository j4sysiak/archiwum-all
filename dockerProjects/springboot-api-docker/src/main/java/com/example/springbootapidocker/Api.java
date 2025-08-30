package com.example.springbootapidocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Api {

    private AnimalRepo animalRepo;

    @Autowired
    public Api(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
        animalRepo.save(new Animal("Dog"));
        animalRepo.save(new Animal("Cat"));
        animalRepo.save(new Animal("Horse"));
    }

//    private List<Animal> animals;
//    public Api() {
//        this.animals = new ArrayList();
//        animals.add(new Animal("cat"));
//        animals.add(new Animal("dog"));
//    }

    //endpoint 1
    @GetMapping("/animals")
    public Iterable<Animal> getAnimals() {
        return animalRepo.findAll();
    }

    //endpoint 2
    @PostMapping("/animals")
    public void addAnimals(@RequestBody Animal newAnimal) {
      animalRepo.save(newAnimal);
    }
}





























