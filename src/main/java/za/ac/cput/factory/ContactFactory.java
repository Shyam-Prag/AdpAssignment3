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
            String mobile
    )

    {
        if (name.isEmpty()|| !email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$") ||mobile.isEmpty())

            return null;
        int rand = (int) (Math.random() * (1000 - 1 + 1) + 1);
        String uID = "ID" + Integer.toString(rand) + name.charAt(0);
        Contact contact = new Contact.Builder()
                .setId(uID)
                .setEmail(email)
                .setMobile(mobile)
                .setName(name)
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
