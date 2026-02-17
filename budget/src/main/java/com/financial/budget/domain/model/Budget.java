package com.financial.budget.domain.model;

import com.financial.budget.domain.model.valueobject.Money;
import com.financial.budget.domain.model.valueobject.Period;

import java.util.UUID;

public class Budget {

    private UUID id;
    private UUID accountId;
    private BudgetCategory category;
    private Money limit;
    private Money spent;
    private Period period;

    public Budget(UUID id, UUID accountId, BudgetCategory category,
                  Money limit, Period period) {

        this.id = id;
        this.accountId = accountId;
        this.category = category;
        this.limit = limit;
        this.spent = new Money(limit.getAmount().ZERO);
        this.period = period;
    }

    public void addExpense(Money expense) {
        this.spent = this.spent.add(expense);
    }

    public boolean isLimitExceeded() {
        return spent.isGreaterThan(limit);
    }

    public UUID getId() { return id; }
    public UUID getAccountId() { return accountId; }
    public Money getLimit() { return limit; }
    public Money getSpent() { return spent; }
    public Period getPeriod() { return period; }
}

