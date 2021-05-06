package com.markovits.bank.v1.model;

import java.math.BigDecimal;

public class ClientDTO {

    private String fullName;

    private String birth;

    private BigDecimal accountBalance;

    private String nationality;

    private String gender;

    private BigDecimal annualIncome;


    public ClientDTO() {
    }

    public ClientDTO(String fullName, String birth, BigDecimal accountBalance, String nationality, String gender, BigDecimal annualIncome) {
        this.fullName = fullName;
        this.birth = birth;
        this.accountBalance = accountBalance;
        this.nationality = nationality;
        this.gender = gender;
        this.annualIncome = annualIncome;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }
}
