//package com.sample.controller;
//
//import com.sample.entity.Terms;
//import com.sample.service.TermsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/terms")
//public class TermsController {
//
//    @Autowired
//    private TermsService termsService;
//
//    @GetMapping("/getallterms")
//    public List<Terms> getAllTerms() {
//        return termsService.getAllTerms();
//    }
//
//    @GetMapping("/getterms/{id}")
//    public ResponseEntity<Terms> getTermsById(@PathVariable Long id) {
//        Optional<Terms> terms = termsService.getTermsById(id);
//        return terms.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addterms")
//    public ResponseEntity<Terms> createTerms(@RequestBody Terms terms) {
//        Terms savedTerms = termsService.saveTerms(terms);
//        return new ResponseEntity<>(savedTerms, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/updateterms/{id}")
//    public ResponseEntity<Terms> updateTerms(@PathVariable Long id, @RequestBody Terms terms) {
//        Terms updatedTerms = termsService.updateTerms(id, terms);
//        return ResponseEntity.ok(updatedTerms);
//    }
//
//    @DeleteMapping("/deleteterms/{id}")
//    public ResponseEntity<Void> deleteTerms(@PathVariable Long id) {
//        termsService.deleteTerms(id);
//        return ResponseEntity.noContent().build();
//    }
//}










package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Terms;
import com.sample.service.TermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/terms")
public class TermsController {

    @Autowired
    private TermsService termsService;

    // Fetch all terms
    @PostMapping("/getallterms")
    public ResponseEntity<List<Terms>> getAllTerms() {
        List<Terms> termsList = termsService.getAllTerms();
        return new ResponseEntity<>(termsList, HttpStatus.OK);
    }

    // Fetch terms by ID
    @PostMapping("/gettermsbyid")
    public ResponseEntity<Terms> getTermsById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return termsService.getTermsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   
    // Create a new term
    @PostMapping("/addterms")
    public ResponseEntity<Terms> createTerms(@RequestBody Terms terms) {
        Terms savedTerms = termsService.saveTerms(terms);
        return new ResponseEntity<>(savedTerms, HttpStatus.CREATED);
    }

    // Update an existing term
    @PostMapping("/updateterms/{id}")
    public ResponseEntity<Terms> updateTerms(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	 String name = request.get("name").toString();

         // Retrieve the existing city and update its name
    	 Terms existingTerms = termsService.getTermsById(id).orElse(null);
         if (existingTerms == null) {
             return ResponseEntity.notFound().build();
         }

         existingTerms.setName(name);
         Terms updatedTerms = termsService.updateTerms(id, existingTerms);

         return ResponseEntity.ok(updatedTerms);
    }
    


    // Delete a term
    @PostMapping("/deleteterms")
    public ResponseEntity<String> deleteTerms(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	termsService.deleteTerms(id);
        return new ResponseEntity<>("Terms deleted successfully", HttpStatus.OK);
    }

    
}

