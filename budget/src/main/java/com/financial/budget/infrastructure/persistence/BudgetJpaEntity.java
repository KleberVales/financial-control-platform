package com.financial.budget.infrastructure.persistence;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "budgets")
@Getter
@Setter
public class BudgetJpaEntity {

    @Id
    private UUID id;

    private UUID accountId;
    private UUID categoryId;
    private String categoryName;
    private BigDecimal limitAmount;
    private BigDecimal spentAmount;
    private LocalDate startDate;
    private LocalDate endDate;

    // getters and setters
}

