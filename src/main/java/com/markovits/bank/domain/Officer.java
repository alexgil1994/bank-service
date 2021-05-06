package com.markovits.bank.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Officer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "officer")
    @JsonIgnore
    private Set<Loan> loanSet = new HashSet<>();

    // Basic methods
    public void addLoan(Loan loan){
        loan.setOfficer(this);
        this.loanSet.add(loan);
    }

    public void removeLoan(Loan loan){
        loan.setOfficer(null);
        this.loanSet.remove(loan);
    }

    public Officer() {
    }

    public Officer(Long id, String fullName, Set<Loan> loanSet) {
        this.id = id;
        this.fullName = fullName;
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
}
