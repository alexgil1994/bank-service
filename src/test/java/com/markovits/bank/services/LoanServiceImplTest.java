package com.markovits.bank.services;

import com.markovits.bank.domain.Client;
import com.markovits.bank.domain.Loan;
import com.markovits.bank.repositories.ClientRepository;
import com.markovits.bank.repositories.LoanRepository;
import com.markovits.bank.repositories.OfficerRepository;
import com.markovits.bank.v1.model.ClientDTO;
import com.markovits.bank.v1.model.LoanApplyDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanServiceImplTest {

    @Autowired
    private LoanServiceImpl loanService;

    @Mock
    private LoanRepository loanRepository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private OfficerRepository officerRepository;

    private Loan loan;

    private Set<Loan> loanSet;

    private LoanApplyDTO loanApplyDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        loanService = new LoanServiceImpl();
        loanService.setLoanRepository(loanRepository, clientRepository, officerRepository);

        // Init Officer
        loan = new Loan();
        loan.setId(1L);
        loan.setLoanValue(BigDecimal.valueOf(1000));
        loan.setPending(true);
        loan.setAuthorized(false);
        loan.setUuid("RandomUuid");

        loanSet = new HashSet<>();
        loanSet.add(loan);

        // Init DTO
        loanApplyDTO = new LoanApplyDTO();
        loanApplyDTO.setLoanValue(BigDecimal.valueOf(1000));
    }

    @Test
    void findByIdTest(){
        Mockito.when(loanRepository.findById(loan.getId())).thenReturn(Optional.of(loan));

        Loan returnedLoan = loanService.findLoanById(loan.getId());

        assertEquals(loan.getId(), returnedLoan.getId());
        assertEquals(loan.getUuid(), returnedLoan.getUuid());
        Mockito.verify(loanRepository, Mockito.times(1)).findById(loan.getId());
    }

    @Test
    void findByUuidTest(){
        Mockito.when(loanRepository.findByUuid(loan.getUuid())).thenReturn(Optional.of(loan));

        Loan returnedLoan = loanService.findLoanByUuid(loan.getUuid());

        assertEquals(loan.getId(), returnedLoan.getId());
        assertEquals(loan.getUuid(), returnedLoan.getUuid());
        Mockito.verify(loanRepository, Mockito.times(1)).findByUuid(loan.getUuid());
    }

    @Test
    void getAllPendingLoans(){
        Mockito.when(loanRepository.findAllLoanListWherePendingEqualsTrueOrderByIdDesc()).thenReturn(loanSet);

        Set<Loan> returnedLoanSet = loanService.getAllPendingLoans();

        assertEquals(loanSet.contains(loan), returnedLoanSet.contains(loan));
        assertEquals(loanSet.size(), 1);
        Mockito.verify(loanRepository, Mockito.times(1)).findAllLoanListWherePendingEqualsTrueOrderByIdDesc();
    }

    // TODO: 5/6/2021 The rest in order to work they need time to either implement Mappers or pass the needed parameters from dtos instead of full dots (in the main method)


}
