package com.financial.transaction.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private Long accountId;

    private LocalDateTime createdAt;

    public Transaction() {}

    public Transaction(String description, BigDecimal amount, TransactionType type, Long accountId) {
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.status = TransactionStatus.PENDING;
        this.accountId = accountId;
        this.createdAt = LocalDateTime.now();
    }

    public void complete() {
        this.status = TransactionStatus.COMPLETED;
    }

    public void cancel() {
        this.status = TransactionStatus.CANCELED;
    }


}

