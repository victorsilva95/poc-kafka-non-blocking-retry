package com.github.victorsilva95.pockafkanonblockingretry.consumer;

import com.github.victorsilva95.pockafkanonblockingretry.dto.AnimeDTO;
import com.github.victorsilva95.pockafkanonblockingretry.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AnimeKafkaListener {

    private final AnimeService animeService;


    @KafkaListener(topics = "${anime.topic}", containerFactory = "nonBlockingRetryKafkaListenerContainerFactory")
    public void animeListener(@Payload AnimeDTO animeDTO,
                              @Header(value = KafkaHeaders.RECEIVED_MESSAGE_KEY, required = false) String key) {
        log.info("anime received: {}", animeDTO);

        animeService.saveAnime(animeDTO);


    }
}
