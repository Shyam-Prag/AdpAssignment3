package za.ac.cput.entity;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Bank;
import za.ac.cput.factory.AccountFactory;
import za.ac.cput.factory.BankFactory;

import javax.xml.namespace.QName;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    public void main() {

//        Bank.bankBuilder(name);
        String name;
        name = "FNB";

        assertEquals("FNB", name);
    }

}