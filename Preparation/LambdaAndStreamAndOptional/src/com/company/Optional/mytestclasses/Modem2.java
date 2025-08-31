package com.company.Optional.mytestclasses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Modem2 {
    private double price;

    public static Modem2 create(double price) {
        return Modem2.builder()
                .price(price)
                .build();
    }
}