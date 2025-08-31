package com.company.szkolenie3;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Person {
    private String name;
    private String surname;
    int age;
    private BigDecimal wage;
    private List<Car> cars;
}
