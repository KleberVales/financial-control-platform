package com.financial.budget.domain.model;


import java.util.UUID;

public class BudgetCategory {

    private UUID id;
    private String name;

    public BudgetCategory(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

