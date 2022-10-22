package com.adikchristian.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.adikchristian.models.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
    
}
