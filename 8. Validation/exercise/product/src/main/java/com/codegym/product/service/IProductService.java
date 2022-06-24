package com.codegym.product.service;

import com.codegym.product.model.dto.ProductDTO;
import com.codegym.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductDTO> findAllProduct(Pageable pageable);
}
