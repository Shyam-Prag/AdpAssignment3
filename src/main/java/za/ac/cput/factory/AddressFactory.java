package za.ac.cput.factory;
/**
 * Address Class
 * @author Shyam Prag
 * 218115873
 * 11/06/2021
 */

import za.ac.cput.entity.Address;

public class AddressFactory {
    public static Address buildAddress(

            String houseNumber,
            String zipCode,
            String city
    )

    {
        if (houseNumber.isEmpty()||zipCode.isEmpty()||city.isEmpty())
        return null;


        int rand = (int)(Math.random()*(1000-1+1)+1);
        String addressStreet ="AS"+Integer.toString(rand)+ houseNumber.charAt(0);

        return new Address.Builder()
                .setStreet(addressStreet)
                .setHouseNumber(houseNumber)
                .setZipCode(zipCode)
                .setCity(city)
                .build();
    }

}

