package com.github.victorsilva95.pockafkanonblockingretry.repository;

import com.github.victorsilva95.pockafkanonblockingretry.model.AnimeDlt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AnimeDltRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertAnimeDlt(AnimeDlt animeDlt) {
        this.entityManager.persist(animeDlt);
    }

}
