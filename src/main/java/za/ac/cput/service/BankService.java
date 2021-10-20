package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Bank;
import za.ac.cput.repository.BankRepository;

import java.util.List;

@Service
public class BankService implements IBankService {
    private static BankService service = null;

    @Autowired
    private BankRepository repository;

    @Override
    public Bank create(Bank bank) {
        return this.repository.save(bank);
    }

    @Override
    public Bank read(String uuid) {
        return this.repository.findById(uuid).orElse(null);
    }

    @Override
    public Bank update(Bank bank) {
        if(this.repository.existsById(bank.getUuid()))
            return this.repository.save(bank);
        return null;
    }

    @Override
    public boolean delete(String uuid) {
        this.repository.deleteById(uuid);

        if(this.repository.existsById(uuid))
            return false;
        else
            return true;
    }

    @Override
    public List<Bank> getAll() {
        return null;
    }
}
