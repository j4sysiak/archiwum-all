package com.company.przypadekIfTrueStatement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamExample {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testIfTrueStatement() {
        BigDecimal balance = new BankAccount().getBalance();
        BigDecimal c = Optional.ofNullable(balance)  // 1. sprawdzam, czy null
                .map(amount -> runIfAmountNotNull(amount))            //2. jeżeli nie null
                .orElseGet(() -> runIfEmpty());      //3. jeżeli null
        //System.out.println(c);
        assertEquals(c, BigDecimal.valueOf(1000));
    }

    private BigDecimal runIfEmpty() {
        return BigDecimal.ZERO;
    }

    private BigDecimal runIfAmountNotNull(BigDecimal amount) {
        return Optional.of(amount.compareTo(BigDecimal.ZERO) >= 0)// 4. sprawdzam, czy true
                .filter(Boolean::booleanValue)  // 4. będę sprawdzał Booleana
                .map(bool -> ifTrue(amount))  // 5. Jeżeli true
                .orElseGet(() -> ifNotTrue());   // 6. jeżeli false
    }

    private BigDecimal ifNotTrue() {
        try {
            throw new Exception("Amount less then zero!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private BigDecimal ifTrue(BigDecimal amount) {
        return amount;
    }
}
