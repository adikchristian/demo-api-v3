package com.adikchristian.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.adikchristian.models.entities.Category;

public class ProductData {
    private Long id;

    @NotEmpty(message = "Name is Required")
    private String name;

    @NotEmpty(message = "Description is Required")
    private String description;

    @DecimalMin(value = "1.0", message = "Please Enter a valid price")
    private double price;

    @NotNull(message = "Category is Required")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
}
