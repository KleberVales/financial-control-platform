package com.financial.reporting.infrastructure.persistence;

import com.financial.reporting.domain.repository.ReportingRepository;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class ReportingRepositoryImpl implements ReportingRepository {

    @Override
    public BigDecimal sumIncomeByMonth(YearMonth month) {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal sumExpenseByMonth(YearMonth month) {
        return BigDecimal.ZERO;
    }

    @Override
    public Map<String, BigDecimal> sumExpensesByCategory(YearMonth month) {
        return new HashMap<>();
    }
}

