package za.ac.cput.factory;

import za.ac.cput.entity.Account;


/**
 * AccountFactory.java
 * Factory for Account class
 * @author SIPHELELE NYATHI 218334028
 * 10/06/2021
 */
public class AccountFactory {

    public static Account buildAccount(

            String id,
            String balance,
            String interestRate,
            String interestPeriod

    )

    {
        if (balance.isEmpty() || interestRate.isEmpty() || interestPeriod.isEmpty())
            return null;
        Account account = new Account.AccountBuilder()
                .setId(id)
                .setBalance(balance)
                .setInterestRate(interestRate)
                .setInterestPeriod(interestPeriod)
                .build();
        return account;
    }
    public static AccountDTO buildAccountDTO(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setBalance(account.getBalance());
        dto.setInterestRate(account.getInterestRate());
        dto.setInterestPeriod(account.getInterestPeriod());
        return dto;
    }
}
