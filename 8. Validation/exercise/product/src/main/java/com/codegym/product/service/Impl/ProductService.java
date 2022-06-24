package com.codegym.product.service.Impl;

import com.codegym.product.repository.IRepository;
import com.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {
    @Autowired
    private IRepository repository;

    @Override
    public Page<ProductDTO> findAllProduct(Pageable pageable) {
        return repository.findAllProduct(pageable);
    }
}
