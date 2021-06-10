package za.ac.cput.factory;

import za.ac.cput.entity.Address;

public class AddressFactory {
    public static Address buildAddress(
            String street,
            String houseNumber,
            String zipCode,
            String city
    ) {
        return new Address.Builder()
                .setStreet(street)
                .setHouseNumber(houseNumber)
                .setZipCode(zipCode)
                .setCity(city)
                .build();
    }
}

