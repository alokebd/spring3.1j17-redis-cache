package com.vision.cache.service;

import org.springframework.http.ResponseEntity;

import com.vision.cache.payload.CustomerRequest;
import com.vision.cache.payload.CustomerResponse;
import com.vision.cache.payload.ProductRequest;

import java.util.List;


public interface CustomerService {


    ResponseEntity<String> addCustomer(CustomerRequest request);

    ResponseEntity<String> updateCustomer(long id, CustomerRequest request);

    ResponseEntity<List<CustomerResponse>> getAll();

    ResponseEntity<?> getCustomerById(Long id);

    ResponseEntity<String> delete(Long id);

    ResponseEntity<List<CustomerResponse>> getCustomerByAgeGreaterThan(int age);


}
