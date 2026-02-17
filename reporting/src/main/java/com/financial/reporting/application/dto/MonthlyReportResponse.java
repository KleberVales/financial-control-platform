package com.financial.reporting.application.dto;

import java.math.BigDecimal;

public class MonthlyReportResponse {

    private String period;
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private BigDecimal balance;

    public MonthlyReportResponse(String period,
                                 BigDecimal totalIncome,
                                 BigDecimal totalExpense,
                                 BigDecimal balance) {
        this.period = period;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = balance;
    }

    public String getPeriod() {
        return period;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public BigDecimal getTotalExpense() {
        return totalExpense;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}

