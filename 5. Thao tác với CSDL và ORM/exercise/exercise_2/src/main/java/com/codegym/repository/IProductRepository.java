package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository {
    List<Product> findAll();

    void save(Product music);

    void update(Product product);

    Product findById(int idSearch);

    void delete(int id);

    List<Product> search(String name);
}
