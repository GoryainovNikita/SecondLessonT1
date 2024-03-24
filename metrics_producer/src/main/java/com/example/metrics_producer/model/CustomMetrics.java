package com.example.metrics_producer.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomMetrics {

    private int heapMemoryUsage;
    private int threadCount;

}
