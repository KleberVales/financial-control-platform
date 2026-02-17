package com.financial.budget.api;


import com.financial.budget.application.dto.*;
import com.financial.budget.application.usecase.*;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private final CreateBudgetUseCase createUseCase;
    private final GetBudgetReportUseCase reportUseCase;

    public BudgetController(CreateBudgetUseCase createUseCase,
                            GetBudgetReportUseCase reportUseCase) {
        this.createUseCase = createUseCase;
        this.reportUseCase = reportUseCase;
    }

    @PostMapping
    public BudgetResponse create(@RequestBody CreateBudgetRequest request) {
        return createUseCase.execute(request);
    }

    @GetMapping("/{id}")
    public BudgetResponse get(@PathVariable UUID id) {
        return reportUseCase.execute(id);
    }
}

