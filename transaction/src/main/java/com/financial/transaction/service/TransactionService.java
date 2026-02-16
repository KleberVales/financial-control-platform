package com.financial.transaction.service;

import com.financial.transaction.domain.model.Transaction;
import com.financial.transaction.domain.repository.TransactionRepository;
import com.financial.transaction.dto.TransactionRequestDTO;
import com.financial.transaction.dto.TransactionResponseDTO;
import com.financial.transaction.exception.TransactionException;
import com.financial.transaction.mapper.TransactionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public TransactionResponseDTO create(TransactionRequestDTO request) {

        if (request.getAmount().signum() <= 0) {
            throw new TransactionException("Amount must be greater than zero");
        }

        Transaction transaction = TransactionMapper.toEntity(request);
        transaction.complete();

        Transaction saved = repository.save(transaction);

        return TransactionMapper.toResponse(saved);
    }

    public List<TransactionResponseDTO> findByAccount(Long accountId) {
        return repository.findByAccountId(accountId)
                .stream()
                .map(TransactionMapper::toResponse)
                .collect(Collectors.toList());
    }
}

