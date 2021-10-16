package za.ac.cput.repository;

import za.ac.cput.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements IRepository <Customer,String>{
    private List<Customer> customerDB;

    public CustomerRepository() {
        this.customerDB = new ArrayList<>();
    }

    @Override
    public Customer create(Customer customer) {
        this.customerDB.add(customer);
        return customer;
    }

    @Override
    public Customer read(String id) {
        return this.customerDB.stream().filter(c -> c.getId().equalsIgnoreCase(id)).findAny().orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        Customer oldCustomer=read(customer.getId());
        if(oldCustomer!=null)
        {
            customerDB.remove(oldCustomer);
            customerDB.add(customer);
        }
        return customer;
    }

    @Override
    public boolean delete(String id) {
        Customer customer=read(id);
        return this.customerDB.remove(customer);
    }

    public List<Customer> getAll()
    {
        return this.customerDB;
    }

    public void deleteAll(){
        this.customerDB.clear();
    }
}
