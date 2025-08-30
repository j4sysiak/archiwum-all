package com.example.UnitTestRestfulWebServicesTestCRUD.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_states")
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(length = 64)
    private String name;

//    @ManyToOne    // Many States toOne Country
//    @JoinColumn(name = "country_id")
//    private Country country;
}