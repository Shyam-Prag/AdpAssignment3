package za.ac.cput.controllers;
/*
Author: Emeka Thato Nwamadi
Due Date:20 October 2021 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Bank;
import za.ac.cput.factory.BankFactory;
import za.ac.cput.service.BankService;
import java.util.List;

@RestController
@RequestMapping("/Bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/create")
    public Bank create(@RequestBody Bank bank){
        Bank newBank1 = BankFactory.buildBank(bank.getUuid(), bank.getBankName(),bank.getBankBranch(),bank.getCity(), bank.getZipCode());
        return bankService.create(newBank1);
    }

    @GetMapping("/read/{uuid}")
    public Bank read(@PathVariable String bankId){
        return bankService.read(bankId);
    }

    @PostMapping("/update")
    public Bank update(@RequestBody Bank bank) {
        return bankService.update(bank);
    }

    @DeleteMapping("/delete/{uuid}")
    public boolean delete(@PathVariable String bankId) {
        return bankService.delete(bankId);
    }

    @GetMapping("/getall")
    public List<Bank> getAll(){
        return bankService.getAll();
    }

}
