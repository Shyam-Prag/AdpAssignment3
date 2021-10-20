package za.ac.cput.repository;
/*
Author: Siphelele Nyathi 218334028
Due Date:20 October 2021 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
