package com.example.metrics_consumer.service;


import com.example.metrics_consumer.model.CustomMetrics;
import com.example.metrics_consumer.model.CustomMetricsDTO;

public class MapperDTO {

    public static CustomMetricsDTO toDto(CustomMetrics customMetrics){
        CustomMetricsDTO customMetricsDTO = new CustomMetricsDTO();
        customMetricsDTO.setHeapMemoryUsage(customMetrics.getHeapMemoryUsage());
        customMetricsDTO.setThreadCount(customMetrics.getThreadCount());
        return customMetricsDTO;
    }

    public static CustomMetrics to(CustomMetricsDTO customMetricsDTO){
        CustomMetrics customMetrics = new CustomMetrics();
        customMetrics.setHeapMemoryUsage(customMetricsDTO.getHeapMemoryUsage());
        customMetrics.setThreadCount(customMetricsDTO.getThreadCount());
        return customMetrics;
    }
}
