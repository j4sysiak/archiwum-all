package com.company;

import java.math.BigDecimal;
import java.util.Optional;

public class Client {

    private static BankAccount bankAccount;

    public static void main(String[] args) {

        /*
        Enkapsulacja, czyli heretyzacja to  ukrywanie wewnętrznej implementacji.
        Żaden zewnętrzny obiekt nie może zmienić stanu obiektów.
        Tylko prywatne metody wewnętrzne są uprawnione do zmiany tego stanu (np. set())
        */
        bankAccount = BankAccount.create(BigDecimal.valueOf(0));
        bankAccount.setBalance(BigDecimal.valueOf(1000));
        System.out.println(bankAccount.getBalance());

        System.out.println(bankAccount.makeDeposit(BigDecimal.valueOf(1)));
        System.out.println(bankAccount.makeWithdrawal(BigDecimal.valueOf(100)));
    }
}
