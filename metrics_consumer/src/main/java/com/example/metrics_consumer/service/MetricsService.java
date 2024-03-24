package com.example.metrics_consumer.service;

import com.example.metrics_consumer.model.CustomMetrics;
import com.example.metrics_consumer.model.CustomMetricsDTO;
import com.example.metrics_consumer.repository.MetricsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MetricsService {

    private final MetricsRepository metricsRepository;

    @KafkaListener(id = "metricsGroup", topics = "metrics-topic")
    public void metrics(CustomMetricsDTO customMetricsDTO){
        CustomMetrics customMetrics = MapperDTO.to(customMetricsDTO);
        saveMetrics(customMetrics);
    }

    public CustomMetrics saveMetrics(CustomMetrics customMetrics){
        return metricsRepository.save(customMetrics);
    }

    public List<CustomMetrics> getAll(){
        return metricsRepository.findAll();
    }

    public CustomMetrics getById(Long id){
        Optional<CustomMetrics> byId = metricsRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        throw new RuntimeException("Metrics not found for id : " + id);
    }
}
