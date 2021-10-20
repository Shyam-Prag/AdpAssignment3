package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Address;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressControllerTest {

    private static Address address = AddressFactory.buildAddress("Middel","67","7764","CPT");

    @Autowired
    private TestRestTemplate testRestTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String addressURL = "http://localhost:8080/address";

    private String username = "username";
    private String password = "password";

    @Test
    void a_create(){
        String url =  "/Address/create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Address> httpEntity = new HttpEntity<>(address,httpHeaders);
        ResponseEntity<Address> postResponse = testRestTemplate.exchange(url,HttpMethod.POST ,httpEntity, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        address = postResponse.getBody();
        System.out.println("Data saved: " + address);
        assertEquals(address.getUuid(), postResponse.getBody().getUuid());

    }

    @Test
    void b_read(){
        String url = "/Address/read/";
        ResponseEntity<Address> responseEntity = testRestTemplate.getForEntity(url, Address.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        System.out.println("Read data: " + responseEntity.getBody());
        assertEquals(address.getUuid(), responseEntity.getBody().getUuid());
    }

    @Test
    void c_update(){
        Address updatedAddress = new Address.Builder().copy(address).setHouseNumber("55").setStreet("Flat").build();

        String url = "/Address/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Address> httpEntity = new HttpEntity<>(updatedAddress, httpHeaders);
        System.out.println("Url used to update the Address: " + url);
        System.out.println("Updated Address: "+ updatedAddress);
        ResponseEntity<Address> responseUpdate = testRestTemplate.exchange(url, HttpMethod.POST, httpEntity, Address.class);
        assertNotNull(responseUpdate.getBody());
    }

    @Test
    void d_getAll(){
        String url = "/Address/getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("read all");
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
    }

    @Test
    void e_delete(){
        String url = "/Address/delete" + address.getUuid();
        System.out.println("Url used to delete the contact: " + url);
        testRestTemplate.delete(url);
    }


}