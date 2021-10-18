package za.ac.cput.service;

import za.ac.cput.entity.Address;

import java.util.List;

public interface IAddressService extends IService <Address, String>{
public List<Address> getAll();

}
