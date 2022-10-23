package com.adikchristian.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adikchristian.dto.ProductData;
import com.adikchristian.dto.ResponseData;
import com.adikchristian.models.entities.Product;
import com.adikchristian.services.ProductService;

@RestController
@RequestMapping(value = "/api/products", produces = "application/json")
public class ProductController {

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody ProductData productData, Errors errors){

        ResponseData<Product> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Product product = modelMapper.map(productData, Product.class);

        responseData.setStatus(true);
        responseData.setMessages(null);
        responseData.setPayload(productService.create(product));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<Iterable<Product>>> findAll(){
        ResponseData<Iterable<Product>> responseData = new ResponseData<>();
        responseData.setStatus(true);
        responseData.setPayload(productService.findAll());
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Product>> findOne(@PathVariable("id") long id){
        ResponseData<Product> responseData = new ResponseData<>();
        Product product = productService.findById(id);
        if(product==null){
            responseData.setStatus(false);
            responseData.getMessages().add("Data product tidak ditemukan");
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(product);
        return ResponseEntity.ok(responseData);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Product>> update(@Valid @RequestBody ProductData productData, Errors errors){
        ResponseData<Product> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Product product = modelMapper.map(productData, Product.class);

        responseData.setStatus(true);
        responseData.setMessages(null);
        responseData.setPayload(productService.create(product));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Product>> remove(@PathVariable("id") long id){
        ResponseData<Product> responseData = new ResponseData<>();
        Product product = productService.findById(id);
        if(product==null){
            responseData.setStatus(false);
            responseData.getMessages().add("Data product tidak ditemukan");
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(null);
        responseData.getMessages().add("Data Berhasil dihapus");
        return ResponseEntity.ok(responseData);
    }
}
