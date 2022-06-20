package com.codegym.service;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{

    //Tại sao k tạo @Bean ở Config vẫn Autowired dc, mà cái MusicService phải tạo bean ở config
    //  mới Autowired được ở controller=> vì có @Repository
    @Autowired
    IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void delete(Long id) {
        musicRepository.delete(id);
    }

    @Override
    public Music findById(Long id) {
        return musicRepository.findById(id);
    }
}
