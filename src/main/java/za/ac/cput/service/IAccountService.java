package za.ac.cput.service;
/*
Author: Siphelele Nyathi 218334028
Due Date:20 October 2021 */
import za.ac.cput.entity.Account;
import java.util.List;

public interface IAccountService extends IService<Account,String> {
    public List<Account> getAll();
}