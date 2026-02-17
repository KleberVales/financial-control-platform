package com.financial.reporting.domain.model;

import java.math.BigDecimal;

public class CategoryReport {

    private String category;
    private BigDecimal total;

    public CategoryReport(String category, BigDecimal total) {
        this.category = category;
        this.total = total;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getTotal() {
        return total;
    }
}

