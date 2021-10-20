package za.ac.cput.factory;

/**
 * Bank Factory Class
 * @author Emeka Thato Nwamadi
 * 219404070
 * 10/06/2021
 */

import za.ac.cput.entity.Bank;
import za.ac.cput.entity.Bank;

public class BankFactory {
    public static Bank buildBank(
            String uuid,
            String bankName,
            String bankBranch,
            String zipCode,
            String city
    )
    {
        if (bankName.isEmpty()|| bankBranch.isEmpty()||zipCode.isEmpty()||city.isEmpty())
            return null;



        Bank bank = new Bank.Builder().setUuid(uuid)
                .setBankName(bankName)
                .setBankBranch(bankBranch)
                .setZipCode(zipCode)
                .setCity(city)
                .build();
        return bank;
    }

    public static BankDTO buildBankDTO(Bank bank){
        BankDTO dto = new BankDTO();
        dto.setBankName(bank.getBankName());
        dto.setBankBranch(bank.getBankBranch());
        dto.setCity(bank.getCity());
        dto.setZipCode(bank.getZipCode());

        return dto;
    }
}

