package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Contact;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactControllerTest {
    private static Contact contact1 = ContactFactory.buildContact("Alber", "Albermarle@gmail.com", "30812923");
    private static Contact contact2 = ContactFactory.buildContact("Ice", "Ice@gmail.com", "308129231");
    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String contactURL = "http://localhost:8080/contact";

    private String username = "username";
    private String password = "password";

    @Test
    void a_createContact() {
        String url = contactURL + "/create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Contact> httpEntity = new HttpEntity<>(contact1, httpHeaders);
        ResponseEntity<Contact> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Contact.class);
        assertNotNull(responseEntity.getBody());
        contact1 = responseEntity.getBody();
        System.out.println("New Contact: " + contact1);
        assertEquals(contact1.getId(), responseEntity.getBody().getId());
    }
    @Test
    void b_createAddress2(){
        String url = contactURL + "/create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Contact> httpEntity = new HttpEntity<>(contact2, httpHeaders);
        ResponseEntity<Contact> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Contact.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        contact2 = responseEntity.getBody();
        System.out.println("New Contact: "+contact2);
        assertEquals(contact2.getId(), responseEntity.getBody().getId());
    }

    @Test
    void d_readAddress(){
        String url = contactURL + "/read/" + contact1.getId();
        httpHeaders.setBasicAuth(username,password);
        HttpEntity<Contact> httpEntity = new HttpEntity<>(contact1, httpHeaders);
        ResponseEntity<Contact> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Contact.class);
        assertNotNull(responseEntity);
        System.out.println("Read data: " + responseEntity.getBody());
        assertEquals(contact1.getId(), responseEntity.getBody().getId());
    }

    @Test
    void e_updateAddress(){
        Contact updatedAddress = new Contact.Builder().copy(contact1).setName("Sayed").build();
        String url = contactURL + "/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Contact> httpEntity = new HttpEntity<>(updatedAddress, httpHeaders);
        System.out.println("Url used to update the contact: " + url);
        System.out.println("Updated Contact: "+ updatedAddress);
        ResponseEntity<Contact> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Contact.class);
        assertNotNull(responseUpdate.getBody());
    }

    @Test
    void f_deleteAddress(){
        String url = contactURL + "/delete" + contact1.getId();
        System.out.println("Url used to delete the contact: " + url);
        restTemplate.delete(url);
    }

    @Test
    void g_getAllAddresses(){
        String url = contactURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Get All Contact");
        System.out.println(responseGetAll);
        System.out.println(responseGetAll.getBody());
    }
}

