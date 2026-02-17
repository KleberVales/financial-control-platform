package com.financial.budget.application.usecase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CreateBudgetRequest(
        UUID accountId,
        UUID categoryId,
        String categoryName,
        BigDecimal limit,
        LocalDate startDate,
        LocalDate endDate
) {}

