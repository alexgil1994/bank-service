package com.markovits.bank.services;


import com.markovits.bank.domain.Client;
import com.markovits.bank.repositories.ClientRepository;
import com.markovits.bank.v1.model.ClientDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findClientById(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent())
            return optionalClient.get();
        else
            throw new RuntimeException("Client was not found");
    }

    @Override
    public Client register(ClientDTO clientDTO) {
        if (StringUtils.isNotEmpty(clientDTO.getFullName()) && StringUtils.isNotBlank(clientDTO.getFullName()) &&
        StringUtils.isNotEmpty(clientDTO.getNationality()) && StringUtils.isNotBlank(clientDTO.getNationality()) &&
        StringUtils.isNotEmpty(clientDTO.getGender()) && StringUtils.isNotBlank(clientDTO.getGender()) &&
        clientDTO.getBirth() != null && clientDTO.getAnnualIncome() != null){
            // Init new Client
            Client newClient = new Client();
            newClient.setFullName(clientDTO.getFullName());
            newClient.setNationality(clientDTO.getNationality());
            newClient.setAnnualIncome(clientDTO.getAnnualIncome());
            newClient.setBirth(clientDTO.getBirth());
            newClient.setGender(clientDTO.getGender());
            if (clientDTO.getAccountBalance() == null){
                clientDTO.setAccountBalance(BigDecimal.valueOf(0));
            }
            newClient.setAccountBalance(clientDTO.getAccountBalance());

            return clientRepository.save(newClient);
        } else throw new RuntimeException("Client registration failed because of empty parameters");
    }

}
