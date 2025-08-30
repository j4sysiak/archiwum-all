package com.example.demo9.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private double price;
    private String description;
}
