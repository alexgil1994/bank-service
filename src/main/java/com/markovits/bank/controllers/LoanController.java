package com.markovits.bank.controllers;

import com.markovits.bank.domain.Loan;
import com.markovits.bank.services.LoanServiceImpl;
import com.markovits.bank.v1.model.LoanApplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(LoanController.BASE_URL)
public class LoanController {

    public static final String BASE_URL = "v1/loan";

    @Autowired
    private LoanServiceImpl loanServiceImpl;

    @PostMapping("/loanApply")
    @ResponseStatus(HttpStatus.CREATED)
    public Loan loanApply(@RequestBody LoanApplyDTO loanApplyDTO){
        return loanServiceImpl.loanApply(loanApplyDTO);
    }

}
