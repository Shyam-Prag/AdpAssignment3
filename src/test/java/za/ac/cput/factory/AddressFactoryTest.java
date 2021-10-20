package za.ac.cput.factory;
/**
 * Address Class
 * @author Shyam Prag
 * 218115873
 * 11/06/2021
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Address;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {
    String uuidAddress = UUID.randomUUID().toString();

    Address address1 = AddressFactory.buildAddress("Middel","67","7764","CPT");
    Address address2 = AddressFactory.buildAddress("Flat","52","420","Johannesburg");

    @Test
    void buildAddress(){
        Address address1 = AddressFactory.buildAddress("Middel","67","7764","CPT");
        assertNotNull(address1);
        System.out.println(address1);
    }
    //equality test
    @Test
    void testEquality(){
        Address address1 = AddressFactory.buildAddress("Middel","67","7764","CPT");
        Address address2 = address1;
        assertEquals(address1,address2);
    }

    //disabled
    @Disabled("disable for maintenance")
    @Test
    void testEqualityDisable(){
        Address address1 = AddressFactory.buildAddress("Middel","67","7764","CPT");
        Address address2 = address1;
        assertEquals(address1,address2);
    }

    @Timeout(1000)
    @Test
    void testTimeout()throws InterruptedException{
        Thread.sleep(1000);

        Address address1 = AddressFactory.buildAddress("Middel","67","7764","CPT");
        Address address2 = address1;
        assertEquals(address1,address2);
    }
}
