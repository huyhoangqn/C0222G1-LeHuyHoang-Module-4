package com.codegym.product2.repository;

import com.codegym.product2.dto.ProductDTO;
import com.codegym.product2.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT new com.codegym.product2.dto.ProductDTO(p.id, p.description, p.manufacturer, p.name, p.price, p.status) FROM Product p where p.status =1")
    Page<ProductDTO> findAllProduct(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO product (description, manufacturer, name, price, status) VALUES (:description, :manufacturer, :name, :price, 1)", nativeQuery = true)
    void save(@Param("description") String description, @Param("manufacturer") String manufacturer, @Param("name") String name,
              @Param("price") String price);

    @Query(value = "SELECT new com.codegym.product2.dto.ProductDTO(p.id, p.description, p.manufacturer, p.name, p.price, p.status) FROM Product p where p.id =:id")
    ProductDTO findByIdProduct(@Param("id") Integer id);

    @Modifying
    @Query(value = "UPDATE product SET description = :description, manufacturer = :manufacturer, name = :name, price = :price WHERE id = :id", nativeQuery = true)
    void update(@Param("description") String description, @Param("manufacturer") String manufacturer, @Param("name") String name,
                @Param("price") String price, @Param("id") Integer id);

    @Modifying
    @Query(value = "UPDATE product SET status=0 WHERE id=:id", nativeQuery = true)
    void delete(@Param("id") Integer id);
}
