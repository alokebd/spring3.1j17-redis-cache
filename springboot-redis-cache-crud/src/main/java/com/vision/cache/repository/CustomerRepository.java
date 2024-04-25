package com.vision.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vision.cache.entity.Customer;
import com.vision.cache.payload.CustomerResponse;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("select new com.vision.cache.payload.CustomerResponse(c.id,c.name,c.age) from Customer c")
    List<CustomerResponse> getAll();
}
