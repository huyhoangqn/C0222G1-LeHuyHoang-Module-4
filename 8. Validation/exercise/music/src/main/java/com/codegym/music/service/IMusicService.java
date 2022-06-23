package com.codegym.music.service;

import com.codegym.music.model.Music;

import java.util.List;
import java.util.Optional;

public interface IMusicService {
    List<Music> findAll();

    void create(Music music);

    Optional<Music> findById(Integer id);

    void save(Music music);
}
