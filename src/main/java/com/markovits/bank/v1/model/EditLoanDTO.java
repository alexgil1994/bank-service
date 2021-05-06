package com.markovits.bank.v1.model;

import java.math.BigDecimal;

public class EditLoanDTO {

    private String loanUuid;

    private Long officerId;

    private Boolean pending;

    private Boolean authorized;

    private BigDecimal loanValue;

    public EditLoanDTO() {
    }

    public EditLoanDTO(String loanUuid, Long officerId, Boolean pending, Boolean authorized, BigDecimal loanValue) {
        this.loanUuid = loanUuid;
        this.officerId = officerId;
        this.pending = pending;
        this.authorized = authorized;
        this.loanValue = loanValue;
    }

    public String getLoanUuid() {
        return loanUuid;
    }

    public void setLoanUuid(String loanUuid) {
        this.loanUuid = loanUuid;
    }

    public Long getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Long officerId) {
        this.officerId = officerId;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

    public BigDecimal getLoanValue() {
        return loanValue;
    }

    public void setLoanValue(BigDecimal loanValue) {
        this.loanValue = loanValue;
    }
}
