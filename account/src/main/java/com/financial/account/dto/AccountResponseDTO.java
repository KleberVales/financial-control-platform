package com.financial.account.dto;

import com.financial.account.domain.AccountType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class AccountResponseDTO {

    private UUID id;
    private String name;
    private AccountType type;
    private BigDecimal balance;
    private LocalDateTime createdAt;

    public AccountResponseDTO(UUID id, String name, AccountType type,
                              BigDecimal balance, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }

    public String getName() { return name; }

    public AccountType getType() { return type; }

    public BigDecimal getBalance() { return balance; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}

