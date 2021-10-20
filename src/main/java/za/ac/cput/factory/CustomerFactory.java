package za.ac.cput.factory;

import za.ac.cput.entity.Customer;

import java.util.UUID;

/*  CustomerFactory.java
    Factory for the Customer
    Author: Cameron Noemdo 219115443
    Date: 10/06/21
 */

public class CustomerFactory
{
    public static Customer createCustomer (String firstName, String lastName)
    {
        if (firstName.isEmpty()||lastName.isEmpty()||firstName.matches("[^a-zA-Z]")||lastName.matches("[^a-zA-Z]"))
            return null;

        String id= UUID.randomUUID().toString(); //class needed to generate a unique ID
        return new Customer.Builder()
                .setID(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}
