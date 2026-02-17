package com.financial.budget.service;

import com.financial.budget.domain.model.Budget;

public class BudgetDomainService {

    public boolean checkIfExceeded(Budget budget) {
        return budget.isLimitExceeded();
    }
}

