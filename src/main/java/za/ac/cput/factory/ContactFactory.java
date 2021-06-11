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

        int rand = (int)(Math.random()*(1000-1+1)+1);
        String phoneNum ="AS"+Integer.toString(rand)+ name.charAt(0);

        return new Contact.Builder()
                .phone(phoneNum)
                .name(name)
                .email(email)
                .mobile(mobile)
                .build();
    }
}
