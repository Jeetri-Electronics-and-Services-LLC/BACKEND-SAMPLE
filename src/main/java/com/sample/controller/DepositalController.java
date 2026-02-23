//package com.sample.controller;
//
//import com.sample.entity.Deposital;
//import com.sample.service.DepositalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/depositals")
//public class DepositalController {
//
//    @Autowired
//    private DepositalService depositalService;
//
//    // Create or update a Deposital
//    @PostMapping("/adddepositals")
//    public ResponseEntity<Deposital> createDeposital(@RequestBody Deposital deposital) {
//        Deposital savedDeposital = depositalService.saveDeposital(deposital);
//        return ResponseEntity.ok(savedDeposital);
//    }
//
//    // Get all Depositals
//    @GetMapping("/getalldepositals")
//    public ResponseEntity<List<Deposital>> getAllDepositals() {
//        List<Deposital> depositals = depositalService.getAllDepositals();
//        return ResponseEntity.ok(depositals);
//    }
//
//    // Get a specific Deposital by ID
//    @GetMapping("/getdepositalsbyid/{id}")
//    public ResponseEntity<Deposital> getDepositalById(@PathVariable Long id) {
//        Optional<Deposital> deposital = depositalService.getDepositalById(id);
//        if (deposital.isPresent()) {
//            return ResponseEntity.ok(deposital.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Delete a Deposital by ID
//    @DeleteMapping("/deletedepositals/{id}")
//    public ResponseEntity<Void> deleteDepositalById(@PathVariable Long id) {
//        depositalService.deleteDepositalById(id);
//        return ResponseEntity.noContent().build();
//    }
//    
//    @PutMapping("/updatedeposital/{id}")
//    public ResponseEntity<Deposital> updateDeposital(@PathVariable Long id, @RequestBody Deposital updatedDeposital) {
//        try {
//            Deposital deposital = depositalService.updateDeposital(id, updatedDeposital);
//            return ResponseEntity.ok(deposital);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}






package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Deposital;
import com.sample.service.DepositalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/depositals")
public class DepositalController {

    @Autowired
    private DepositalService depositalService;

    // Create or update a Deposital
    @PostMapping("/adddepositals")
    public ResponseEntity<Deposital> createDeposital(@RequestBody Deposital deposital) {
        Deposital savedDeposital = depositalService.saveDeposital(deposital);
        return ResponseEntity.ok(savedDeposital);
    }

    // Get all Depositals (changed to POST)
    @PostMapping("/getalldepositals")
    public ResponseEntity<List<Deposital>> getAllDepositals() {
        List<Deposital> depositals = depositalService.getAllDepositals();
        return ResponseEntity.ok(depositals);
    }

    // Get a specific Deposital by ID (changed to POST)
    @PostMapping("/getdepositalsbyid")
    public ResponseEntity<Deposital> getDepositalById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return depositalService.getDepositalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   
    

    // Delete a Deposital by ID (changed to POST)
    @PostMapping("/deletedepositals")
    public ResponseEntity<Void> deleteDepositalById(@RequestBody  Map<String, Object> request) {
    	 Long id = Long.parseLong(request.get("id").toString());
        depositalService.deleteDepositalById(id);
        return ResponseEntity.noContent().build();
    }
 
    
    // Update a Deposital (changed to POST)
    @PostMapping("/updatedeposital/{id}")
    public ResponseEntity<Deposital> updateDeposital(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	// Extract name from request body
        String name = request.get("name").toString();

        // Retrieve the existing city and update its name
        Deposital existingDeposital = depositalService.getDepositalById(id).orElse(null);
        if (existingDeposital == null) {
            return ResponseEntity.notFound().build();
        }

        existingDeposital.setName(name);
        Deposital updatedDeposital = depositalService.updateDeposital(id, existingDeposital);

        return ResponseEntity.ok(updatedDeposital);
    }
    }
    
   




