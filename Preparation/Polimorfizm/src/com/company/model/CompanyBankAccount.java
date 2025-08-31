package com.company.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CompanyBankAccount extends BankAccount {

    //private String label;

    public CompanyBankAccount(BigDecimal balance  /*, String label*/) {
        super(balance);
        //this.label = label;
    }

    public void takeLoan(BigDecimal loan) {
        System.out.println("Loan TakeLoan ...");
    }

    // obsługa polimorfizmu - specyficzne działanie metody makeWithdrawal dla wywołania z typu: CompanyBankAccount
    // nadpisujemy medodę makeWithdrawal z BankAccount
    @Override
    public BigDecimal makeWithdrawal(BigDecimal amount) {
        System.out.println("specyficzne działanie metody makeWithdrawal dla wywołania z typu: CompanyBankAccount");
        return balance = balance
                .add(BigDecimal.valueOf(-1).multiply(runIfAmountNotNull(amount)));
    }

    @Override
    public void requestPersolanLoan() {

    }
}
