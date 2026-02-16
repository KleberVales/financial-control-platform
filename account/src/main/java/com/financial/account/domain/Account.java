package com.financial.account.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType type;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private UUID userId; // referência ao Identity Domain

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Account() {
        this.createdAt = LocalDateTime.now();
        this.balance = BigDecimal.ZERO;
    }

    public Account(String name, AccountType type, UUID userId) {
        this();
        this.name = name;
        this.type = type;
        this.userId = userId;
    }

    // Getters and Setters

    public UUID getId() { return id; }

    public String getName() { return name; }

    public AccountType getType() { return type; }

    public BigDecimal getBalance() { return balance; }

    public UUID getUserId() { return userId; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setName(String name) { this.name = name; }

    public void setType(AccountType type) { this.type = type; }

    public void setBalance(BigDecimal balance) { this.balance = balance; }
}
