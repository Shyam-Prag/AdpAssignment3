package za.ac.cput.controllers;
/*
Author: Siphelele Nyathi 218334028
Due Date:20 October 2021 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Account;

import za.ac.cput.factory.AccountFactory;
import za.ac.cput.service.AccountService;
import java.util.List;

@RestController
@RequestMapping("/Account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public Account create(@RequestBody Account account){
        Account newAccount = AccountFactory.buildAccount(account.getAccountID(), account.getBalance(), account.getInterestRate(), account.getInterestPeriod());
        return accountService.create(newAccount);
    }

    @GetMapping("/read/{id}")
    public Account read(@PathVariable String id){
        return accountService.read(id);
    }

    @PostMapping("/update")
    public Account update(@RequestBody Account account) {
        return accountService.update(account);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return accountService.delete(id);
    }

    @GetMapping("/getall")
    public List<Account> getAll(){
        return accountService.getAll();
    }
}
