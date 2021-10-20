package za.ac.cput.controllers;

import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService customerService;

    public Customer create(Customer customer)
    {
        Customer newCustomer= CustomerFactory.createCustomer(customer.getFirstName(), customer.getLastName());
        return customerService.create(newCustomer);
    }

    public Customer read(String id)
    {
        return customerService.read(id);
    }

    public Customer update(Customer customer)
    {
        return customerService.update(customer);
    }

    public boolean delete(String id)
    {
        return customerService.delete(id);
    }

    public List<Customer> getAll()
    {
        return customerService.getAll();
    }
}
