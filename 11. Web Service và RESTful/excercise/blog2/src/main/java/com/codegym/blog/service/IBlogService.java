package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
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

}
