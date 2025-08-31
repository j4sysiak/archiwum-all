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

    public void takeCompanyLoan(BigDecimal loan) {
        System.out.println("Loan TakeLoan ...");
    }
}
