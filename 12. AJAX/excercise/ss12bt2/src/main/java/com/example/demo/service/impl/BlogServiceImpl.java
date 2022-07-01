package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> showAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public List<Blog> search(String title) {
        return blogRepository.search("%" + title + "%");
    }
}
