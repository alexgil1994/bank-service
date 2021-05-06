package com.markovits.bank.services;

import com.markovits.bank.domain.Client;
import com.markovits.bank.v1.model.ClientDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface ClientService {

    Client findClientById(Long id);

    Client register(ClientDTO clientDTO) throws ParseException;


}
