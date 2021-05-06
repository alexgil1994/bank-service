package com.markovits.bank.services;

import com.markovits.bank.domain.Loan;
import com.markovits.bank.v1.model.EditLoanDTO;
import com.markovits.bank.v1.model.LoanApplyDTO;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface LoanService {

    Loan findLoanById(Long id);

    Loan findLoanByUuid(String uuid);

    Loan loanApply(LoanApplyDTO loanApplyDTO);

    Set<Loan> getAllPendingLoans();

    Loan editLoan(EditLoanDTO editLoanDTO);
}
