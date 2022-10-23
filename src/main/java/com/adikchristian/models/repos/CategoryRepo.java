package com.adikchristian.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.adikchristian.models.entities.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {
    
}
