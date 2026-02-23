package com.sample.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Brand;
import com.sample.entity.Category;
import com.sample.entity.Percentage;
import com.sample.repository.BrandRepository;
import com.sample.repository.CategoryRepository;
import com.sample.repository.PercentageRepository;

@Service
public class PercentageService {

    @Autowired
    private PercentageRepository percentageRepository;
    
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Percentage addPercentage(Percentage percentage) {
        // Validate and fetch Brand and Category
        Brand brand = brandRepository.findById(percentage.getBrand().getId())
                .orElseThrow(() -> new RuntimeException("Brand not found with ID: " + percentage.getBrand().getId()));
        Category category = categoryRepository.findById(percentage.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + percentage.getCategory().getId()));

        // Set validated Brand and Category
        percentage.setBrand(brand);
        percentage.setCategory(category);

        // Save Percentage
        return percentageRepository.save(percentage);
    }
    


    // Create or Update Percentage
    public Percentage savePercentage(Percentage percentage) {
        return percentageRepository.save(percentage);
    }

    // Retrieve All Percentages
    public List<Percentage> getAllPercentages() {
        return percentageRepository.findAll();
    }
    
 // Retrieve Percentage by ID
    public Optional<Percentage> getPercentageById(Long id) {
        return percentageRepository.findById(id);
    }

    // Delete Percentage by ID
    public void deletePercentageById(Long id) {
        percentageRepository.deleteById(id);
    }
}