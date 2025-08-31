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

    public void requestPersolanLoan() {
        System.out.println("Making RequestPersolanLoan ...");
    }
}
