package za.ac.cput.factory;

/**
 * Statement.java
 * Factory for the Statement class
 * Author: Waseem Osman (216112338)
 * 10/06/2021
 */

import java.util.UUID;

import za.ac.cput.entity.Statement;



public class StatementFactory {

    public static Statement buildStatement(
            String id,
            double balance,
            String firstName,
            String lastName
    )

    {
        return new Statement.Builder()
                .setID(id)
                .setBalance(balance)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}

