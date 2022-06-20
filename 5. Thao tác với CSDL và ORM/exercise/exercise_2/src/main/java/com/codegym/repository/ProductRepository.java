package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository("repo")
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        List<Product> productList = BaseRepository.entityManager.createQuery("select p from product p where status = 0", Product.class).getResultList();
        return productList;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int idSearch) {
        Product product = BaseRepository.entityManager.createQuery("select p from product p where id = ?1", Product.class).setParameter(1, idSearch).getSingleResult();
        return product;
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();

        Product product = findById(id);
        product.setStatus(1);
        BaseRepository.entityManager.merge(product);

        entityTransaction.commit();
    }

    @Override
    public List<Product> search(String nameProduct) {
        List<Product> list = BaseRepository.entityManager.createQuery("select m from product m where name like ?1 and m.status = 0", Product.class).setParameter(1, "%" + nameProduct + "%").getResultList();
        return list;
    }
}

