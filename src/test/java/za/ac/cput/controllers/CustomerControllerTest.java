package za.ac.cput.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    Customer customer= CustomerFactory.createCustomer("John","Doe");

    @Autowired
    private TestRestTemplate testRestTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private String customerURL="http://localhost:8080/customer/";

    private String username = "username";
    private String password = "password";

    @Test
    void create() {
        String url=customerURL+"create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Customer> httpEntity = new HttpEntity<>(customer,httpHeaders);
        ResponseEntity<Customer> postResponse = testRestTemplate.exchange(url,HttpMethod.POST ,httpEntity, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        customer = postResponse.getBody();
        System.out.println("Customer added: " + customer);
        assertEquals(customer.getId(), postResponse.getBody().getId());
    }

    @Test
    void read() {
        String url=customerURL+"read/"+customer.getId();
        ResponseEntity<Customer> responseEntity=testRestTemplate.getForEntity(url,Customer.class);
        System.out.println("Customer: "+responseEntity.getBody());
        assertEquals(customer.getId(), Objects.requireNonNull(responseEntity.getBody()).getId());
    }

    @Test
    void update() {

        Customer newCustomer=new Customer.Builder().copy(customer).setFirstName("Cameron").setLastName("Noemdo").build();
        String url=customerURL+"update";
        httpHeaders.setBasicAuth(username,password);
        System.out.println("URL: "+url);

        ResponseEntity<Customer> responseEntity=testRestTemplate.postForEntity(url,newCustomer,Customer.class);
        assertEquals(customer.getId(), Objects.requireNonNull(responseEntity.getBody()).getId());

    }

    @Test
    void delete() {
        String url=customerURL+"delete/"+customer.getId();
        System.out.println("URL: "+url);
        testRestTemplate.delete(url);
    }

    @Test
    void getAll()
    {
        String url=customerURL+"getall";
        HttpHeaders httpHeaders=new HttpHeaders();
        HttpEntity<String> entity=new HttpEntity<>(null,httpHeaders);
        ResponseEntity<String> response=testRestTemplate.exchange(url,HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }
}