package com.github.victorsilva95.pockafkanonblockingretry.dto;

import java.time.LocalDate;
import java.util.Objects;

public record AnimeDTO(String name, String gender, String authorName, LocalDate publishDate) {

    public Boolean isAnimeValid(){
        return Objects.nonNull(name) &&
                Objects.nonNull(gender) &&
                Objects.nonNull(authorName) &&
                Objects.nonNull(publishDate);
    }
}
