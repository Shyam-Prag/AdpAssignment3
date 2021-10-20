package za.ac.cput.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Contact;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Contact create(@RequestBody Contact contact){

        Contact newContact = ContactFactory.buildContact(contact.getName(),contact.getEmail(),contact.getMobile());
        return contactService.create(newContact);
    }

    @PostMapping("/read/{id}")
    public Contact read(@PathVariable String contactId){
        return contactService.read(contactId);
    }

    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact) {
        return contactService.update(contact);
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable String contactId) {
        return contactService.delete(contactId);
    }

    @PostMapping("/getall")
    public List<Contact> getAll(){
        return contactService.getAll();
    }

}

