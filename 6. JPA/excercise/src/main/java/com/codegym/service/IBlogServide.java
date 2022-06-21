package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogServide {
    List<Blog> findAllBlog();

    void save(Blog blog);

    Blog findByIdBlog(Integer codeBlog);

    void update(Blog blog);

    void delete(Blog blog);

    List<Blog> search(String nameBlog);
}
