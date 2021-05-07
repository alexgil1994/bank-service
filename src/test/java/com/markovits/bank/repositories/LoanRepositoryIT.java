package com.markovits.bank.repositories;

import com.markovits.bank.BankApplication;
import com.markovits.bank.domain.Client;
import com.markovits.bank.domain.Loan;
import com.markovits.bank.domain.Officer;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BankApplication.class)
@TestPropertySource(locations = "classpath:application-it.properties")
@RunWith(SpringRunner.class)
public class LoanRepositoryIT {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    ClientRepository clientRepository;

    private Client client;

    private Loan loan;
    private Loan loan1;
    private Loan loan2;

    private Set<Loan> loanSet;

    @Before
    public void setUp(){
        // Init Loan
        loan = new Loan();
        loan.setAuthorized(false);
        loan.setUuid(RandomStringUtils.randomAlphanumeric(8));
        loan.setPending(true);
        loan.setLoanValue(BigDecimal.valueOf(12000));

        loan1 = new Loan();
        loan1.setAuthorized(true);
        loan1.setUuid(RandomStringUtils.randomAlphanumeric(8));
        loan1.setPending(false);
        loan1.setLoanValue(BigDecimal.valueOf(15000));

        loan2 = new Loan();
        loan2.setAuthorized(false);
        loan2.setUuid(RandomStringUtils.randomAlphanumeric(8));
        loan2.setPending(true);
        loan2.setLoanValue(BigDecimal.valueOf(8000));

        // Set of pending loans
        loanSet = new HashSet<>();
        loanSet.add(loan);
        loanSet.add(loan2);

        // Init Client if needed
        client = new Client();
        client.setFullName("Test Fullname");
        client.setAccountBalance(BigDecimal.valueOf(0));
        client.setAnnualIncome(BigDecimal.valueOf(10000));
        client.setBirth("1994-12-12");
        client.setGender("Male");
        client.setNationality("Japanese");
        client.addLoan(loan);
        client.addLoan(loan1);
        client.addLoan(loan2);
    }

    // TODO: 5/6/2021 Fix, some problem with the uuid being null but no time was left
    @Test
    public void findByIdTest(){
        // Check by deletion for any previously stored data
        loanRepository.deleteAll();
        loanRepository.deleteAll();
        clientRepository.deleteAll();
        clientRepository.deleteAll();

        // Save Client first
        Client returnedClient = clientRepository.save(client);

        // Save Loan
        Optional<Loan> optionalLoan = loanRepository.findById(loanRepository.save(loan).getId());

        if (optionalLoan.isPresent()){
            // Clean up
            loanRepository.deleteAll();
            clientRepository.deleteAll();

            // Check
            assertNotNull(returnedClient);
            assertNotNull(optionalLoan.get());
            assertEquals(optionalLoan.get().getUuid(), loan.getUuid());
        }else {
            fail();
        }
    }

    @Test
    public void findByUuidTest(){
        // Check by deletion for any previously stored data
        loanRepository.deleteAll();
        loanRepository.deleteAll();
        clientRepository.deleteAll();
        clientRepository.deleteAll();

        // Save Client first
        Client returnedClient = clientRepository.save(client);

        // Save Loan
        Optional<Loan> optionalLoan = loanRepository.findByUuid(loanRepository.save(loan).getUuid());

        if (optionalLoan.isPresent()){
            // Clean up
            loanRepository.deleteAll();
            clientRepository.deleteAll();

            // Check
            assertNotNull(returnedClient);
            assertNotNull(optionalLoan.get());
            assertEquals(optionalLoan.get().getUuid(), loan.getUuid());
        }else {
            fail();
        }
    }

    @Test
    public void findAllLoanListWherePendingEqualsTrueOrderByIdDescTest(){
        // Check by deletion for any previously stored data
        loanRepository.deleteAll();
        loanRepository.deleteAll();
        clientRepository.deleteAll();
        clientRepository.deleteAll();

        // Save Client first || Through the Client the Loans are being saved because of cascading
        Client returnedClient = clientRepository.save(client);

        Set<Loan> returnedLoanSet = loanRepository.findAllLoanListWherePendingEqualsTrueOrderByIdDesc();

        // Clean up
        loanRepository.deleteAll();
        clientRepository.deleteAll();

        // Check
        assertEquals(returnedLoanSet.size(), loanSet.size());
    }


}
