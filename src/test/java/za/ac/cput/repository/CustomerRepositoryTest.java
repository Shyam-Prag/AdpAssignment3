package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {
    private static final CustomerRepository customerRepository=new CustomerRepository();
    private static final Customer customer= CustomerFactory.createCustomer("Cameron","Noemdo");

    @Test
    void create() {
        Customer customer1=customerRepository.create(customer);
        assertEquals(customer1.getId(),customer.getId());
        System.out.println("Created customer: "+customer1);
    }

    @Test
    void read() {
        Customer customer1=customerRepository.read(customer.getId());
        assertEquals(customer1.getId(),customer.getId());
        System.out.println("Read customer: "+customer1);
    }

    @Test
    void update() {

    }

    @Test
    void delete() {
        customerRepository.delete(customer.getId());
        System.out.println("Deleted customer "+customer.getId());
    }
}
