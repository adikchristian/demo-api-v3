package com.adikchristian.dto;

import javax.validation.constraints.NotEmpty;

public class ProductData {
    private Long id;

    @NotEmpty(message = "Name is Required")
    private String name;

    @NotEmpty(message = "Description is Required")
    private String description;

    private double price;

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

    
}
