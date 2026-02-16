package com.financial.account.controller;

import com.financial.account.domain.Account;
import com.financial.account.dto.AccountRequestDTO;
import com.financial.account.dto.AccountResponseDTO;
import com.financial.account.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public AccountResponseDTO create(@RequestBody AccountRequestDTO dto) {
        Account account = service.create(dto);

        return new AccountResponseDTO(
                account.getId(),
                account.getName(),
                account.getType(),
                account.getBalance(),
                account.getCreatedAt()
        );
    }

    @GetMapping("/user/{userId}")
    public List<AccountResponseDTO> findByUser(@PathVariable UUID userId) {
        return service.findByUser(userId)
                .stream()
                .map(account -> new AccountResponseDTO(
                        account.getId(),
                        account.getName(),
                        account.getType(),
                        account.getBalance(),
                        account.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }
}

