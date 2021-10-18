package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService implements IAddressService {
    private static AddressService service = null;

    @Autowired
    private AddressRepository repository;

    @Override
    public Address create(Address address) {
      return this.repository.save(address);
    }

    @Override
    public Address read(String uuid) {
        return this.repository.findById(uuid).orElse(null);
    }

    @Override
    public Address update(Address address) {
        if(this.repository.existsById(address.getUuid()))
            return this.repository.save(address);
        return null;
    }

    @Override
    public boolean delete(String uuid) {
        this.repository.deleteById(uuid);

        if(this.repository.existsById(uuid))
            return false;
        else
            return true;
    }

    @Override
    public List<Address> getAll() {
        return null;
    }
}
