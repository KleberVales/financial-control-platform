package com.financial.budget.application.dto;

import com.financial.budget.application.dto.*;
import com.financial.budget.application.usecase.BudgetResponse;
import com.financial.budget.application.usecase.CreateBudgetRequest;
import com.financial.budget.domain.model.*;
import com.financial.budget.domain.model.valueobject.*;
import com.financial.budget.domain.repository.BudgetRepository;

import java.util.UUID;

public class CreateBudgetUseCase {

    private final BudgetRepository repository;

    public CreateBudgetUseCase(BudgetRepository repository) {
        this.repository = repository;
    }

    public BudgetResponse execute(CreateBudgetRequest request) {

        Budget budget = new Budget(
                UUID.randomUUID(),
                request.accountId(),
                new BudgetCategory(request.categoryId(), request.categoryName()),
                new Money(request.limit()),
                new Period(request.startDate(), request.endDate())
        );

        repository.save(budget);

        return new BudgetResponse(
                budget.getId(),
                budget.getLimit().getAmount(),
                budget.getSpent().getAmount(),
                budget.isLimitExceeded()
        );
    }
}

