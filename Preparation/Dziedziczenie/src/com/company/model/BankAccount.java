package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Optional;

@Builder
@AllArgsConstructor
public class BankAccount {

    private BigDecimal balance;

    public static BankAccount create(BigDecimal balance) {
        return BankAccount.builder()
                .balance(balance)
                .build();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal amount) {
        BigDecimal c = Optional.ofNullable(amount)  // 1. sprawdzam, czy null
                .map(this::runIfAmountNotNull)     // 2. jeżeli nie null
                .orElseGet(this::runIfEmpty);      // 3. jeżeli null
        this.balance = c;
    }

    private BigDecimal runIfEmpty() {
        return BigDecimal.ZERO;
    }

    private BigDecimal runIfAmountNotNull(BigDecimal amount) {
        return Optional.of(amount.compareTo(BigDecimal.ZERO) >= 0)// 4. sprawdzam, czy true
                .filter(Boolean::booleanValue)  // 4. będę sprawdzał Booleana
                .map(bool -> ifTrue(amount))    // 5. Jeżeli true
                .orElseGet(() -> ifNotTrue());  // 6. jeżeli false
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

    public BigDecimal makeDeposit(BigDecimal amount) {
        return balance = balance.add(runIfAmountNotNull(amount));
    }

    public BigDecimal makeWithdrawal(BigDecimal amount) {
        return balance = balance.add(BigDecimal.valueOf(-1).multiply(runIfAmountNotNull(amount)));
    }
}
