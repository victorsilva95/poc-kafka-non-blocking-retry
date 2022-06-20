package com.github.victorsilva95.pockafkanonblockingretry.mapper;

import com.github.victorsilva95.pockafkanonblockingretry.dto.AnimeDTO;
import com.github.victorsilva95.pockafkanonblockingretry.model.AnimeDlt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AnimeDltMapper {

    @Mapping(target = "exception", source = "exceptionMessage")
    AnimeDlt animeDTOToAnimeModel(AnimeDTO animeDTO, String exceptionMessage);
}
