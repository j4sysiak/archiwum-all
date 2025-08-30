package com.example.UnitTestRestfulWebServicesTestCRUD.service;

import com.example.UnitTestRestfulWebServicesTestCRUD.entity.Country;

public interface CountryService {

    Country geCountryById(Integer id);

    Country saveCountry(Country country);

    String save(Country country);

    void deleteById(Integer id);

    Object findAllByOrderByNameAsc();
}
