package za.ac.cput.entity;
/**
 * Statement.java
 * Entity for the Statement class
 * Author: Waseem Osman (216112338)
 * 10/06/2021
 */
public class Statement {

    private final double balance;
    private final String firstName;
    private final String lastName;

    public Statement(Statement.StatementBuilder builder) {
        this.balance = builder.balance;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class StatementBuilder {

        private double balance;
        private String firstName, lastName;

        public Statement.StatementBuilder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public Statement.StatementBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Statement.StatementBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
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

