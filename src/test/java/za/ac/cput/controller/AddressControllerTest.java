package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.entity.Address;
import za.ac.cput.factory.AddressFactory;

import javax.swing.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int portServer;
    private final String  baseUrl = "http://localhost:"+portServer+"/address";
    String uuid123 = UUID.randomUUID().toString();
    private static Address address = AddressFactory.buildAddress("","Middel","67","7764","CPT");

    @Test
    void a_create(){
        String url =  "/Address/create";
        ResponseEntity<Address> postResponse = testRestTemplate.postForEntity(url, address, Address.class);
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
        ResponseEntity<Address> responseEntity = testRestTemplate.postForEntity(url, updatedAddress, Address.class);
        assertNotNull(responseEntity);
        System.out.println("Updated data: " + responseEntity.getBody());
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
        String url = "/Address/delete/" ;
        ResponseEntity<Address> responseEntity = testRestTemplate.getForEntity(url, Address.class);
        assertNotNull(responseEntity.getBody().getUuid(), "Address uuid{'" + address.getUuid() + "'} was not found.");
        testRestTemplate.delete(url);
    }


}
