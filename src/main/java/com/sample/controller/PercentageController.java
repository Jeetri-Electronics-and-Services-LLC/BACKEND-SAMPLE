package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.Percentage;

import com.sample.service.PercentageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/percentages")
public class PercentageController {

    @Autowired
    private PercentageService percentageService;

    @PostMapping("/addpercentagewithbrandcategory")
    public ResponseEntity<Percentage> addPercentage(@RequestBody Percentage percentage) {
        Percentage savedPercentage = percentageService.addPercentage(percentage);
        return ResponseEntity.ok(savedPercentage);
    }

    // Retrieve All Percentages
    @GetMapping
    public ResponseEntity<List<Percentage>> getAllPercentages() {
        List<Percentage> percentages = percentageService.getAllPercentages();
        return ResponseEntity.ok(percentages);
    }

    // Retrieve Percentage by ID
    @GetMapping("/{id}")
    public ResponseEntity<Percentage> getPercentageById(@PathVariable Long id) {
        Optional<Percentage> percentage = percentageService.getPercentageById(id);
        return percentage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Percentage by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePercentageById(@PathVariable Long id) {
        percentageService.deletePercentageById(id);
        return ResponseEntity.noContent().build();
    }
}