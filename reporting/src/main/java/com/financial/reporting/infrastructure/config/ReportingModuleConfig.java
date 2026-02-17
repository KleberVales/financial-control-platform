package com.financial.reporting.infrastructure.config;


import com.financial.reporting.application.usecase.GenerateMonthlyReportUseCase;
import com.financial.reporting.domain.service.ReportingDomainService;
import com.financial.reporting.infrastructure.persistence.ReportingRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReportingModuleConfig {

    @Bean
    public ReportingRepositoryImpl reportingRepository() {
        return new ReportingRepositoryImpl();
    }

    @Bean
    public ReportingDomainService reportingDomainService() {
        return new ReportingDomainService(reportingRepository());
    }

    @Bean
    public GenerateMonthlyReportUseCase generateMonthlyReportUseCase() {
        return new GenerateMonthlyReportUseCase(reportingDomainService());
    }
}

