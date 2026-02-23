package com.sample.controller;

import com.sample.entity.Emailestimate;
import com.sample.entity.Estimate;
import com.sample.service.EmailestimateService;
import com.sample.service.EstimateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emailestimates")
public class EmailestimateController {

    @Autowired
    EmailestimateService emailestimateService;
    
    @Autowired
    private EstimateService estimateService;

    // Get all Emailestimates
    @GetMapping
    public List<Emailestimate> getAllEmailestimates() {
        return emailestimateService.getAllEmailestimates();
    }

    // Get Emailestimate by ID
    @GetMapping("/{id}")
    public ResponseEntity<Emailestimate> getEmailestimateById(@PathVariable Long id) {
        Optional<Emailestimate> emailestimate = emailestimateService.getEmailestimateById(id);
        return emailestimate.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or update an Emailestimate
    @PostMapping("/addestimateemail")
    public Emailestimate createEmailestimate(@RequestBody Emailestimate emailestimate) {
        return emailestimateService.saveEmailestimate(emailestimate);
    }

    // Delete an Emailestimate
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmailestimate(@PathVariable Long id) {
        emailestimateService.deleteEmailestimate(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/addemailestimate/{estimateId}")
    public Emailestimate createEmailEstimate(@PathVariable Long estimateId, @RequestBody Emailestimate emailEstimate) {
        return emailestimateService.createEmailEstimate(estimateId, emailEstimate);
    }
    
}
