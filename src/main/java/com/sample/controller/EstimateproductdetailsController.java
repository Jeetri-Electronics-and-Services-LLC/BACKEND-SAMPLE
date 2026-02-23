package com.sample.controller;

import com.sample.entity.Estimateproductdetails;
import com.sample.service.EstimateproductdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estimateproductdetails")
public class EstimateproductdetailsController {

    @Autowired
    private EstimateproductdetailsService estimateproductdetailsService;

    // Create or update Estimateproductdetails
    @PostMapping
    public ResponseEntity<Estimateproductdetails> createOrUpdate(@RequestBody Estimateproductdetails estimateproductdetails) {
        Estimateproductdetails saved = estimateproductdetailsService.save(estimateproductdetails);
        return ResponseEntity.ok(saved);
    }

    // Get all Estimateproductdetails
    @GetMapping
    public ResponseEntity<List<Estimateproductdetails>> getAll() {
        List<Estimateproductdetails> estimateproductdetailsList = estimateproductdetailsService.getAll();
        return ResponseEntity.ok(estimateproductdetailsList);
    }

    // Get Estimateproductdetails by ID
    @GetMapping("/{id}")
    public ResponseEntity<Estimateproductdetails> getById(@PathVariable Long id) {
        Optional<Estimateproductdetails> estimateproductdetails = estimateproductdetailsService.getById(id);
        return estimateproductdetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Estimateproductdetails by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        estimateproductdetailsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
