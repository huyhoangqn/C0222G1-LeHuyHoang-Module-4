package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMusicRepository {
    List<Music> findAll();

//    void save(Music music);
//
//    void update(Music music);
//
//    Music findById(int idSearch);
//
//    void delete(int id);
//
//    List<Music> search(String name);
}
