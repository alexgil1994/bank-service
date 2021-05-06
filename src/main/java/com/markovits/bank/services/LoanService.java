package com.markovits.bank.services;

import com.markovits.bank.domain.Loan;
import com.markovits.bank.v1.model.LoanApplyDTO;
import org.springframework.stereotype.Service;

@Service
public interface LoanService {

    Loan loanApply(LoanApplyDTO loanApplyDTO);

}
