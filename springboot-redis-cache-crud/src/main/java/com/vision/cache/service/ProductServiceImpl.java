package com.vision.cache.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.vision.cache.entity.Product;
import com.vision.cache.payload.ProductRequest;
import com.vision.cache.repository.ProductRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public String addProduct(ProductRequest request) {
        if (isValidProductRequest(request)) {
            repository.save(saveProduct(request));
            return "product created successfully";
        } else {
            return "bad request,please check product details";
        }
    }

    public Boolean isValidProductRequest(ProductRequest request) {
        return request.getTitle() != null && request.getDescription() != null;
    }

    public Product saveProduct(ProductRequest request) {
        return Product.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
    }

    @Override
    public Product updateProduct(long id, ProductRequest request) {
        Product product = repository.findById(id).orElse(null);
        if (product == null) {
            return new Product();
        } else {
            product.setTitle(request.getTitle());
            product.setDescription(request.getDescription());
            return repository.save(product);
        }
    }

    @Override
    public List<Product> getAll() {
        log.info("Inside a get All message");
        return repository.findAll().stream().toList();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }


    @Override
    @CacheEvict(cacheNames = "cache1",key = "'product'")
    public void delete(long id) {
        repository.deleteById(id);
    }
}
