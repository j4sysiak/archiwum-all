package com.company.przypadekIfTrueStatement;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    private BigDecimal balance = BigDecimal.valueOf(1000);
}
