package com.vision.cache.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vision.cache.payload.CustomerRequest;
import com.vision.cache.payload.CustomerResponse;
import com.vision.cache.service.CustomerService;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerRequest request) {
        try {
            return customerService.addCustomer(request);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable long id, @RequestBody CustomerRequest request) {
        try {
            return customerService.updateCustomer(id, request);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/customers")
    @Cacheable(cacheNames = "cache0", key = "'customer'")
    public ResponseEntity<List<CustomerResponse>> getAll() {
        try {
            return customerService.getAll();
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new ResponseEntity<List<CustomerResponse>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        try {
            return customerService.getCustomerById(id);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            return customerService.delete(id);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/customers/age/{age}")
    public ResponseEntity<List<CustomerResponse>> getCustomerByAgeGreaterThan(@PathVariable int age) {
        try {
            return customerService.getCustomerByAgeGreaterThan(age);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



