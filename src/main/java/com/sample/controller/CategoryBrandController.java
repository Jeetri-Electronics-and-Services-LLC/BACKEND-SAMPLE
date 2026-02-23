package com.sample.controller;



import com.sample.entity.Category;
import com.sample.entity.CategoryBrandDTO;
import com.sample.entity.Brand;
import com.sample.service.CategoryBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category-brandids")
public class CategoryBrandController {

    @Autowired
    private CategoryBrandService categoryBrandService;

    // POST API to add category and brand association
    @PostMapping("/addonlycategory-brandids")
    public ResponseEntity<String> addCategoryBrandAssociation(@RequestBody CategoryBrandDTO categoryBrandDTO) {
        boolean isAdded = categoryBrandService.addCategoryBrandAssociation(categoryBrandDTO);
        if (isAdded) {
            return ResponseEntity.ok("Category-Brand association added successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to add Category-Brand association.");
        }
    }
}
