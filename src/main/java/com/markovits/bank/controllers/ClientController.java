package com.markovits.bank.controllers;

import com.markovits.bank.domain.Client;
import com.markovits.bank.services.ClientServiceImpl;
import com.markovits.bank.v1.model.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(ClientController.BASE_URL)
public class ClientController {

    public static final String BASE_URL = "v1/client";

    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Client register(@RequestBody ClientDTO clientDTO) throws ParseException {
        return clientServiceImpl.register(clientDTO);
    }

}
