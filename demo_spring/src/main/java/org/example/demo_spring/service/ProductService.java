package org.example.demo_spring.service;

import org.example.demo_spring.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product updateProduct(Product product, Integer id);

    Optional<Product> findProductById(Integer id);
}
