package com.sample.entity;



public class CategoryBrandDTO {
    private int categoryId;
    private long brandId;

    // Getters & Setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }
}
