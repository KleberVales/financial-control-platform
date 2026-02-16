package com.financial.account.service;

import com.financial.account.domain.Account;
import com.financial.account.dto.AccountRequestDTO;
import com.financial.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account create(AccountRequestDTO dto) {
        Account account = new Account(
                dto.getName(),
                dto.getType(),
                dto.getUserId()
        );

        return repository.save(account);
    }

    public List<Account> findByUser(UUID userId) {
        return repository.findByUserId(userId);
    }

    public Account findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}

