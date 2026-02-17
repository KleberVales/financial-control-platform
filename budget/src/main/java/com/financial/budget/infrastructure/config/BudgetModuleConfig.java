package com.financial.budget.infrastructure.config;

import com.financial.budget.application.dto.CreateBudgetUseCase;
import com.financial.budget.application.dto.GetBudgetReportUseCase;
import com.financial.budget.application.dto.UpdateBudgetUseCase;
import com.financial.budget.domain.repository.BudgetRepository;
import com.financial.budget.infrastructure.persistence.BudgetRepositoryImpl;
import com.financial.budget.infrastructure.persistence.SpringDataBudgetRepository;
import com.financial.budget.application.usecase.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BudgetModuleConfig {

    @Bean
    public BudgetRepository budgetRepository(
            SpringDataBudgetRepository jpaRepository) {

        return new BudgetRepositoryImpl(jpaRepository);
    }

    @Bean
    public CreateBudgetUseCase createBudgetUseCase(BudgetRepository repository) {
        return new CreateBudgetUseCase(repository);
    }

    @Bean
    public UpdateBudgetUseCase updateBudgetUseCase(BudgetRepository repository) {
        return new UpdateBudgetUseCase(repository);
    }

    @Bean
    public GetBudgetReportUseCase getBudgetReportUseCase(BudgetRepository repository) {
        return new GetBudgetReportUseCase(repository);
    }
}
