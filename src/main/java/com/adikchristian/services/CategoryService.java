package com.adikchristian.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adikchristian.models.entities.Category;
import com.adikchristian.models.repos.CategoryRepo;

@Service
@Transactional
public class CategoryService {
    
    @Autowired
    private CategoryRepo categoryRepo;

    public Category save(Category category){
        return categoryRepo.save(category);
    }

    public boolean checkAvailableCategoryById(Long id){
        Optional<Category> category = categoryRepo.findById(id);

        if(!category.isPresent()){
            return false;
        }

        return true;
    }

    public Category findById(Long id){
        boolean isCatgeory = checkAvailableCategoryById(id);

        if(!isCatgeory){
            return null;
        }

        return categoryRepo.findById(id).get();
    }

    public Iterable<Category> findAll(){
        return categoryRepo.findAll();
    }

    public void remove(Long id){
        categoryRepo.deleteById(id);
    }
}
