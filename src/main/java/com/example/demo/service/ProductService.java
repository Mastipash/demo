package com.example.demo.service;


import com.example.demo.entity.Product;

public interface ProductService {
    Iterable<Product> getAllProducts();
    void saveProducts(Product product);
    Product getProductById(int id);
    void confirmProductById(int id);
    void getOutProductById(int id);
}
