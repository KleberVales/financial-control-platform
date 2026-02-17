package com.financial.budget.domain.repository;


import com.financial.budget.domain.model.Budget;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BudgetRepository {

    Budget save(Budget budget);

    Optional<Budget> findById(UUID id);
}

