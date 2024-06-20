package org.example.demo_spring.controller;


import lombok.RequiredArgsConstructor;
import org.example.demo_spring.model.Product;
import org.example.demo_spring.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product addStudent(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Integer id) {
        return productService.updateProduct(product, id);
    }

    @GetMapping
    public List<Product> findAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Integer id) {
        Optional<Product> product = productService.findProductById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
