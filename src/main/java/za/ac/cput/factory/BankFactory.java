package za.ac.cput.factory;

/**
 * Bank Factory Class
 * @author Emeka Thato Nwamadi
 * 219404070
 * 10/06/2021
 */

import za.ac.cput.entity.Bank;

public class BankFactory {

    private String name;

    public static Bank buildAddress(String name) {
        return new Bank.bankBuilder()
                .setName(name)
                .build();
    }
    public void create() {
        this.name="First National Bank";
    }
}
