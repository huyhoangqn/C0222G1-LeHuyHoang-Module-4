package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class MusicRepository implements IMusicRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Music> findAll() {
        String queryStr = "select c from Music as c";
        TypedQuery<Music> qr = em.createQuery(queryStr, Music.class);
        return qr.getResultList();
    }

    @Override
    public void save(Music music) {
        if (music.getId() != null) {
            em.merge(music);
        } else {
            em.persist(music);
        }
    }

    @Override
    public void delete(Long id) {
        Music music = findById(id);
        if (music != null) {
            em.remove(music);
        }
    }

    @Override
    public Music findById(Long id) {
        String queryStr = "select c from Music as c where c.id=:id";
        Music music1 = em.createQuery(queryStr, Music.class).setParameter("id", id).getSingleResult();
        return music1;
    }
}
