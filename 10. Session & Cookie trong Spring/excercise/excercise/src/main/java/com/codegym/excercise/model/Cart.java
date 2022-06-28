package com.codegym.excercise.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public boolean checkIteminCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getProductId().equals(product.getProductId())) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<Product, Integer> selectItem(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getProductId().equals(product.getProductId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkIteminCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> item = selectItem(product);
            Integer newQuantity = item.getValue() + 1;
            products.replace(item.getKey(), newQuantity);
        }
    }
}
