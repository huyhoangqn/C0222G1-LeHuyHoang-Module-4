package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.BlogRepository;
import com.codegym.blog.service.IBlogServide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogServide {
    @Autowired
    private BlogRepository iBlogRepository;

    @Override
    public List<Blog> findAllBlog() {
        return iBlogRepository.findAllBlog();
    }

    @Override
    public Page<Blog> getAll(Pageable pageable) {
        return iBlogRepository.findAllBlog(pageable);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog.getAuthor(), blog.getContent(), blog.getDate(), blog.getTitle(), blog.getCategory().getId());
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.delete(id);
    }

    @Override
    public Blog findByIdBlog(Integer codeBlog) {
        return iBlogRepository.findByIdBlog(codeBlog);
    }

    @Override
    public List<Blog> search(String title) {
        return iBlogRepository.searchBlog("%" + title + "%");
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.update(blog.getAuthor(), blog.getContent(), blog.getDate(), blog.getTitle(), blog.getCategory().getId(), blog.getId());
    }
}
