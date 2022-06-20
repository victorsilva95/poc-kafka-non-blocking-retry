package com.github.victorsilva95.pockafkanonblockingretry.config;

import com.github.victorsilva95.pockafkanonblockingretry.dto.AnimeDTO;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;


    public ProducerFactory<String, AnimeDTO> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        return new DefaultKafkaProducerFactory<>(configProps, new StringSerializer(),
                new JsonSerializer<>());
    }

    @Bean
    public KafkaTemplate<String, AnimeDTO> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
