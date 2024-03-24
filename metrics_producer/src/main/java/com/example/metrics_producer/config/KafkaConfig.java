package com.example.metrics_producer.config;

import com.example.metrics_producer.model.CustomMetrics;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.mapping.Jackson2JavaTypeMapper;


import java.util.HashMap;
import java.util.Map;


@Configuration
@Slf4j
public class KafkaConfig {

    @Bean
    public NewTopic order() {
        return new NewTopic("metrics", 1, (short) 1);
    }

    @Bean
    public NewTopic dlt() {
        return new NewTopic("metrics-topic.DLT", 1, (short) 1);
    }

    @Bean
    public RecordMessageConverter converter() {
        JsonMessageConverter messageConverter = new JsonMessageConverter();
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        typeMapper.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID);
        typeMapper.addTrustedPackages("com.example.second_lesson.model");
        Map<String, Class<?>> mapping = new HashMap<>();
        mapping.put("metrics", CustomMetrics.class);
        typeMapper.setIdClassMapping(mapping);
        messageConverter.setTypeMapper(typeMapper);
        return messageConverter;

    }


}
