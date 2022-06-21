package mp3.repository.impl;

import mp3.model.Mp3;
import mp3.repository.IMp3Repository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Mp3Repository implements IMp3Repository {
    private static List<Mp3> mp3List = new ArrayList<>();


    @Override
    public void create(Mp3 mp3) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(mp3);
        entityTransaction.commit();
    }

    @Override
    public List<Mp3> findAll() {
        List<Mp3> mp3s = BaseRepository.entityManager.createQuery("select m from Mp3 m where m.status = 0", Mp3.class).getResultList();
        return mp3s;
    }

    @Override
    public Mp3 findById(int idSearch) {
        Mp3 mp3 = BaseRepository.entityManager.createQuery("select m from Mp3 m where id = ?1", Mp3.class).setParameter(1, idSearch).getSingleResult();
        return mp3;
    }

    @Override
    public void update(Mp3 mp3) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(mp3);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Mp3 mp3 = findById(id);
        mp3.setStatus(1);
        BaseRepository.entityManager.merge(mp3);
        entityTransaction.commit();
    }

    @Override
    public List<Mp3> search(String nameSong) {
        List<Mp3> list = BaseRepository.entityManager.createQuery("select m from Mp3 m where name like ?1 and m.status = 0",Mp3.class).setParameter(1,"%"+nameSong+"%").getResultList();
        return list;
    }

}
