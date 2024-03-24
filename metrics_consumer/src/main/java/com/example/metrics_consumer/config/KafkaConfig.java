package com.example.metrics_consumer.config;

import com.example.metrics_consumer.model.CustomMetricsDTO;

import lombok.extern.slf4j.Slf4j;
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
    public RecordMessageConverter converter() {
        JsonMessageConverter messageConverter = new JsonMessageConverter();
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        typeMapper.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID);
        typeMapper.addTrustedPackages("com.example.second_lesson.model");
        Map<String, Class<?>> mapping = new HashMap<>();
        mapping.put("metrics", CustomMetricsDTO.class);
        typeMapper.setIdClassMapping(mapping);
        messageConverter.setTypeMapper(typeMapper);
        return messageConverter;

    }
}
