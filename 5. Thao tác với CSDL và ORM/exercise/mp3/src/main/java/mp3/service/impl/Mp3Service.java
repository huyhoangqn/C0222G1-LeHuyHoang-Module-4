package mp3.service.impl;

import mp3.model.Mp3;
import mp3.repository.IMp3Repository;
import mp3.service.IMp3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Mp3Service implements IMp3Service {

    @Autowired
    private IMp3Repository iMp3Repository;

    @Override
    public void create(Mp3 mp3) {
    iMp3Repository.create(mp3);
    }

    @Override
    public List<Mp3> findAll() {
        return iMp3Repository.findAll();
    }

    @Override
    public Mp3 findById(int id) {
        return iMp3Repository.findById(id);
    }

    @Override
    public void update( Mp3 mp3) {
        iMp3Repository.update(mp3);
    }

    @Override
    public void delete(int id) {
         iMp3Repository.delete(id);
    }

    @Override
    public List<Mp3> search(String nameSong) {
        return iMp3Repository.search(nameSong);
    }
}
