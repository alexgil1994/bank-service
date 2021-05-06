package com.markovits.bank.repositories;

import com.markovits.bank.BankApplication;
import com.markovits.bank.domain.Client;
import com.markovits.bank.v1.model.ClientDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BankApplication.class)
@TestPropertySource(locations = "classpath:application-it.properties")
@RunWith(SpringRunner.class)
public class ClientRepositoryIT {

    @Autowired
    ClientRepository clientRepository;

    private Client client;

    @Before
    public void setUp(){
        // Init Client
        client = new Client();
        client.setFullName("Test Fullname");
        client.setAccountBalance(BigDecimal.valueOf(0));
        client.setAnnualIncome(BigDecimal.valueOf(10000));
        client.setBirth("1994-12-12");
        client.setGender("Male");
        client.setNationality("Japanese");
    }

    @Test
    public void findByIdTest(){
        // Check by deletion for any previously stored data
        clientRepository.deleteAll();

        // Save Client
        Optional<Client> optionalClient = clientRepository.findById(clientRepository.save(client).getId());

        if (optionalClient.isPresent()){
            // Clean up
            clientRepository.deleteAll();

            // Check
            assertNotNull(optionalClient.get());
            assertEquals(optionalClient.get().getFullName(), client.getFullName());
            assertEquals(optionalClient.get().getAccountBalance(), client.getAccountBalance());
            assertEquals(optionalClient.get().getAnnualIncome(), client.getAnnualIncome());
            assertEquals(optionalClient.get().getBirth(), client.getBirth());
            assertEquals(optionalClient.get().getGender(), client.getGender());
            assertEquals(optionalClient.get().getNationality(), client.getNationality());
        }else {
            fail();
        }
    }

}
