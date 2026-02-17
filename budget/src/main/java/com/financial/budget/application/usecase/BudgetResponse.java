package com.financial.budget.application.usecase;

import java.math.BigDecimal;
import java.util.UUID;

public record BudgetResponse(
        UUID id,
        BigDecimal limit,
        BigDecimal spent,
        boolean exceeded
) {}

