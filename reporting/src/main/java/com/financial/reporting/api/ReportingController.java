package com.financial.reporting.api;


import com.financial.reporting.application.dto.MonthlyReportResponse;
import com.financial.reporting.application.dto.ReportRequest;
import com.financial.reporting.application.usecase.GenerateMonthlyReportUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportingController {

    private final GenerateMonthlyReportUseCase useCase;

    public ReportingController(GenerateMonthlyReportUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/monthly")
    public MonthlyReportResponse generateMonthlyReport(
            @RequestBody ReportRequest request) {

        return useCase.execute(request.getYearMonth());
    }
}

