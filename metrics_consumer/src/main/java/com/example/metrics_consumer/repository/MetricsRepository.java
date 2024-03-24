package com.example.metrics_consumer.repository;

import com.example.metrics_consumer.model.CustomMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricsRepository extends JpaRepository<CustomMetrics, Long> {
}
