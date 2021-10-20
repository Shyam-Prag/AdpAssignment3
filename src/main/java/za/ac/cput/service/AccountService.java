package za.ac.cput.service;
/*
Author: Siphelele Nyathi 218334028
Due Date:20 October 2021 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Account;
import za.ac.cput.repository.AccountRepository;

import java.util.List;


@Service
public class AccountService implements IAccountService{

    private static AccountService service = null;

    @Autowired
    private AccountRepository repository;

    @Override
    public Account create(Account account) {
        return this.repository.save(account);
    }

    @Override
    public Account read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Account update(Account account) {
        if(this.repository.existsById(account.getAccountID()))
            return this.repository.save(account);
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);

        if(this.repository.existsById(id))
            return false;
        else
            return true;
    }

    @Override
    public List<Account> getAll() {
        return null;
    }


}
