package com.github.victorsilva95.pockafkanonblockingretry.service;

import com.github.victorsilva95.pockafkanonblockingretry.dto.AnimeDTO;
import com.github.victorsilva95.pockafkanonblockingretry.exception.IncompleteAnimeException;
import com.github.victorsilva95.pockafkanonblockingretry.mapper.AnimeMapper;
import com.github.victorsilva95.pockafkanonblockingretry.model.Anime;
import com.github.victorsilva95.pockafkanonblockingretry.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnimeService {
    private final AnimeRepository animeRepository;
    private final AnimeMapper animeMapper;


    public void saveAnime(AnimeDTO animeDTO) {
        if(Boolean.FALSE.equals(animeDTO.isAnimeValid())) {
            throw new IncompleteAnimeException();
        }
        Anime anime = animeMapper.animeDTOToAnimeModel(animeDTO);
        log.info("save anime in database: {}", animeDTO);
        animeRepository.insertAnime(anime);
    }
}
