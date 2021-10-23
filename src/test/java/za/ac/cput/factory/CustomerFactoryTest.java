package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Customer;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/*  CustomerFactoryTest.java
    Test class for Student
    Author: Cameron Noemdo 219115443
    Date: 10/06/21
 */

class CustomerFactoryTest
{
    Customer cus1,cus2,cus3;

    @BeforeEach
    void setup()
    {
        cus1=CustomerFactory.createCustomer("John", "Doe");
        cus2=CustomerFactory.createCustomer("Susan", "Mary");
        cus3=cus1;
    }

    @Test
    void testCreation()
    {
        assertNotNull(cus1);
    }

    @Test
    void testCustomerIdentity()
    {
        assertSame(cus1,cus3);
        System.out.println("Test PASSED");
    }

    @Test
    void testCustomerEquality()
    {
        assertEquals(cus1, cus3);
        System.out.println("Test PASSED");
    }

    @Test
    void testCustomerTimeout()
    {
        try
        {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Timeout test PASSED");
        }
        catch(InterruptedException iEx)
        {
            System.out.println("Exception: "+iEx.getMessage());
            System.out.println("Test timed out");
        }
    }
}