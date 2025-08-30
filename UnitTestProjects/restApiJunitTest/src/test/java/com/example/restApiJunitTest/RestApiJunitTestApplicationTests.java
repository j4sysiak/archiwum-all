package com.example.restApiJunitTest;

import com.example.restApiJunitTest.entity.Product;
import com.example.restApiJunitTest.repository.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestApiJunitTestApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    @Order(1)
    public void testCreate() {

        Product p = new Product();
        p.setId(1L);
        p.setName("dsfsd");
        p.setDescription("sdasd");
        p.setPrice(1000.00);
        productRepository.save(p);

        assertNotNull(productRepository.findById(1L).get());
    }

    @Test
    @Order(2)
    public void testReadAll() {
        List<Product> list = productRepository.findAll();
//        Optional.of(list = productRepository.findAll()).orElseThrow(null);
//        list.stream().forEach(Product::getPrice);

        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void testSingleProduct() {

        Product product = productRepository.findById(1L).get();
        assertEquals(1000.00, product.getPrice());
    }

    @Test
    @Order(4)
    public void testUpdate() {
        Product product = productRepository.findById(1L).get();
        product.setPrice(900.00);
        productRepository.save(product);

        assertNotEquals(1000.00, productRepository.findById(1L).get().getPrice());
    }

    @Test
    @Order(5)
    public void testDelete() {
        productRepository.deleteById(1L);
        assertThat(productRepository.existsById(1L)).isFalse();
    }

}
