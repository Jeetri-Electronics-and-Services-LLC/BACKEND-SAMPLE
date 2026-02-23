package com.sample.controller;



import com.sample.service.BrandUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/brand-user")
public class BrandUserController {

    @Autowired
    private BrandUserService brandUserService;

    @PostMapping("/addbrand-user")
    public ResponseEntity<String> addBrandUser(@RequestBody Map<String, Long> requestBody) {
        Long brandId = requestBody.get("brandId");
        Long userId = requestBody.get("userId");

        if (brandId == null || userId == null) {
            return ResponseEntity.badRequest().body("Both brandId and userId are required.");
        }

        boolean result = brandUserService.addBrandUser(brandId, userId);
        if (result) {
            return ResponseEntity.ok("Brand and User association created successfully.");
        } else {
            return ResponseEntity.badRequest().body("Error creating Brand and User association.");
        }
    }
}

