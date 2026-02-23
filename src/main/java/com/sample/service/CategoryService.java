package com.sample.service;

import com.sample.entity.Brand;

import com.sample.entity.Category;
import com.sample.entity.CategoryDTO1;
import com.sample.repository.BrandRepository;
import com.sample.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private BrandRepository brandRepository;

 // Method to add category to the database
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Get all Categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get Category by ID
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    // Update a Category
    public Category updateCategory(int id, Category categoryDetails) {
        if (categoryRepository.existsById(id)) {
            categoryDetails.setId(id);
            return categoryRepository.save(categoryDetails);
        } else {
            throw new RuntimeException("Category not found with id " + id);
        }
    }

    // Delete a Category
    public void deleteCategory(int id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Category not found with id " + id);
        }
    }
    
    
    
  // Display list of category id,names based on brandid
    public List<CategoryDTO1> getCategoryIdsAndNamesByBrandId(int brandId) {
        return categoryRepository.findCategoryIdsAndNamesByBrandId(brandId);
    }
}
