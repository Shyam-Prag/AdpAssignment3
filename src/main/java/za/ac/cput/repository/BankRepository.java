package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, String> {
}

