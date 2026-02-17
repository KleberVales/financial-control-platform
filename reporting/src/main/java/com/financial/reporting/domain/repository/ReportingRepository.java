package com.financial.reporting.domain.repository;


import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Map;

public interface ReportingRepository {

    BigDecimal sumIncomeByMonth(YearMonth month);

    BigDecimal sumExpenseByMonth(YearMonth month);

    Map<String, BigDecimal> sumExpensesByCategory(YearMonth month);
}

