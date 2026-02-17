package com.financial.reporting.infrastructure.persistence;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.YearMonth;

@Entity
@Table(name = "transactions")
public class ReportingJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // INCOME or EXPENSE
    private String category;
    private BigDecimal amount;
    private String yearMonth;
}

