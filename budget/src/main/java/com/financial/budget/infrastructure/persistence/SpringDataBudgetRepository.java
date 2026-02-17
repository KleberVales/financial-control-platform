package com.financial.budget.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SpringDataBudgetRepository
        extends JpaRepository<BudgetJpaEntity, UUID> {
}

