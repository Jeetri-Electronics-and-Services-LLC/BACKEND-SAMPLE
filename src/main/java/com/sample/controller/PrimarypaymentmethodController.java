//package com.sample.controller;
//
//import com.sample.entity.Primarypaymentmethod;
//import com.sample.service.PrimarypaymentmethodService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/primarypaymentmethods")
//public class PrimarypaymentmethodController {
//
//    @Autowired
//    private PrimarypaymentmethodService primarypaymentmethodService;
//
//    @GetMapping("/getprimaryaall")
//    public List<Primarypaymentmethod> getAllPrimarypaymentmethods() {
//        return primarypaymentmethodService.getAllPrimarypaymentmethods();
//    }
//
//    @GetMapping("/getallprimary/{id}")
//    public ResponseEntity<Primarypaymentmethod> getPrimarypaymentmethodById(@PathVariable Long id) {
//        Optional<Primarypaymentmethod> primarypaymentmethod = primarypaymentmethodService.getPrimarypaymentmethodById(id);
//        return primarypaymentmethod.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addprimary")
//    public Primarypaymentmethod createPrimarypaymentmethod(@RequestBody Primarypaymentmethod primarypaymentmethod) {
//        return primarypaymentmethodService.savePrimarypaymentmethod(primarypaymentmethod);
//    }
//
//    @PutMapping("/updateprimary/{id}")
//    public ResponseEntity<Primarypaymentmethod> updatePrimarypaymentmethod(@PathVariable Long id, @RequestBody Primarypaymentmethod primarypaymentmethodDetails) {
//        try {
//            Primarypaymentmethod updatedPrimarypaymentmethod = primarypaymentmethodService.updatePrimarypaymentmethod(id, primarypaymentmethodDetails);
//            return ResponseEntity.ok(updatedPrimarypaymentmethod);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/deleteprimary/{id}")
//    public ResponseEntity<Void> deletePrimarypaymentmethod(@PathVariable Long id) {
//        try {
//            primarypaymentmethodService.deletePrimarypaymentmethod(id);
//            return ResponseEntity.noContent().build();
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}









package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Primarypaymentmethod;
import com.sample.service.PrimarypaymentmethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/primarypaymentmethods")
public class PrimarypaymentmethodController {

    @Autowired
    private PrimarypaymentmethodService primarypaymentmethodService;

    // Get all primary payment methods (via POST)
    @PostMapping("/getprimaryall")
    public ResponseEntity<List<Primarypaymentmethod>> getAllPrimarypaymentmethods() {
        List<Primarypaymentmethod> primarypaymentmethods = primarypaymentmethodService.getAllPrimarypaymentmethods();
        return ResponseEntity.ok(primarypaymentmethods);
    }

    // Get primary payment method by ID (via POST, pass ID in JSON request body)
    @PostMapping("/getprimarybyid")
    public ResponseEntity<Primarypaymentmethod> getPrimarypaymentmethodById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return primarypaymentmethodService.getPrimarypaymentmethodById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   

    // Add a new primary payment method (via POST)
    @PostMapping("/addprimary")
    public ResponseEntity<Primarypaymentmethod> createPrimarypaymentmethod(@RequestBody Primarypaymentmethod primarypaymentmethod) {
        Primarypaymentmethod createdPrimarypaymentmethod = primarypaymentmethodService.savePrimarypaymentmethod(primarypaymentmethod);
        return ResponseEntity.ok(createdPrimarypaymentmethod);
    }

    // Update primary payment method (via POST, pass ID and details in JSON request body)
    @PostMapping("/updateprimary/{id}")
    public ResponseEntity<Primarypaymentmethod> updatePrimarypaymentmethod(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	String name = request.get("name").toString();

        // Retrieve the existing city and update its name
    	Primarypaymentmethod existingPrimarypaymentmethod = primarypaymentmethodService.getPrimarypaymentmethodById(id).orElse(null);
        if (existingPrimarypaymentmethod == null) {
            return ResponseEntity.notFound().build();
        }

        existingPrimarypaymentmethod.setName(name);
        Primarypaymentmethod updatedPrimarypaymentmethod = primarypaymentmethodService.updatePrimarypaymentmethod(id, existingPrimarypaymentmethod);

        return ResponseEntity.ok(updatedPrimarypaymentmethod);
    }
    

    // Delete primary payment method by ID (via POST, pass ID in JSON request body)
    @PostMapping("/deleteprimary")
    public ResponseEntity<Void> deletePrimarypaymentmethod(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	primarypaymentmethodService.deletePrimarypaymentmethod(id);
        return ResponseEntity.noContent().build();
    }

    

}

