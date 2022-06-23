package com.codegym.blog.service;

import com.codegym.blog.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
