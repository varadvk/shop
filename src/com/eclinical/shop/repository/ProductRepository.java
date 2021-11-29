package com.eclinical.shop.repository;

import com.eclinical.shop.model.Product;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class ProductRepository {

    static Set<Product> products = new LinkedHashSet<>();

    static {
        Product product1 = new Product(1, "iPhone 13", 999.10);
        Product product2 = new Product(2, "iPhone 12", 899.10);
        Product product3 = new Product(3, "iPhone 11", 799.10);

        products.add(product1);
        products.add(product2);
        products.add(product3);
    }


    public void addProduct(Product product) {
        products.add(product);
    }

    public Set<Product> findAll() {
        return products;
    }

    public Optional<Product> findByProductId(Integer productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public void deleteProduct(int productId) {
        Product p = new Product(productId, null, null);
        products.remove(p);
    }

    public void save(Product product) {
        products.add(product);
    }
}
