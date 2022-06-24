package com.codegym.product.repository;

import com.codegym.product.model.dto.ProductDTO;
import com.codegym.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends JpaRepository<Product, Integer> {
//    @Query(value = "select id,description,manufacturer,name, price from product where status = 1", nativeQuery = true)
//    Page<ProductDTO> findAllProduct(Pageable pageable);

    @Query(value="SELECT new com.codegym.product.model.dto.ProductDTO(p.id, p.description, p.manufacturer, p.name, p.price, p.status) FROM product p")
    Page<ProductDTO> findAllProduct(Pageable pageable);

//    ProductDTO(Integer id, String description, String manufacturer, String name, String price, Integer status)

}