package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("product")
public class ProductService implements IProducrService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Nokia", "2000", "Very good", "Nokia"));
        products.put(2, new Product(2, "Samsung", "3000", "Normal", "Samsung"));
        products.put(3, new Product(3, "Iphone", "4000", "Ok", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if (entry.getValue().getName().toLowerCase().contains(name.toLowerCase())) {
                productList.add(entry.getValue());
            }
        }
        return productList;
    }
}
