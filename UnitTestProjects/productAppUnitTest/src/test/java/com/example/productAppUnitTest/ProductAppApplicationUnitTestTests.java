package com.example.productAppUnitTest;

import com.example.productAppUnitTest.entity.Product;
import com.example.productAppUnitTest.repository.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductAppApplicationUnitTestTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Order(1)
    @Rollback(false)
    void testCreateProduct() {
        Product product = Product.builder()
                .id(7L)
                .name("ZZZ")
                .price(400.98)
                .description("sssssssss")
                .build();
        Product savedProduct = productRepository.save(product);
        assertNotNull(savedProduct);
        assertNotNull(productRepository.findById(7L).get());
    }

    @Test
    @Order(2)
    @Rollback(false)
    void testListProducts() {
        List<Product> listOfProduct = productRepository.findAll();
        assertThat(listOfProduct).size().isGreaterThan(0);
    }

    @Test
    @Order(3)
    @Rollback(false)
    void findBId() {

        Product product = productRepository.findById(1L).get();
        assertEquals(1L, product.getId());
        assertEquals(400.98, product.getPrice());
    }

    @Test
    @Order(4)
    @Rollback(false)
    void testUpdate() {
        Product product = productRepository.findById(1L).get();
        product.setPrice(100.99);
        productRepository.save(product);
        assertNotEquals(400.98, productRepository.findById(1L).get().getPrice());
    }

    @Test
    @Order(5)
    @Rollback(false)
    void deleteById() {
        productRepository.deleteById(1L);
        assertThat(productRepository.existsById(1L)).isFalse();
    }


    @Test
    @Order(6)
    @Rollback(false)
    void testFindProductByName() {
        String name = "ZZZ";
        Product product = productRepository.findByName(name);
        assertThat(product.getName().equals(name));
    }

    @Test
    @Rollback(false)
    void testFindProductByNameNotExists() {

        String name = "ZZZ111";
        Product product = productRepository.findByName(name);

        assertNull(product);
    }

    @Test
    @Rollback
    void testUpdateProduct() {

        String productName = "0004";
        Product product = Product.builder()
                // .id(20L)  nie musi być
                .name(productName)
                .price(123.98)
                .description("89898989")
                .build();

        product.setDescription("qqqqqqqqqqqqqqq");
        productRepository.save(product);

        Product updateProduct = productRepository.findByName(product.getName());

        assertThat(updateProduct.getName()).isEqualTo(product.getName());  // lub
        assertThat(updateProduct.getName().equals(product.getName()));
    }

    @Test
    @Rollback(false)
    public void update() {
        Product product = productRepository.findById(22L).get();
        product.setPrice(900.00);
        productRepository.save(product);

        assertNotEquals(123.98, productRepository.findById(22L).get().getPrice());
    }

    @Test
    @Rollback(false)
    public void listProduct() {
        List<Product> list = (List<Product>) productRepository.findAll();  //lub
        assertThat(list).size().isGreaterThan(0);

        List<Product> list2 = (List<Product>) Optional.of(productRepository.findAll()).orElseThrow(null);
        list2.forEach(Product::getPrice);
        list2.forEach(System.out::println);
        assertThat(list2).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    public void deleteProduct() {
        Long id = 22L;
        boolean isBeforeDelete = productRepository.findById(id).isPresent();
        productRepository.deleteById(id);
        boolean isAfterDelete = productRepository.findById(id).isPresent();

        assertThat(productRepository.existsById(22L)).isFalse();

        assertTrue(isBeforeDelete);
        assertFalse(isAfterDelete);
    }
}
