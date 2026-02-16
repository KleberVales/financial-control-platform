package com.financial.transaction.controller;

import com.financial.transaction.dto.TransactionRequestDTO;
import com.financial.transaction.dto.TransactionResponseDTO;
import com.financial.transaction.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> create(
            @RequestBody TransactionRequestDTO request) {

        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<TransactionResponseDTO>> findByAccount(
            @PathVariable Long accountId) {

        return ResponseEntity.ok(service.findByAccount(accountId));
    }
}

