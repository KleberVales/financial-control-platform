package com.financial.transaction.dto;

import com.financial.transaction.domain.model.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionRequestDTO {

    private String description;
    private BigDecimal amount;
    private TransactionType type;
    private Long accountId;


}

