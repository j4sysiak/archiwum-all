package com.company.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
public class PersonalBankAccount extends BankAccount {

    //private String label;

    public PersonalBankAccount(BigDecimal balance  /*, String label*/) {
        super(balance);
        //this.label = label;
    }

   // @Override
    public void requestPersolanLoan() {
        System.out.println("Making RequestPersolanLoan ... in PersonalBankAccount");
    }

    //obsługa polimorfizmu - specyficzne działanie metody makeWithdrawal dla wywołania z typu: PersonalBankAccount
    //nadpisujemy medodę makeWithdrawal z BankAccount
    @Override
    public BigDecimal makeWithdrawal(BigDecimal withdrawalValuew) {
        System.out.println("specyficzne działanie metody makeWithdrawal dla wywołania z typu: PersonalBankAccount");
        if (balance.add(withdrawalValuew.multiply(BigDecimal.valueOf(-1))).compareTo(BigDecimal.ZERO) < 0) {
            //throw new RuntimeException("PersonalBankAccount bank account cannot go to debt");
        }
        return  balance = balance.add(BigDecimal.valueOf(-1).multiply(runIfAmountNotNull(withdrawalValuew)));
    }
}
