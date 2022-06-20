package com.github.victorsilva95.pockafkanonblockingretry.mapper;

import com.github.victorsilva95.pockafkanonblockingretry.dto.AnimeDTO;
import com.github.victorsilva95.pockafkanonblockingretry.model.Anime;
import org.mapstruct.Mapper;

@Mapper
public interface AnimeMapper {

    Anime animeDTOToAnimeModel(AnimeDTO animeDTO);
}
