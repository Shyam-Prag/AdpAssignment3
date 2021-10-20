package za.ac.cput.service;

import za.ac.cput.entity.Customer;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{

    private static CustomerService customerService;

    private CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer read(String id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if(this.customerRepository.existsById(customer.getId()))
            return this.customerRepository.save(customer);
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.customerRepository.deleteById(id);

        if(this.customerRepository.existsById(id))
            return false;
        else
            return true;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }
}
