package com.example.UnitTestRestfulWebServicesTestCRUD.service;

import com.example.UnitTestRestfulWebServicesTestCRUD.entity.Country;
import com.example.UnitTestRestfulWebServicesTestCRUD.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country geCountryById(Integer id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public String save(Country country) {
        Country newCountry = countryRepository.save(country);
        return String.valueOf(newCountry.getId());
    }

    @Override
    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }

    @Override
    public List<Country> findAllByOrderByNameAsc() {
        return countryRepository.findAllByOrderByNameAsc();
    }
}
