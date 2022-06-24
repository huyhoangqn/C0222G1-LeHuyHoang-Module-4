package com.codegym.product2.service.impl;

import com.codegym.product2.dto.ProductDTO;
import com.codegym.product2.entity.Product;
import com.codegym.product2.repository.IRepository;
import com.codegym.product2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IRepository iRepository;

    @Override
    public Page<ProductDTO> findAllProduct(Pageable pageable) {
        return iRepository.findAllProduct(pageable);
    }

    @Override
    public void save(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setManufacturer(productDTO.getManufacturer());
        product.setPrice(productDTO.getPrice());
        iRepository.save(product.getDescription(), product.getManufacturer(), product.getName(), product.getPrice());
    }

    @Override
    public ProductDTO findByIdProduct(Integer id) {
        return iRepository.findByIdProduct(id);
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setManufacturer(productDTO.getManufacturer());
        product.setPrice(productDTO.getPrice());
        iRepository.update(product.getDescription(), product.getManufacturer(), product.getName(), product.getPrice(), product.getId());
    }

    @Override
    public void delete(Integer id) {
        iRepository.delete(id);
    }
}
