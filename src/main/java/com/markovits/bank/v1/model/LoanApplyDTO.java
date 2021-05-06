package com.markovits.bank.v1.model;

import java.math.BigDecimal;

public class LoanApplyDTO {

    private Long clientId;
    private BigDecimal loanValue;

    public LoanApplyDTO() {
    }

    public LoanApplyDTO(Long clientId, BigDecimal loanValue) {
        this.clientId = clientId;
        this.loanValue = loanValue;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getLoanValue() {
        return loanValue;
    }

    public void setLoanValue(BigDecimal loanValue) {
        this.loanValue = loanValue;
    }
}
