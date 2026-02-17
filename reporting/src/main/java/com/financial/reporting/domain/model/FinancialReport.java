package com.financial.reporting.domain.model;


import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

public class FinancialReport {

    private YearMonth period;
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private List<CategoryReport> categoryReports;

    public FinancialReport(YearMonth period,
                           BigDecimal totalIncome,
                           BigDecimal totalExpense,
                           List<CategoryReport> categoryReports) {
        this.period = period;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.categoryReports = categoryReports;
    }

    public BigDecimal getBalance() {
        return totalIncome.subtract(totalExpense);
    }

    public YearMonth getPeriod() {
        return period;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public BigDecimal getTotalExpense() {
        return totalExpense;
    }

    public List<CategoryReport> getCategoryReports() {
        return categoryReports;
    }
}

