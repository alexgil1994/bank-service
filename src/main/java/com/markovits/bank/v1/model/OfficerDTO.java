package com.markovits.bank.v1.model;

public class OfficerDTO {

    private String fullName;

    public OfficerDTO() {
    }

    public OfficerDTO(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
