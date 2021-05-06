package com.markovits.bank.services;

import com.markovits.bank.domain.Officer;
import com.markovits.bank.repositories.OfficerRepository;
import com.markovits.bank.v1.model.OfficerDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class OfficerServiceImpl implements OfficerService {

    @Autowired
    private OfficerRepository officerRepository;

    // For Mockito Service testing
    public void setOfficerRepository(OfficerRepository officerRepository){
        this.officerRepository = officerRepository;
    }

    @Override
    public Officer findOfficerById(Long id) {
        Optional<Officer> optionalOfficer = officerRepository.findById(id);
        if (optionalOfficer.isPresent())
            return optionalOfficer.get();
        else
            throw new RuntimeException("Officer was not found with id of " + id + ".");
    }

    @Override
    public Officer register(OfficerDTO officerDTO) {
        if (StringUtils.isNotEmpty(officerDTO.getFullName()) && StringUtils.isNotBlank(officerDTO.getFullName())){
            // Init new Officer
            Officer newOfficer = new Officer();
            newOfficer.setFullName(officerDTO.getFullName());

            return officerRepository.save(newOfficer);
        } else throw new RuntimeException("Officer registration failed because of empty parameters");
    }

}
