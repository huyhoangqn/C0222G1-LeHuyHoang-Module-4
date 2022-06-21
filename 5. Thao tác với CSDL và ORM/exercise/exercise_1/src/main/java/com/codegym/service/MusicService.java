package com.codegym.service;

import com.codegym.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("music")
public class MusicService implements IMusicService {
    @Autowired
    private IMusicService musicService;

    @Override
    public List<Music> findAll() {
        return musicService.findAll();
    }

//    @Override
//    public void save(Music music) {
//        musicService.save(music);
//    }
//
//    @Override
//    public void update(Music music) {
//        musicService.update(music);
//    }
//
//    @Override
//    public Music findById(int idSearch) {
//        return musicService.findById(idSearch);
//    }
//
//    @Override
//    public void delete(int id) {
//        musicService.delete(id);
//    }
//
//    @Override
//    public List<Music> search(String name) {
//        return musicService.search(name);
//    }
}
