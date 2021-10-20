package za.ac.cput.factory;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Contact;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Contact.java
 * Test Contact
 * @author Sayed Abdurra'uf Peters 218149859
 */

public class ContactFactoryTest {
    Contact c1 = ContactFactory.buildContact("Sayed","sayed@gmail.com","0836438274","1");
    Contact c2 = ContactFactory.buildContact("Ziyaad","ziyaad@gmail.com","0836438274","2");

    @Test
    void buildContact(){
        Contact c1 = ContactFactory.buildContact("Sayed","sayed@gmail.com","0836438274","1");
        assertNotNull(c1);
        System.out.println(c1);
    }

    //equality test
    @Test
    void testEquality(){
        Contact c1 = ContactFactory.buildContact("Sayed","sayed@gmail.com","0836438274","1");
        Contact c2 = c1;
        assertEquals(c1,c2);
    }

    //disabled
    @Disabled
    @Test
    void testEqualityDisable(){
        Contact c1 = ContactFactory.buildContact("Sayed","sayed@gmail.com","0836438274","1");
        Contact c2 = c1;
        assertEquals(c1,c2);
    }

    @Timeout(1000)
    @Test
    void testTimeout()throws InterruptedException{
        Thread.sleep(1000);
        Contact c1 = ContactFactory.buildContact("Sayed","sayed@gmail.com","0836438274","1");
        Contact c2 = c1;
        assertEquals(c1,c2);
    }
}

