package com.markovits.bank.controllers;

import com.markovits.bank.domain.Officer;
import com.markovits.bank.services.OfficerServiceImpl;
import com.markovits.bank.v1.model.OfficerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OfficerController.BASE_URL)
public class OfficerController {

    public static final String BASE_URL = "v1/officer";

    @Autowired
    private OfficerServiceImpl officerServiceImpl;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Officer register(@RequestBody OfficerDTO officerDTO){
        return officerServiceImpl.register(officerDTO);
    }

}
