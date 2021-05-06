package com.markovits.bank.services;

import com.markovits.bank.domain.Client;
import com.markovits.bank.repositories.ClientRepository;
import com.markovits.bank.v1.model.ClientDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientServiceImplTest {

    @Autowired
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    private Client client;

    private ClientDTO clientDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clientService = new ClientServiceImpl();
        clientService.setClientRepository(clientRepository);

        // Init Officer
        client = new Client();
        client.setId(1L);
        client.setFullName("Spuros Papadopoulous");

        // Init DTO
        clientDTO = new ClientDTO();
        clientDTO.setFullName("Test Fullname");
        clientDTO.setAccountBalance(BigDecimal.valueOf(0));
        clientDTO.setAnnualIncome(BigDecimal.valueOf(10000));
        clientDTO.setBirth("1994-12-12");
        clientDTO.setGender("Male");
        clientDTO.setNationality("Japanese");
    }

    @Test
    void findByIdTest(){
        Mockito.when(clientRepository.findById(client.getId())).thenReturn(Optional.of(client));

        Client returnedClient = clientService.findClientById(client.getId());

        assertEquals(client.getFullName(), returnedClient.getFullName());
        assertEquals(client.getId(),returnedClient.getId());
        Mockito.verify(clientRepository, Mockito.times(1)).findById(client.getId());
    }

    // TODO: 5/6/2021 It can work but needs time to either implement Mappers or pass the needed parameters from dtos instead of full dots (in the main method)
//    @Test
//    void registerClientTest() throws ParseException {
//        Mockito.when(clientRepository.save(client)).thenReturn(client);
//
//        Client returnedClient = clientService.register(clientDTO);
//
//        Mockito.verify(clientRepository, Mockito.times(1)).save(client);
//    }
}
