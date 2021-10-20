package za.ac.cput.factory;

import za.ac.cput.entity.Contact;
/**
 * Contact.java
 * Factory Contact
 * @author Sayed Abdurra'uf Peters 218149859
 */

public class ContactFactory {
    public static Contact buildContact(

            String name,
            String email,
            String mobile,
            String id
    )

    {
        if (name.isEmpty()|| !email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$") ||mobile.isEmpty())
            return null;
        Contact contact = new Contact.Builder()
                .id(id)
                .email(email)
                .mobile(mobile)
                .name(name)
                .build();
        return contact;
    }
    public static ContactDTO buildContactDTO(Contact contact) {
        ContactDTO dto = new ContactDTO();
        dto.setEmail(contact.getEmail());
        dto.setMobile(contact.getMobile());
        dto.setName(contact.getName());
        return dto;
    }
}
