package com.example.UnitTestRestfulWebServicesTestCRUD.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_countries")
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(length = 64)
    private String name;

//    @OneToMany(mappedBy = "country")  //One Country to Many States
//    private Set<State> states;
}
