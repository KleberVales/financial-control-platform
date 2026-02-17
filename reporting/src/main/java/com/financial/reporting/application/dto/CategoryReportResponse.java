package com.financial.reporting.application.dto;

import java.math.BigDecimal;

public class CategoryReportResponse {

    private String category;
    private BigDecimal total;

    public CategoryReportResponse(String category, BigDecimal total) {
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

