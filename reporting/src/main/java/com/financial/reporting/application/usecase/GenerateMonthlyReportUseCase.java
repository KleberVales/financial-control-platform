package com.financial.reporting.application.usecase;

import com.financial.reporting.application.dto.MonthlyReportResponse;
import com.financial.reporting.domain.model.FinancialReport;
import com.financial.reporting.domain.service.ReportingDomainService;

import java.time.YearMonth;

public class GenerateMonthlyReportUseCase {

    private final ReportingDomainService service;

    public GenerateMonthlyReportUseCase(ReportingDomainService service) {
        this.service = service;
    }

    public MonthlyReportResponse execute(String yearMonth) {

        YearMonth month = YearMonth.parse(yearMonth);
        FinancialReport report = service.generateMonthlyReport(month);

        return new MonthlyReportResponse(
                report.getPeriod().toString(),
                report.getTotalIncome(),
                report.getTotalExpense(),
                report.getBalance()
        );
    }
}

