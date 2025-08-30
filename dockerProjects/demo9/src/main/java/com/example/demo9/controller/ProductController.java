package com.example.demo9.controller;

import com.example.demo9.entity.Product;
import com.example.demo9.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct() {
		return ResponseEntity.ok(productRepository.findAll());
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) {
		return ResponseEntity.ok(productRepository.findById(id).get());
	}

	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productRepository.save(product));
	}

}
