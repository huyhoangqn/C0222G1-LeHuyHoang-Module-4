package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Music> findAll() {
        List<Music> musicList = BaseRepository.entityManager.createQuery("select m from music m", Music.class).getResultList();
        return musicList;
    }

    @Override
    public void save(Music music) {
        if (music.getId() != null) {
            em.merge(music);
        } else {
            em.persist(music);
        }
    }
}

