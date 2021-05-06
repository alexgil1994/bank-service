package com.markovits.bank.repositories;

import com.markovits.bank.domain.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

    Optional<Loan> findById(Long id);

    Optional<Loan> findByUuid(String uuid);
}
