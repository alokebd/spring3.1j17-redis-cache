package com.vision.cache.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vision.cache.entity.Product;
import com.vision.cache.payload.ProductRequest;
import com.vision.cache.payload.ProductResponse;
import com.vision.cache.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("/products")
    public String addProduct(@RequestBody ProductRequest request) {
        try {
            return service.addProduct(request);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return "Something went wrong";
    }

    @CachePut(cacheNames = "cache2", key = "'product'")
    @PutMapping("/products/{id}")
    public Product updateCustomer(@PathVariable long id, @RequestBody ProductRequest request) {
        log.info("inside the product by id");
        try {
            return service.updateProduct(id, request);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new Product();
    }

    @Cacheable(cacheNames = "cache1", key = "'product'")
    @GetMapping("/products")
    public List<Product> getAll() {
        try {
            return service.getAll();
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new ArrayList<Product>();
    }

    @Cacheable(cacheNames = "cache2", key = "'product'")
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        log.info("inside the product by id");
        try {
            return service.getProductById(id);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new Product();
    }


    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable long id) {
        try {
            service.delete(id);
            return "Success deleted.";
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return "Something went wrong";
    }
}

