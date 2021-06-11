package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Address;
import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {
    Address address1 = AddressFactory.buildAddress("123","7764","Cape Town");
    Address address2 = AddressFactory.buildAddress("69","420","Johannesburg");

    @Test
    void buildAddress(){
        Address address1 = AddressFactory.buildAddress("123","7764","Cape Town");
        assertNotNull(address1);
        System.out.println(address1);
    }
    //equality test
    @Test
    void testEquality(){
        Address address1 = AddressFactory.buildAddress("123","7764","Cape Town");
        Address address2 = address1;
        assertEquals(address1,address2);
    }

    //disabled
    @Disabled("disable for maintenance")
    @Test
    void testEqualityDisable(){
        Address address1 = AddressFactory.buildAddress("123","7764","Cape Town");
        Address address2 = address1;
        assertEquals(address1,address2);
    }

    @Timeout(1000)
    @Test
    void testTimeout()throws InterruptedException{
        Thread.sleep(1000);

        Address address1 = AddressFactory.buildAddress("123","7764","Cape Town");
        Address address2 = address1;
        assertEquals(address1,address2);
    }
}