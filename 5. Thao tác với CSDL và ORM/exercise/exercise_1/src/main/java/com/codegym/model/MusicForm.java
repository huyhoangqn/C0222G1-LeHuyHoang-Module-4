package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private Long id;
    private String nameMusic;
    private String author;
    private String category;
    private MultipartFile music;

    public MusicForm() {
    }

    public MusicForm(Long id, String nameMusic, String author, String category, MultipartFile music) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.author = author;
        this.category = category;
        this.music = music;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MultipartFile getMusic() {
        return music;
    }

    public void setMusic(MultipartFile music) {
        this.music = music;
    }
}
