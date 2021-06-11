package za.ac.cput.factory;

import za.ac.cput.entity.Account;

/**
 * AccountFactory.java
 * Factory for Account class
 * @author SIPHELELE NYATHI 218334028
 * 10/06/2021
 */
public class AccountFactory {

    public static Account build(double balance, double interestRate, String interestPeriod) {

        return new Account.AccountBuilder().setBalance(balance)
                .setInterestRate(interestRate).setInterestPeriod(interestPeriod).build();
    }
}
