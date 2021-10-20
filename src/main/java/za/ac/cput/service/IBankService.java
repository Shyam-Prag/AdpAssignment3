package za.ac.cput.service;

import za.ac.cput.entity.Bank;

import java.util.List;

public interface IBankService extends IService <Bank, String>{
    public List<Bank> getAll();

}