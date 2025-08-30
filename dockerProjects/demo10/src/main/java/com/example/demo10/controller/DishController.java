package com.example.demo10.controller;

import com.example.demo10.model.Dish;
import com.example.demo10.repositories.DishRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {

    private final DishRepository dishRepository;


    public DishController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @GetMapping("/dishes")
    public List<Dish> all() {
        return dishRepository.findAll();
    }

    @PostMapping("/dishes")
    public Dish newDish(@RequestBody Dish newDish) {
        return dishRepository.save(newDish);
    }

    @PutMapping("/dishes/{id}")
    public Dish replaceDish(@RequestBody Dish newDish, @PathVariable Long id) {
        return dishRepository.findById(id)
                .map(dish -> {
                    dish.setName(newDish.getName());
                    dish.setPrice(newDish.getPrice());
                    return dishRepository.save(dish);
                }).orElseGet(() -> {
                    newDish.setId(id);
                    return dishRepository.save(newDish);
                });
    }

    @DeleteMapping("/dishes/{id}")
    public void deleteDish(@PathVariable Long id) {
        dishRepository.deleteById(id);
    }

}






























