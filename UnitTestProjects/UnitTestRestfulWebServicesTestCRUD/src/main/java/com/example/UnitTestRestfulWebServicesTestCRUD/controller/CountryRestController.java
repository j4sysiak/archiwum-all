package com.example.UnitTestRestfulWebServicesTestCRUD.controller;

import com.example.UnitTestRestfulWebServicesTestCRUD.entity.Country;
import com.example.UnitTestRestfulWebServicesTestCRUD.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Integer id) {
        System.out.println("CountryById REST API is invoked ... ");
        return new ResponseEntity<>(countryService.geCountryById(id), HttpStatus.OK);
    }

    @PostMapping("/country/save")
    public ResponseEntity<Country> saveCountry(@Valid @RequestBody Country country) {
        System.out.println("SaveCountry REST API is invoked ... ");
        Country savedCountry = countryService.saveCountry(country);
        return new ResponseEntity<>(countryService.saveCountry(country), HttpStatus.CREATED);
    }

    @PostMapping("/country/save2")
    public ResponseEntity<String> save(@RequestBody Country country) {
        System.out.println("Save (Country) REST API is invoked ... ");
        String savedCountry = countryService.save(country);
        return new ResponseEntity<>(countryService.save(country), HttpStatus.CREATED);
    }

    @GetMapping("/country/delete/{id}")
    public void deleteCountry(@PathVariable("id") Integer id) {
        System.out.println("DeleteCountry REST API is invoked ... ");
        countryService.deleteById(id);
    }

    @GetMapping("/country/list")
    public ResponseEntity<List<Country>> findAllByOrderByNameAsc() {
        System.out.println("FindAllByOrderByNameAsc REST API is invoked ... ");
        return new ResponseEntity<>((List<Country>) countryService.findAllByOrderByNameAsc(), HttpStatus.OK);
    }

}
