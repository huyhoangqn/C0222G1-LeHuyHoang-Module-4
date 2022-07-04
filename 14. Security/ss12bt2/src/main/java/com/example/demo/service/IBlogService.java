package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> showAll(Pageable pageable);

    List<Blog> findAll();

    List<Blog> findByCategory(Category category);

    void create(Blog blog);

    void update(Blog blog);

    void delete(Blog blog);

    Blog findById(Integer id);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    List<Blog> search(String title);
}
