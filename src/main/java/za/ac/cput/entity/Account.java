package za.ac.cput.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * Account.java
 * Entity for Bank class
 * @author SIPHELELE NYATHI 218334028
 * 10/06/2021
 */

@Entity
@Table (name = "Account")
public class Account implements Serializable {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Id
    @GeneratedValue
    private String accountID, balance, interestRate, interestPeriod;

    public Account() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }



    public String getAccountID() {
        return accountID;
    }

    public String getBalance() {
        return balance;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public String getInterestPeriod() {
        return interestPeriod;
    }




    private Account(AccountBuilder builder) {
        this.accountID = builder.id;
        this.balance = builder.balance;
        this.interestRate = builder.interestRate;
        this.interestPeriod = builder.interestPeriod;
    }

    public static class AccountBuilder {

        private String id, balance, interestRate, interestPeriod;


        public AccountBuilder setId(String id) {
            this.id = id;
            return this;
        }
        public AccountBuilder setBalance(String balance) {
            this.balance = balance;
            return this;

        }

        public AccountBuilder setInterestRate(String interestRate) {
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
