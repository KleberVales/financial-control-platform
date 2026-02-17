package com.financial.budget.application.dto;

import com.financial.budget.application.usecase.BudgetResponse;
import com.financial.budget.domain.repository.BudgetRepository;

import java.util.UUID;

public class GetBudgetReportUseCase {

    private final BudgetRepository repository;

    public GetBudgetReportUseCase(BudgetRepository repository) {
        this.repository = repository;
    }

    public BudgetResponse execute(UUID id) {

        var budget = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found"));

        return new BudgetResponse(
                budget.getId(),
                budget.getLimit().getAmount(),
                budget.getSpent().getAmount(),
                budget.isLimitExceeded()
        );
    }
}

