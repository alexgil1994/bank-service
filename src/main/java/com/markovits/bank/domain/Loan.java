package com.markovits.bank.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "uuid", nullable = false, unique = true)
    private String uuid;

    @Column(name = "pending", nullable = false)
    private Boolean pending;

    @Column(name = "authorized")
    private Boolean authorized;

    @Column(name = "loanValue", nullable = false)
    private BigDecimal loanValue;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private Officer officer;

    public Loan() {
    }

    public Loan(Long id, String uuid, Boolean pending, Boolean authorized, BigDecimal loanValue, Client client, Officer officer) {
        this.id = id;
        this.uuid = uuid;
        this.pending = pending;
        this.authorized = authorized;
        this.loanValue = loanValue;
        this.client = client;
        this.officer = officer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }
}
