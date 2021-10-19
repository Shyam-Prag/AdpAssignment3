package za.ac.cput.service;

import za.ac.cput.entity.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer,String>{
    List<Customer> getAllCustomers();
}
