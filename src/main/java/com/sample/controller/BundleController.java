package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.Bundle;
import com.sample.service.BundleService;

@RestController
@RequestMapping("/bundles")
public class BundleController {

    @Autowired
    private BundleService bundleService;
    

  @GetMapping("/getbundle")
  public List<Bundle> getAllBundleData() {
    return bundleService.getAllBundles();
  }

    @PostMapping("/addbundle")
    public ResponseEntity<Bundle> addBundle(@RequestBody Bundle bundle) {
        try {
            Bundle savedBundle = bundleService.saveBundle(bundle);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBundle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updatebundle/{id}")
    public ResponseEntity<Bundle> updateBundle(@PathVariable Long id, @RequestBody Bundle bundle) {
        try {
            Bundle updatedBundle = bundleService.updateBundle(id, bundle);
            return ResponseEntity.ok(updatedBundle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}



