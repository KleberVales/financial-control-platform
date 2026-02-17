package com.financial.reporting.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataReportingRepository
        extends JpaRepository<ReportingJpaEntity, Long> {
}

