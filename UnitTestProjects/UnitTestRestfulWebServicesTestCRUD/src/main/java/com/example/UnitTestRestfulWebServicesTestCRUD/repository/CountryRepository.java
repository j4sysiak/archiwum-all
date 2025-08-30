package com.example.UnitTestRestfulWebServicesTestCRUD.repository;

import com.example.UnitTestRestfulWebServicesTestCRUD.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findAllByOrderByNameAsc();
}