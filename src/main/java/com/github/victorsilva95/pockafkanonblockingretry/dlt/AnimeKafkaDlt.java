package com.github.victorsilva95.pockafkanonblockingretry.dlt;

import com.github.victorsilva95.pockafkanonblockingretry.dto.AnimeDTO;
import com.github.victorsilva95.pockafkanonblockingretry.mapper.AnimeDltMapper;
import com.github.victorsilva95.pockafkanonblockingretry.model.AnimeDlt;
import com.github.victorsilva95.pockafkanonblockingretry.repository.AnimeDltRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AnimeKafkaDlt {
    private final AnimeDltRepository animeDltRepository;

    private final AnimeDltMapper animeDltMapper;

    public void processDltMessage(@Payload AnimeDTO animeDTO,
                                  @Header(value = KafkaHeaders.EXCEPTION_MESSAGE) String exceptionMessage) {
        exceptionMessage = exceptionMessage.substring(exceptionMessage.lastIndexOf(":") + 1).trim();
        log.info("exception message: {}", exceptionMessage);
        AnimeDlt animeDlt = animeDltMapper.animeDTOToAnimeModel(animeDTO, exceptionMessage);
        animeDltRepository.insertAnimeDlt(animeDlt);
    }
}
