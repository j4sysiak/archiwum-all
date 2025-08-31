package com.company;

import com.company.model.BankAccount;
import com.company.model.CompanyBankAccount;
import com.company.model.PersonalBankAccount;

import java.math.BigDecimal;

public class Client { ;

    public static void main(String[] args) {

        //BankAccount bankAccount = BankAccount.create(BigDecimal.valueOf(0));

        // PersonalBankAccount bankAccount = new PersonalBankAccount(BigDecimal.valueOf(1) /*, "llll"*/);
        // bankAccount.requestPersolanLoan();

        CompanyBankAccount bankAccount = new CompanyBankAccount(BigDecimal.valueOf(1999) /*, "llll"*/);
        bankAccount.takeCompanyLoan(BigDecimal.valueOf(300000));

        bankAccount.setBalance(BigDecimal.valueOf(1000));
        System.out.println(bankAccount.getBalance());

        System.out.println(bankAccount.makeDeposit(BigDecimal.valueOf(1)));
        System.out.println(bankAccount.makeWithdrawal(BigDecimal.valueOf(100)));
    }
}
