package za.ac.cput.factory;
/*
Author: Siphelele Nyathi 218334028
Due Date:20 October 2021 */

public class AccountDTO {


    private String balance, interestRate, interestPeriod;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getInterestPeriod() {
        return interestPeriod;
    }

    public void setInterestPeriod(String interestPeriod) {
        this.interestPeriod = interestPeriod;
    }
}
