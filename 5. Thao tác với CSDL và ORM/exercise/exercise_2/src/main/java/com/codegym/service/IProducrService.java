package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProducrService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);

    List<Product> search(String nameProduct);
}
