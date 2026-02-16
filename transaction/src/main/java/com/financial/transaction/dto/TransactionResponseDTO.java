package com.financial.transaction.dto;

import com.financial.transaction.domain.model.TransactionStatus;
import com.financial.transaction.domain.model.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionResponseDTO {

    private Long id;
    private String description;
    private BigDecimal amount;
    private TransactionType type;
    private TransactionStatus status;
    private Long accountId;
    private LocalDateTime createdAt;


}

