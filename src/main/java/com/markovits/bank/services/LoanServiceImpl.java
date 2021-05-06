package com.markovits.bank.services;

import com.markovits.bank.domain.Client;
import com.markovits.bank.domain.Loan;
import com.markovits.bank.domain.Officer;
import com.markovits.bank.repositories.ClientRepository;
import com.markovits.bank.repositories.LoanRepository;
import com.markovits.bank.repositories.OfficerRepository;
import com.markovits.bank.v1.model.EditLoanDTO;
import com.markovits.bank.v1.model.LoanApplyDTO;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OfficerRepository officerRepository;

    @Autowired
    private OfficerServiceImpl officerService;

    @Autowired
    private ClientServiceImpl clientService;

    @Override
    public Loan findLoanById(Long id) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        if (optionalLoan.isPresent())
            return optionalLoan.get();
        else
            throw new RuntimeException("Loan was not found");
    }

    @Override
    public Loan findLoanByUuid(String uuid) {
        Optional<Loan> optionalLoan = loanRepository.findByUuid(uuid);
        if (optionalLoan.isPresent())
            return optionalLoan.get();
        else
            throw new RuntimeException("Loan was not found by uuid of " + uuid + ".");
    }

    @Override
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

    @Override
    public Set<Loan> getAllPendingLoans() {
        return loanRepository.findAllLoanListWherePendingEqualsTrueOrderByIdDesc();
    }

    @Override
    public Loan editLoan(EditLoanDTO editLoanDTO) {
        checkEmptyOrBlankString(editLoanDTO.getLoanUuid());
        // Get existing Loan and Officer
        Loan existingLoan = findLoanByUuid(editLoanDTO.getLoanUuid());
        Officer existingOfficer = officerService.findOfficerById(editLoanDTO.getOfficerId());
        // Patching
        if (editLoanDTO.getAuthorized() != null)
            existingLoan.setAuthorized(editLoanDTO.getAuthorized());

        if (editLoanDTO.getPending() != null)
            existingLoan.setPending(editLoanDTO.getPending());

        if (editLoanDTO.getLoanValue() != null)
            existingLoan.setLoanValue(editLoanDTO.getLoanValue());

        // TODO: 5/6/2021 If we want to be able to change the officer that works on a Loan then we would need to find the previous Officer delete the connection and then connect with the new Officer
        // Adding connection between Officer and Loan saving
        if (existingLoan.getOfficer() == null){
            existingOfficer.addLoan(existingLoan);
            officerRepository.save(existingOfficer);
        }

        // If the edit authorized the loan, we are adding the funds to the client's accountBalance
        if (!existingLoan.getAuthorized() && editLoanDTO.getAuthorized()){
            Client existingClient = existingLoan.getClient();
            existingClient.setAccountBalance(existingClient.getAccountBalance().add(editLoanDTO.getLoanValue()));
        }

        // Returning the edited Loan
        return loanRepository.findByUuid(editLoanDTO.getLoanUuid()).get();
    }

    private void checkEmptyOrBlankString(String string){
        if (StringUtils.isEmpty(string) && StringUtils.isBlank(string)){
            throw new RuntimeException("Edit Loan was unsuccessful because no Loan uuid was specified.");
        }
    }

    private Loan createNewLoan(LoanApplyDTO loanApplyDTO) {
        Loan newLoan = new Loan();
        newLoan.setLoanValue(loanApplyDTO.getLoanValue());
        newLoan.setPending(true);
        newLoan.setAuthorized(false);
        newLoan.setUuid(RandomStringUtils.randomAlphanumeric(8));
        return newLoan;
    }

}
