package com.markovits.bank.services;

import com.markovits.bank.domain.Client;
import com.markovits.bank.v1.model.ClientDTO;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    Client findClientById(Long id);

    Client register(ClientDTO clientDTO);


}
