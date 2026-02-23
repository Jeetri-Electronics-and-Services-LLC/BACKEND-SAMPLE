package com.sample.controller;

import com.sample.entity.BrandDTO1;

import com.sample.entity.Category;
import com.sample.entity.CategoryDTO1;
import com.sample.entity.City;
import com.sample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/categoriesbrand")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // POST API to add category details
    @PostMapping("/addcategorydetailsonly")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.addCategory(category);
        return ResponseEntity.ok(savedCategory);
    }
    

    // Get all Categories
    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Get a Category by ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        Optional<Category> category = categoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a Category
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category categoryDetails) {
        try {
            Category updatedCategory = categoryService.updateCategory(id, categoryDetails);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    //Display list of category names
//    @GetMapping("/listofcategoriesnames")
//    public List<CategoryDTO> getCategories() {
//        return categoryService.getAllCategories1();
//    }
    
  
    
//  // Display list of category id,names based on brandid
//    @GetMapping("/categorylistbybrandid/{brandId}")
//    public List<CategoryDTO1> getCategoriesByBrandId(@PathVariable int brandId) {
//        return categoryService.getCategoryIdsAndNamesByBrandId(brandId);
//    }
    
 // POST API to display list of category id, names based on brandId
    @PostMapping("/categorylistbybrandid")
    public ResponseEntity<List<CategoryDTO1>> getCategoriesByBrandId(@RequestBody Map<String, Integer> request) {
        int brandId = request.get("brandId");
        List<CategoryDTO1> categories = categoryService.getCategoryIdsAndNamesByBrandId(brandId);
        return ResponseEntity.ok(categories);
    }
    
    
   
}
