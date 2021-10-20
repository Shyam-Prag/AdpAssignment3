package za.ac.cput.controllers;
/*
Author: Shyam Prag 218115873
Due Date:20 October 2021 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Address;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.service.AddressService;
import java.util.List;

@RestController
@RequestMapping("/Address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public Address create(@RequestBody Address address){
        Address newAddress1 = AddressFactory.buildAddress(address.getUuid(), address.getStreet(),address.getHouseNumber(),address.getCity(), address.getZipCode());
        return addressService.create(newAddress1);
    }

    @GetMapping("/read/{uuid}")
    public Address read(@PathVariable String addressId){
        return addressService.read(addressId);
    }

    @PostMapping("/update")
    public Address update(@RequestBody Address address) {
        return addressService.update(address);
    }

    @DeleteMapping("/delete/{uuid}")
    public boolean delete(@PathVariable String addressId) {
        return addressService.delete(addressId);
    }

    @GetMapping("/getall")
    public List<Address> getAll(){
        return addressService.getAll();
    }

}
