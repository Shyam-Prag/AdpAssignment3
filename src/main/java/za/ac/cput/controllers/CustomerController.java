package za.ac.cput.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Customer create(@RequestBody Customer customer)
    {
        Customer newCustomer= CustomerFactory.createCustomer(customer.getFirstName(), customer.getLastName());
        return customerService.create(newCustomer);
    }

    @GetMapping("/read/{id}")
    public Customer read(@PathVariable String id)
    {
        return customerService.read(id);
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer)
    {
        return customerService.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id)
    {
        return customerService.delete(id);
    }

    @GetMapping("/getall")
    public List<Customer> getAll()
    {
        return customerService.getAll();
    }
}
