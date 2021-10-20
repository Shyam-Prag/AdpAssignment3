package za.ac.cput.service;

import za.ac.cput.entity.Contact;

import java.util.List;

public interface IContactService extends IService<Contact,String> {
    public List<Contact> getAll();
}
