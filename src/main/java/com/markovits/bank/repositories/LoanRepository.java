package com.markovits.bank.repositories;

import com.markovits.bank.domain.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

    Optional<Loan> findById(Long id);

    Optional<Loan> findByUuid(String uuid);

    @Query(value = "SELECT * FROM LOAN l WHERE l.pending = true", nativeQuery = true)
    Set<Loan> findAllLoanListWherePendingEqualsTrueOrderByIdDesc();
}
