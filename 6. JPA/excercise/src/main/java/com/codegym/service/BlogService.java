package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogServide {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAllBlog() {
        return iBlogRepository.findAllBlog();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog.getNameBlog(), blog.getContentBlog());
    }

    @Override
    public Blog findByIdBlog(Integer codeBlog) {
        return iBlogRepository.findByIdBlog(codeBlog);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.update(blog.getNameBlog(), blog.getContentBlog(), blog.getCodeBlog());
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog.getCodeBlog());
    }

    @Override
    public List<Blog> search(String nameBlog) {
        return iBlogRepository.searchBlog("%" + nameBlog + "%");
    }

}
