package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Address;
import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {
    Address address1;
    @BeforeEach
    void setup(){
      address1 = AddressFactory.buildAddress("Middel road","123","7764","Cape Town");
    }

    @Test
    void buildAddress(){
        assertNotNull(address1);
        System.out.println(address1);
    }
}