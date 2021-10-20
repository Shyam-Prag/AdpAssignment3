package za.ac.cput.entity;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.CustomerFactory;


import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer customer, customer1;

    @Test
    void testEquality() {
        customer = CustomerFactory.createCustomer("Cameron", "Noemdo");
        customer1 = CustomerFactory.createCustomer("John", "Doe");
        assertNotEquals(customer, customer1);
    }

    @Test
    void testIdentity() {
        customer = CustomerFactory.createCustomer("Cameron", "Noemdo");
        customer1 = CustomerFactory.createCustomer("John", "Doe");
        assertNotSame(customer, customer1);
    }
}
