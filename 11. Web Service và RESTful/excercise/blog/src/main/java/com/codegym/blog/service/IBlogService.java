package com.codegym.blog.service;

import com.codegym.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Blog save(Blog blog);

    Optional<Blog> findById(Long id);

    void remove(Long id);
}
