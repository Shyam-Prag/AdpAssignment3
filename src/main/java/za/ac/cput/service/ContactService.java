package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Contact;
import za.ac.cput.repository.ContactRepository;

import java.util.List;

@Service
public class ContactService implements IContactService{
    private static ContactService service = null;

    @Autowired
    private ContactRepository repository;

    @Override
    public Contact create(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Contact update(Contact contact) {
        if(this.repository.existsById(contact.getId()))
            return this.repository.save(contact);
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);

        if(this.repository.existsById(id))
            return false;
        else {
            return true;
        }
    }

    @Override
    public List<Contact> getAll() {
        return null;
    }
}
