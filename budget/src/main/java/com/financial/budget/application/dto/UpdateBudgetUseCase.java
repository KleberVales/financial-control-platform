package com.financial.budget.application.dto;

import com.financial.budget.domain.repository.BudgetRepository;

import java.util.UUID;

public class UpdateBudgetUseCase {

    private final BudgetRepository repository;

    public UpdateBudgetUseCase(BudgetRepository repository) {
        this.repository = repository;
    }

    public void execute(UUID budgetId) {
        var budget = repository.findById(budgetId)
                .orElseThrow(() -> new RuntimeException("Budget not found"));

        repository.save(budget);
    }
}

