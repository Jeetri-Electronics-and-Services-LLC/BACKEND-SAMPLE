//package com.sample.controller;
//
//import com.sample.entity.Franchiseowner;
//import com.sample.service.FranchiseownerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/franchiseowners")
//public class FranchiseownerController {
//
//    @Autowired
//    private FranchiseownerService franchiseownerService;
//
//    @GetMapping("/getallfranchise")
//    public List<Franchiseowner> getAllFranchiseowners() {
//        return franchiseownerService.getAllFranchiseowners();
//    }
//
//    @GetMapping("/getfranchise/{id}")
//    public ResponseEntity<Franchiseowner> getFranchiseownerById(@PathVariable Long id) {
//        Optional<Franchiseowner> franchiseowner = franchiseownerService.getFranchiseownerById(id);
//        return franchiseowner.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addallfranchise")
//    public ResponseEntity<Franchiseowner> createFranchiseowner(@RequestBody Franchiseowner franchiseowner) {
//        Franchiseowner savedFranchiseowner = franchiseownerService.saveFranchiseowner(franchiseowner);
//        return new ResponseEntity<>(savedFranchiseowner, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/updatefranchise/{id}")
//    public ResponseEntity<Franchiseowner> updateFranchiseowner(@PathVariable Long id, @RequestBody Franchiseowner franchiseowner) {
//        Franchiseowner updatedFranchiseowner = franchiseownerService.updateFranchiseowner(id, franchiseowner);
//        return ResponseEntity.ok(updatedFranchiseowner);
//    }
//
//    @DeleteMapping("/deletefranchies/{id}")
//    public ResponseEntity<Void> deleteFranchiseowner(@PathVariable Long id) {
//        franchiseownerService.deleteFranchiseowner(id);
//        return ResponseEntity.noContent().build();
//    }
//}









package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Franchiseowner;
import com.sample.service.FranchiseownerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/franchiseowners")
public class FranchiseownerController {

    @Autowired
    private FranchiseownerService franchiseownerService;

    @PostMapping("/getallfranchise")
    public ResponseEntity<List<Franchiseowner>> getAllFranchiseowners(@RequestBody(required = false) Map<String, Object> request) {
        List<Franchiseowner> franchiseowners = franchiseownerService.getAllFranchiseowners();
        return new ResponseEntity<>(franchiseowners, HttpStatus.OK);
    }
    
   
    @PostMapping("/getfranchise")
    public ResponseEntity<Franchiseowner> getFranchiseownerById(@RequestBody Map<String, Object> request) {
    	 Long id = Long.parseLong(request.get("id").toString());
        return franchiseownerService.getFranchiseownerById(id)
        		.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    

    @PostMapping("/addallfranchise")
    public ResponseEntity<Franchiseowner> createFranchiseowner(@RequestBody Franchiseowner franchiseowner) {
        Franchiseowner savedFranchiseowner = franchiseownerService.saveFranchiseowner(franchiseowner);
        return new ResponseEntity<>(savedFranchiseowner, HttpStatus.CREATED);
    }

    @PostMapping("/updatefranchise/{id}")
    public ResponseEntity<Franchiseowner> updateFranchiseowner(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	String name = request.get("name").toString();
        Franchiseowner existingFranchiseowner = franchiseownerService.getFranchiseownerById(id).orElse(null);
        if (existingFranchiseowner == null) {
            return ResponseEntity.notFound().build();
        }
        
        existingFranchiseowner.setName(name);
        Franchiseowner updatedFranchiseowner = franchiseownerService.updateFranchiseowner(id, existingFranchiseowner);
        return ResponseEntity.ok(updatedFranchiseowner);
    }
   

    @PostMapping("/deletefranchies")
    public ResponseEntity<Void> deleteFranchiseowner(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	franchiseownerService.deleteFranchiseowner(id);
        return ResponseEntity.noContent().build();
    }
   
}

