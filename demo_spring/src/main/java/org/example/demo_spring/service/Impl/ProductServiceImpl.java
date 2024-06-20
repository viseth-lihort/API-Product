package org.example.demo_spring.service.Impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.demo_spring.model.Product;
import org.example.demo_spring.model.Student;
import org.example.demo_spring.repository.ProductRepository;
import org.example.demo_spring.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product, Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product prod = optionalProduct.get();
            prod.setName(product.getName());
            prod.setPricePerUnit(product.getPricePerUnit());
            prod.setActiveForSell(product.getActiveForSell());

            return productRepository.save(prod);
        }else{
            throw new EntityNotFoundException("Product not found with id " + id);
        }
    }

    @Override
    public Optional<Product> findProductById(Integer id) {
        return productRepository.findById(id);
    }
}
