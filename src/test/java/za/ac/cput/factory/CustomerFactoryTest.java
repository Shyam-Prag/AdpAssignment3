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
    Customer cus1,cus2;

    @BeforeEach
    void setup()
    {
        cus1=CustomerFactory.createCustomer("John", "Doe");
        cus2=CustomerFactory.createCustomer("Susan", "Mary");
    }

    @Test
    void testCustomerIdentity()
    {
        assertSame(cus1,cus2);
        System.out.println("Objects are identical.");
    }

    @Test
    void testCustomerEquality()
    {
        assertEquals(cus1, cus2);
        System.out.println("Objects are equal.");
    }

    @Test
    @Timeout(1)
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

    @Test
    @Disabled("Test temporarily disabled due to maintenance.")
    void testCustomerDisabled()
    {
        assertEquals(cus1, cus2);
        System.out.println("Objects are equal.");
    }
}