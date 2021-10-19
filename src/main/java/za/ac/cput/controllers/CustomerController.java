package za.ac.cput.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public Customer create(Customer customer)
    {
        Customer customer1= CustomerFactory.createCustomer(customer.getFirstName(), customer.getLastName());
        return customerService.create(customer1);
    }

    @PostMapping("/read")
    public Customer read(String id)
    {
        return customerService.read(id);
    }

    @PostMapping("/update")
    public Customer update(Customer customer)
    {
        return customerService.update(customer);
    }

    @PostMapping("/update")
    public boolean delete(String id)
    {
        return customerService.delete(id);
    }

    @PostMapping("/getall")
    public List<Customer> getAll()
    {
        return customerService.getAllCustomers();
    }
}
