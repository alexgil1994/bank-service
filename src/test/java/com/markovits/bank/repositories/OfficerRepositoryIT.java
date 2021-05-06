package com.markovits.bank.repositories;

import com.markovits.bank.BankApplication;
import com.markovits.bank.domain.Client;
import com.markovits.bank.domain.Officer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.*;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BankApplication.class)
@TestPropertySource(locations = "classpath:application-it.properties")
@RunWith(SpringRunner.class)
public class OfficerRepositoryIT {

    @Autowired
    OfficerRepository officerRepository;

    private Officer officer;

    @Before
    public void setUp(){
        // Init Officer
        officer = new Officer();
        officer.setFullName("Test Fullname");
    }

    @Test
    public void findByIdTest(){
        // Check by deletion for any previously stored data
        officerRepository.deleteAll();

        // Save Client
        Optional<Officer> optionalOfficer = officerRepository.findById(officerRepository.save(officer).getId());

        if (optionalOfficer.isPresent()){
            // Clean up
            officerRepository.deleteAll();

            // Check
            assertNotNull(optionalOfficer.get());
            assertEquals(optionalOfficer.get().getFullName(), officer.getFullName());
        }else {
            fail();
        }
    }

}
