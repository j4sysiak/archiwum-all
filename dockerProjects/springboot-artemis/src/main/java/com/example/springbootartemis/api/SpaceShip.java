package com.example.springbootartemis.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceShip {
    private String name;
    private Integer fuel;
}
