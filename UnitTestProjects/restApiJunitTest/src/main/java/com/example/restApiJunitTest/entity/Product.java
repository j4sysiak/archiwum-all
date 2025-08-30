package com.example.restApiJunitTest.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_product")
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product  {

    @Id
    private Long id;
    private String name;
    private Double price;
    private String description;
}
