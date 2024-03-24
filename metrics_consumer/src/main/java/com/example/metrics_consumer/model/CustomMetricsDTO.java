package com.example.metrics_consumer.model;


import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomMetricsDTO implements Serializable {
    private Integer heapMemoryUsage;
    private Integer threadCount;
}
