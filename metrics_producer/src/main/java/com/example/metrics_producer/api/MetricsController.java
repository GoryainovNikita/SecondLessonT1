package com.example.metrics_producer.api;

import com.example.metrics_producer.model.CustomMetrics;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class MetricsController {

    private final KafkaTemplate<String, CustomMetrics> kafkaTemplate;

    @GetMapping
    public CustomMetrics getMetric(){
        CustomMetrics customMetrics = new CustomMetrics();
        customMetrics.setHeapMemoryUsage(1);
        customMetrics.setThreadCount(2);
        return customMetrics;
    }

    @PostMapping("/metrics")
    public CustomMetrics getMetrics(@RequestBody CustomMetrics customMetrics){
        kafkaTemplate.send("metrics-topic",customMetrics);
        return customMetrics;
    }
}
