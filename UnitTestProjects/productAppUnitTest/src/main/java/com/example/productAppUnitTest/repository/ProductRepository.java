package com.example.productAppUnitTest.repository;

import com.example.productAppUnitTest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends /*CrudRepository*/ JpaRepository<Product, Long> {

    Product findByName(String name);

}
