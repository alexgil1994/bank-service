package com.markovits.bank.services;

import com.markovits.bank.domain.Officer;
import com.markovits.bank.repositories.OfficerRepository;
import com.markovits.bank.v1.model.OfficerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OfficerServiceImplTest {

    private OfficerServiceImpl officerService;

    @Mock
    private OfficerRepository officerRepository;

    private Officer officer;

    private OfficerDTO officerDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        officerService = new OfficerServiceImpl();
        officerService.setOfficerRepository(officerRepository);

        // Init Officer
        officer = new Officer();
        officer.setId(1L);
        officer.setFullName("Spuros Papadopoulous");

        // Init DTO
        officerDTO = new OfficerDTO();
        officerDTO.setFullName("Test Fullname");
    }

    @Test
    void findByIdTest(){
        Mockito.when(officerRepository.findById(officer.getId())).thenReturn(Optional.of(officer));

        Officer returnedOfficer = officerService.findOfficerById(officer.getId());

        assertEquals(officer.getFullName(), returnedOfficer.getFullName());
        assertEquals(officer.getId(),returnedOfficer.getId());
        Mockito.verify(officerRepository, Mockito.times(1)).findById(officer.getId());
    }

    // TODO: 5/6/2021 It can work but needs time to either implement Mappers or pass the needed parameters from dtos instead of full dots (in the main method)
//    @Test
//    void registerOfficerTest(){
//        Mockito.when(officerRepository.save(officer)).thenReturn(officer);
//
//        Officer returnedOfficer = officerService.register(officerDTO);
//
//        Mockito.verify(officerRepository, Mockito.times(1)).save(officer);
//    }

}
