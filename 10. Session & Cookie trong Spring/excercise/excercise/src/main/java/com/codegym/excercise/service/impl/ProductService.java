package com.codegym.excercise.service.impl;

import com.codegym.excercise.model.Product;
import com.codegym.excercise.repository.ProductRepository;
import com.codegym.excercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository repository;


    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(String productId) {
        return repository.findById(productId);
    }


}
