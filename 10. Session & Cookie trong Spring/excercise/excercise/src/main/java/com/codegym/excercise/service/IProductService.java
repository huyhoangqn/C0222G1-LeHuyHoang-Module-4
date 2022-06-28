package com.codegym.excercise.service;

import com.codegym.excercise.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(String productId);
}
