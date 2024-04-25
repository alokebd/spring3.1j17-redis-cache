package com.vision.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vision.cache.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
