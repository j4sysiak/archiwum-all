package com.company.Optional.mytestclasses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class Modem {
    private BigDecimal price;

    public static Modem create(BigDecimal price) {
        return Modem.builder()
                .price(price)
                .build();
    }
}
