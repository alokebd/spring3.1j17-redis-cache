package com.vision.cache.service;


import java.util.List;

import com.vision.cache.entity.Product;
import com.vision.cache.payload.ProductRequest;
import com.vision.cache.payload.ProductResponse;

public interface ProductService {
    String addProduct(ProductRequest request);

    Product updateProduct(long id, ProductRequest request);

    List<Product> getAll();

    Product getProductById(Long id);

    void delete(long id);
}
