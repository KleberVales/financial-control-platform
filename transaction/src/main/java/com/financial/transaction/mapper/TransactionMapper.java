package com.financial.transaction.mapper;

import com.financial.transaction.domain.model.Transaction;
import com.financial.transaction.dto.TransactionRequestDTO;
import com.financial.transaction.dto.TransactionResponseDTO;

public class TransactionMapper {

    public static Transaction toEntity(TransactionRequestDTO dto) {
        return new Transaction(
                dto.getDescription(),
                dto.getAmount(),
                dto.getType(),
                dto.getAccountId()
        );
    }

    public static TransactionResponseDTO toResponse(Transaction transaction) {
        TransactionResponseDTO dto = new TransactionResponseDTO();
        dto.setId(transaction.getId());
        dto.setDescription(transaction.getDescription());
        dto.setAmount(transaction.getAmount());
        dto.setType(transaction.getType());
        dto.setStatus(transaction.getStatus());
        dto.setAccountId(transaction.getAccountId());
        dto.setCreatedAt(transaction.getCreatedAt());
        return dto;
    }
}

