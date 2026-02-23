package com.sample.service;


import com.sample.entity.Category;
import com.sample.entity.CategoryBrandDTO;
import com.sample.entity.Brand;
import com.sample.repository.CategoryRepository;
import com.sample.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryBrandService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    // Method to add category and brand association
    public boolean addCategoryBrandAssociation(CategoryBrandDTO categoryBrandDTO) {
        // Find Category by category_id
        Category category = categoryRepository.findById(categoryBrandDTO.getCategoryId()).orElse(null);

        // Find Brand by brand_id
        Brand brand = brandRepository.findById(categoryBrandDTO.getBrandId()).orElse(null);

        if (category != null && brand != null) {
            // Add the association (this will be handled by the many-to-many relationship)
            category.getBrands().add(brand);
            brand.getCategorys().add(category);

            // Save the updated Category and Brand entities
            categoryRepository.save(category);
            brandRepository.save(brand);

            return true;
        }
        return false;
    }
}
