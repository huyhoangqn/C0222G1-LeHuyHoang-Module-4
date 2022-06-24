package com.codegym.product2.service;

import com.codegym.product2.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductDTO> findAllProduct(Pageable pageable);

    void save(ProductDTO productDTO);

    ProductDTO findByIdProduct(Integer id);

    void update(ProductDTO productDTO);

    void delete(Integer id);

}
