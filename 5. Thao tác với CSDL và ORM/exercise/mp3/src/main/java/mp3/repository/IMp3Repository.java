package mp3.repository;

import mp3.model.Mp3;

import java.util.List;

public interface IMp3Repository {
    void create(Mp3 mp3);
    List<Mp3> findAll();
    Mp3 findById(int id);
    void update( Mp3 mp3);

    void delete (int id);
    List<Mp3> search(String nameSong);
}
