package com.github.victorsilva95.pockafkanonblockingretry.config;

import com.github.victorsilva95.pockafkanonblockingretry.dto.AnimeDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.retrytopic.RetryTopicConfiguration;
import org.springframework.kafka.retrytopic.RetryTopicConfigurationBuilder;
import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;

@Configuration
public class KafkaRetryableTopicConfig {
    @Value(value = "${anime.topic}")
    private String animeTopic;

    @Bean
    public RetryTopicConfiguration retryAnimeTopic(KafkaTemplate<String, AnimeDTO> template) {
        return RetryTopicConfigurationBuilder
                .newInstance()
                .maxAttempts(4)
                .exponentialBackoff(1000, 2, 5000)
                .setTopicSuffixingStrategy(TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE)
                .includeTopic(animeTopic)
                .dltHandlerMethod("animeKafkaDlt", "processDltMessage")
                .create(template);
    }
}
