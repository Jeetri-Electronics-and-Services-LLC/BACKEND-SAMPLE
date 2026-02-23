package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.Estimatewithouttax;
import com.sample.service.EstimatewithouttaxService;

import java.util.List;

@RestController
@RequestMapping("/estimatewithouttax")
public class EstimatewithouttaxController {

    @Autowired
    private EstimatewithouttaxService service;

    // Get all estimates without tax
    @GetMapping
    public ResponseEntity<List<Estimatewithouttax>> getAllEstimatesWithoutTax() {
        return ResponseEntity.ok(service.getAllEstimatesWithoutTax());
    }

    // Get estimate without tax by ID
    @GetMapping("/{id}")
    public ResponseEntity<Estimatewithouttax> getEstimateWithoutTaxById(@PathVariable Long id) {
        Estimatewithouttax result = service.getEstimateWithoutTaxById(id);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    // Create a new estimate without tax
    @PostMapping
    public ResponseEntity<Estimatewithouttax> createEstimateWithoutTax(@RequestBody Estimatewithouttax estimateWithoutTax) {
        Estimatewithouttax saved = service.saveEstimateWithoutTax(estimateWithoutTax);
        return ResponseEntity.ok(saved);
    }

    // Update an existing estimate without tax
    @PutMapping("/{id}")
    public ResponseEntity<Estimatewithouttax> updateEstimateWithoutTax(@PathVariable Long id, @RequestBody Estimatewithouttax estimateWithoutTax) {
        Estimatewithouttax updated = service.updateEstimateWithoutTax(id, estimateWithoutTax);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete an estimate without tax
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstimateWithoutTax(@PathVariable Long id) {
        if (service.deleteEstimateWithoutTax(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
