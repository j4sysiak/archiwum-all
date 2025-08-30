package com.company;

import com.company.model.BankAccount;
import com.company.model.CompanyBankAccount;
import com.company.model.PersonalBankAccount;

import java.math.BigDecimal;

public class Client {

    private static BankAccount bankAccount;

    public static void main(String[] args) {

        /*
        Polimorfizm - podczas działania programu przy wywołaniu np. metody makeWithdrawal z klasy bazowej BankAccount
        to w zależności od typu, czy wywołamy metodę z CompanyBankAccount, czy z PersonalBankAccount
        to konkretna implementacja zostanie wywołana (nadpisujemy metodę w klasach dziedziczących @Override)

        np. dla wywołania metody makeWithdrawal z typu PersonalBankAccount będzie się inaczej zachowywała,
        niż dla wywołania z CompanyBankAccount
        (bo będzie wywoływana inna metoda, raz z klasy PersonalBankAccount a innym razem z CompanyBankAccount)
        */

        bankAccount = BankAccount.create(BigDecimal.valueOf(0));

        BankAccount personalBankAccount = new PersonalBankAccount(BigDecimal.valueOf(1) /*, "llll"*/);
        personalBankAccount.requestPersolanLoan();
        personalBankAccount.makeWithdrawal(BigDecimal.valueOf(100));
        personalBankAccount.makeDeposit(BigDecimal.valueOf(33));

        BankAccount companyBankAccount = new CompanyBankAccount(BigDecimal.valueOf(1999) /*, "llll"*/);
        companyBankAccount.makeWithdrawal(BigDecimal.valueOf(1900)) ; // .takeLoan(BigDecimal.valueOf(300000));
        companyBankAccount.makeDeposit(BigDecimal.valueOf(33));

        bankAccount.setBalance(BigDecimal.valueOf(1000));
        System.out.println(bankAccount.getBalance());

        System.out.println(bankAccount.makeDeposit(BigDecimal.valueOf(1)));
        System.out.println(bankAccount.makeWithdrawal(BigDecimal.valueOf(100000)));
    }
}
