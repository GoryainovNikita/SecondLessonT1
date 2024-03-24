package com.example.metrics_consumer.api;

import com.example.metrics_consumer.model.CustomMetrics;
import com.example.metrics_consumer.model.CustomMetricsDTO;
import com.example.metrics_consumer.service.MapperDTO;
import com.example.metrics_consumer.service.MetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consumer")
@RequiredArgsConstructor
public class MetricsController {

    private final MetricsService metricsService;


    @GetMapping("/metrics")
    public List<CustomMetricsDTO> getAll(){
        List<CustomMetrics> all = metricsService.getAll();
        List<CustomMetricsDTO> customMetricsDTOS = new ArrayList<>();
        for(var elem : all){
            CustomMetricsDTO dto = MapperDTO.toDto(elem);
            customMetricsDTOS.add(dto);
        }
        return customMetricsDTOS;
    }


    @GetMapping("/metrics/{id}")
    public CustomMetricsDTO getById(@PathVariable Long id){
        CustomMetrics byId = metricsService.getById(id);
        return MapperDTO.toDto(byId);
    }



}
