package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Customer;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    private static CustomerService customerService=null;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer read(String s) {
        return this.customerRepository.findById(s).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if(this.customerRepository.existsById(customer.getId()))
        {
            return this.customerRepository.save(customer);
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean delete(String s) {
        this.customerRepository.deleteById(s);
        if (this.customerRepository.existsById(s))
            return false;
        return true;
    }
}
