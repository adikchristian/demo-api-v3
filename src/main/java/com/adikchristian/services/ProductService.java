package com.adikchristian.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adikchristian.models.entities.Product;
import com.adikchristian.models.repos.ProductRepo;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product create(Product product){
        return productRepo.save(product);
    }

    public boolean checkAvailableProductById(Long id){
        Optional<Product> product = productRepo.findById(id);

        if(!product.isPresent()){
            return false;
        }

        return true;
    }

    public Product findById(Long id){
        boolean product = checkAvailableProductById(id);

        if(!product){
            return null;
        }
        return productRepo.findById(id).get();
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void remove(Long id){
        productRepo.deleteById(id);
    }
}
