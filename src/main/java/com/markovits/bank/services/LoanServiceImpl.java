package com.markovits.bank.services;

import com.markovits.bank.domain.Client;
import com.markovits.bank.domain.Loan;
import com.markovits.bank.domain.Officer;
import com.markovits.bank.repositories.ClientRepository;
import com.markovits.bank.repositories.LoanRepository;
import com.markovits.bank.v1.model.LoanApplyDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientServiceImpl clientService;

    public Loan loanApply(LoanApplyDTO loanApplyDTO) {
        // Finding existing Client, creating loan, adding connection
        Client existingClient = clientService.findClientById(loanApplyDTO.getClientId());
        Loan newLoan = createNewLoan(loanApplyDTO);
        existingClient.addLoan(newLoan);
        clientRepository.save(existingClient);

        Optional<Loan> optionalLoan = loanRepository.findByUuid(newLoan.getUuid());
        if (optionalLoan.isPresent()) return optionalLoan.get();
        else throw new RuntimeException("There was a problem trying to save the new Loan with uuid of: " + newLoan.getUuid() + ".");
    }

    private Loan createNewLoan(LoanApplyDTO loanApplyDTO) {
        Loan newLoan = new Loan();
        newLoan.setLoanValue(loanApplyDTO.getLoanValue());
        newLoan.setPending(true);
        newLoan.setAuthorized(null);
        newLoan.setUuid(RandomStringUtils.randomAlphanumeric(8));
        return newLoan;
    }

}
