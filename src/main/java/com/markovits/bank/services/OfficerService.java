package com.markovits.bank.services;

import com.markovits.bank.domain.Officer;
import com.markovits.bank.v1.model.OfficerDTO;
import org.springframework.stereotype.Service;

@Service
public interface OfficerService {

    Officer findOfficerById(Long id);

    Officer register(OfficerDTO officerDTO);

}
