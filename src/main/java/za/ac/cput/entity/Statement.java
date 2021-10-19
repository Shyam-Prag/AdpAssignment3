package za.ac.cput.entity;
/**
 * Statement.java
 * Entity for the Statement class
 * Author: Waseem Osman (216112338)
 * 10/06/2021
 *
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Statement")
public class Statement {

    @Id
    @GeneratedValue
    private double balance;
    private String id,firstName, lastName;

    public Statement(){

    }
 
    private Statement(Builder builder) {
        this.id = builder.id;
        this.balance = builder.balance;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getId()
    {
        return id;
    }
    public double getBalance()
    {
        return balance;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }



    public static class Builder
    {
        public double balance;
        private String id,firstName, lastName;

        public Statement.Builder setID(String id)
        {
            this.id=id;
            return this;
        }

        public Statement.Builder setBalance(Double id)
        {
            this.balance=balance;
            return this;
        }
        
        

        public Statement.Builder setFirstName(String firstName)
        {
            this.firstName=firstName;
            return this;
        }

        public Statement.Builder setLastName (String lastName)
        {
            this.lastName=lastName;
            return this;
        }

        public Statement build()
        {
            return new Statement(this);
        }

    }

    @Override
    public String toString() {
        return "Statement{" +
                "balance=" + balance +'\'' +
                ", firstName=" + firstName +'\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

