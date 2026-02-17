package com.financial.reporting.domain.model;

import java.math.BigDecimal;

public class ExpenseSummary {

    private BigDecimal total;

    public ExpenseSummary(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
