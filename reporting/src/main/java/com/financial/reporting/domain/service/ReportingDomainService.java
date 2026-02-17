package com.financial.reporting.domain.service;

import com.financial.reporting.domain.model.CategoryReport;
import com.financial.reporting.domain.model.FinancialReport;
import com.financial.reporting.domain.repository.ReportingRepository;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportingDomainService {

    private final ReportingRepository repository;

    public ReportingDomainService(ReportingRepository repository) {
        this.repository = repository;
    }

    public FinancialReport generateMonthlyReport(YearMonth month) {

        BigDecimal income = repository.sumIncomeByMonth(month);
        BigDecimal expense = repository.sumExpenseByMonth(month);

        Map<String, BigDecimal> categoryMap =
                repository.sumExpensesByCategory(month);

        List<CategoryReport> categoryReports =
                categoryMap.entrySet().stream()
                        .map(e -> new CategoryReport(e.getKey(), e.getValue()))
                        .collect(Collectors.toList());

        return new FinancialReport(month, income, expense, categoryReports);
    }
}

