package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProducts(Product document) {
        this.productRepository.save(document);
    }

    @Override
    public Product getProductById(int id) {
        Optional< Product > optional = productRepository.findById(id);
        Product product;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException("Не найден заказ с id: " + id);
        }
        return product;
    }


}
