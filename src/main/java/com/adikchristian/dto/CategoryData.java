package com.adikchristian.dto;

import javax.validation.constraints.NotEmpty;

public class CategoryData {
    
    Long id;

    @NotEmpty(message = "name is required")
    String name;

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

    
}
