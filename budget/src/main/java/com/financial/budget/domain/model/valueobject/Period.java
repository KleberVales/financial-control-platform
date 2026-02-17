package com.financial.budget.domain.model.valueobject;

import java.time.LocalDate;

public record Period(LocalDate startDate, LocalDate endDate) {

    public Period {
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }
    }
}

