package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogServide {
    List<Blog> findAllBlog();

    public Page<Blog> getAll(Pageable pageable);

    void save(Blog blog);

    void delete(Integer id);

    Blog findByIdBlog(Integer codeBlog);

    void update(Blog blog);

    List<Blog> search(String nameBlog);
}
