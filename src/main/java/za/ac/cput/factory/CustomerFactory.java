package za.ac.cput.factory;

import za.ac.cput.entity.Customer;

/*  CustomerFactory.java
    Factory for the Customer
    Author: Cameron Noemdo 219115443
    Date: 10/06/21
 */

public class CustomerFactory
{
    public static Customer createCustomer (String firstName, String lastName)
    {
        return new Customer.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}
