package com.github.victorsilva95.pockafkanonblockingretry.config;

import com.github.victorsilva95.pockafkanonblockingretry.dto.AnimeDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;


    public ConsumerFactory<String, AnimeDTO> nonBlockingRetryConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "non-blocking-retry");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(AnimeDTO.class));

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, AnimeDTO> nonBlockingRetryKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, AnimeDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(nonBlockingRetryConsumerFactory());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.RECORD);
        return factory;
    }

}

