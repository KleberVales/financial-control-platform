package com.financial.account.dto;

import com.financial.account.domain.AccountType;

import java.util.UUID;

public class AccountRequestDTO {

    private String name;
    private AccountType type;
    private UUID userId;

    public String getName() { return name; }

    public AccountType getType() { return type; }

    public UUID getUserId() { return userId; }

    public void setName(String name) { this.name = name; }

    public void setType(AccountType type) { this.type = type; }

    public void setUserId(UUID userId) { this.userId = userId; }
}

