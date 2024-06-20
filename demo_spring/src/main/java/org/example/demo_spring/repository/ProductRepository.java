package org.example.demo_spring.repository;

import org.example.demo_spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
