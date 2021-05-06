package com.markovits.bank.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "birth", nullable = false)
    private String birth;

    @Column(name = "accountBalance", nullable = false)
    private BigDecimal accountBalance;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "annualIncome", nullable = false)
    private BigDecimal annualIncome;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    @JsonIgnore
    private Set<Loan> loanSet = new HashSet<>();

    // Basic methods
    public void addLoan(Loan loan){
        loan.setClient(this);
        this.loanSet.add(loan);
    }

    public void removeLoan(Loan loan){
        loan.setClient(null);
        this.loanSet.remove(loan);
    }

    public Client() {
    }

    public Client(Long id, String fullName, String birth, BigDecimal accountBalance, String nationality, String gender, BigDecimal annualIncome, Set<Loan> loanSet) {
        this.id = id;
        this.fullName = fullName;
        this.birth = birth;
        this.accountBalance = accountBalance;
        this.nationality = nationality;
        this.gender = gender;
        this.annualIncome = annualIncome;
        this.loanSet = loanSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Loan> getLoanSet() {
        return loanSet;
    }

    public void setLoanSet(Set<Loan> loanSet) {
        this.loanSet = loanSet;
    }
}
