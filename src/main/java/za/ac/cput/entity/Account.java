package za.ac.cput.entity;

/**
 * This is an Account Class
 *
 * @author SIPHELELE NYATHI 218334028
 * 10/06/2021
 */

public class Account {

    private double balance, interestRate;
    private String interestPeriod;


    private Account(AccountBuilder builder) {
        this.balance = builder.balance;
        this.interestRate = builder.interestRate;
        this.interestPeriod = builder.interestPeriod;
    }

    public static class AccountBuilder {

        private double balance, interestRate;
        private String interestPeriod;


        public AccountBuilder setBalance(double balance) {
            this.balance = balance;
            return this;

        }

        public AccountBuilder setInterestRate(double interestRate) {
            this.interestRate = interestRate;
            return this;

        }

        public AccountBuilder setInterestPeriod(String interestPeriod) {
            this.interestPeriod = interestPeriod;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", interestRate=" + interestRate +
                ", interestPeriod='" + interestPeriod + '\'' +
                '}';
    }
}
