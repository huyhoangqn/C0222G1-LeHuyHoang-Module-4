package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
    @Override
    public List<Music> findAll() {
        return BaseRepository.entityManager.createQuery("select m from music m where status = 0", Music.class).getResultList();
    }

//    @Override
//    public void save(Music music) {
//        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
//        entityTransaction.begin();
//        BaseRepository.entityManager.persist(music);
//        entityTransaction.commit();
//    }
//
//    @Override
//    public void update(Music music) {
//        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
//        entityTransaction.begin();
//        BaseRepository.entityManager.merge(music);
//        entityTransaction.commit();
//    }
//
//    @Override
//    public Music findById(int idSearch) {
//        return BaseRepository.entityManager.createQuery("select m from music m where id = ?1", Music.class).setParameter(1, idSearch).getSingleResult();
//    }
//
//    @Override
//    public void delete(int id) {
//        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
//        entityTransaction.begin();
//
//        Music music = findById(id);
//        music.setStatus(1);
//        BaseRepository.entityManager.merge(music);
//
//        entityTransaction.commit();
//    }
//
//    @Override
//    public List<Music> search(String name) {
//        return BaseRepository.entityManager.createQuery("select m from music m where name like ?1 and m.status = 0", Music.class).setParameter(1, "%" + name + "%").getResultList();
//    }
}
