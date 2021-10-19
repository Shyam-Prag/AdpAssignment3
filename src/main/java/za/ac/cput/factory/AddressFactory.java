package za.ac.cput.factory;
/**
 * Address Class
 * @author Shyam Prag
 * 218115873
 * 11/06/2021
 */

import za.ac.cput.entity.Address;

import java.util.UUID;

public class AddressFactory {
    public static Address buildAddress(
            String uuid,
            String addressStreet,
            String houseNumber,
            String zipCode,
            String city
    )
    {
        if (addressStreet.isEmpty()|| houseNumber.isEmpty()||zipCode.isEmpty()||city.isEmpty())
        return null;



        Address address = new Address.Builder().setUuid(uuid)
                .setStreet(addressStreet)
                .setHouseNumber(houseNumber)
                .setZipCode(zipCode)
                .setCity(city)
                .build();
        return address;
    }

    public static AddressDTO buildAddressDTO(Address address){
        AddressDTO dto = new AddressDTO();
        dto.setStreet(address.getStreet());
        dto.setHouseNumber(address.getHouseNumber());
        dto.setCity(address.getCity());
        dto.setZipCode(address.getZipCode());

        return dto;
    }
}

