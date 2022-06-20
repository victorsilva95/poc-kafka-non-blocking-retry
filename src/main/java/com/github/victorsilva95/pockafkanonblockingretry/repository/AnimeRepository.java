package com.github.victorsilva95.pockafkanonblockingretry.repository;

import com.github.victorsilva95.pockafkanonblockingretry.model.Anime;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AnimeRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertAnime(Anime anime) {
        this.entityManager.persist(anime);
    }

}
