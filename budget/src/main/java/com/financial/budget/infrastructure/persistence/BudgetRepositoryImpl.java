package com.financial.budget.infrastructure.persistence;


import com.financial.budget.domain.model.*;
import com.financial.budget.domain.model.valueobject.*;
import com.financial.budget.domain.repository.BudgetRepository;

import java.util.Optional;
import java.util.UUID;

public class BudgetRepositoryImpl implements BudgetRepository {

    private final SpringDataBudgetRepository jpaRepository;

    public BudgetRepositoryImpl(SpringDataBudgetRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Budget save(Budget budget) {
        return budget;
    }

    @Override
    public Optional<Budget> findById(UUID id) {
        return Optional.empty();
    }
}

