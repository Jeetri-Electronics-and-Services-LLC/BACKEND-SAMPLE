//package com.sample.controller;
//
//import com.sample.entity.RecentDescriptionDTO;
//import com.sample.entity.Termsandconditions;
//import com.sample.service.TermsandconditionsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/termsandconditions")
//public class TermsandconditionsController {
//
//    @Autowired
//    private TermsandconditionsService termsandconditionsService;
//
//    @GetMapping("/getalltermsandconditions")
//    public List<Termsandconditions> getAllTermsandconditions() {
//        return termsandconditionsService.getAllTermsandconditions();
//    }
//
//    @GetMapping("/gettermsandconditionsbyid/{id}")
//    public ResponseEntity<Termsandconditions> getTermsandconditionsById(@PathVariable Long id) {
//        return termsandconditionsService.getTermsandconditionsById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addtermsandconditions")
//    public Termsandconditions createTermsandconditions(@RequestBody Termsandconditions termsandconditions) {
//        return termsandconditionsService.createTermsandconditions(termsandconditions);
//    }
//
//    @PutMapping("/updatetermsandconditions/{id}")
//    public ResponseEntity<Termsandconditions> updateTermsandconditions(@PathVariable Long id, @RequestBody Termsandconditions termsandconditions) {
//        try {
//            Termsandconditions updated = termsandconditionsService.updateTermsandconditions(id, termsandconditions);
//            return ResponseEntity.ok(updated);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/deletetermsandconditions/{id}")
//    public ResponseEntity<Void> deleteTermsandconditions(@PathVariable Long id) {
//        termsandconditionsService.deleteTermsandconditions(id);
//        return ResponseEntity.noContent().build();
//    }
//    
       //display latest description
//    @GetMapping("/recent-description")
//    public ResponseEntity<RecentDescriptionDTO> getMostRecentDescription() {
//        RecentDescriptionDTO dto = termsandconditionsService.getMostRecentDescription();
//        if (dto == null) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(dto);
//    }
//}

package com.sample.controller;


import com.sample.entity.City;
import com.sample.entity.RecentDescriptionDTO;
import com.sample.entity.Termsandconditions;
import com.sample.service.TermsandconditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/termsandconditions")
public class TermsandconditionsController {

    @Autowired
    private TermsandconditionsService termsandconditionsService;

    @PostMapping("/getalltermsandconditions")
    public ResponseEntity<List<Termsandconditions>> getAllTermsandconditions() {
        List<Termsandconditions> terms = termsandconditionsService.getAllTermsandconditions();
        return ResponseEntity.ok(terms);
    }

    @PostMapping("/get-by-id-termsandconditions")
    public ResponseEntity<Termsandconditions> getTermsandconditionsById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return termsandconditionsService.getTermsandconditionsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    @PostMapping("/addtermsandconditions")
    public ResponseEntity<Termsandconditions> createTermsandconditions(@RequestBody Termsandconditions termsandconditions) {
        Termsandconditions created = termsandconditionsService.createTermsandconditions(termsandconditions);
        return ResponseEntity.ok(created);
    }

    @PostMapping("/updatetermsandconditions/{id}")
    public ResponseEntity<Termsandconditions> updateTermsandconditions(
            @PathVariable Long id, @RequestBody Termsandconditions termsandconditions) {
        try {
            termsandconditions.setId(id); // Ensure the ID in the path matches the entity
            Termsandconditions updated = termsandconditionsService.updateTermsandconditions(id, termsandconditions);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/deletetermsandconditions")
    public ResponseEntity<String> deleteTermsandconditions(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        termsandconditionsService.deleteTermsandconditions(id);
        return new ResponseEntity<>("Termsandconditions deleted successfully", HttpStatus.OK);
    }
   
   //display recent/latest description
    @PostMapping("/get-recent-description")
    public ResponseEntity<RecentDescriptionDTO> getMostRecentDescription() {
        RecentDescriptionDTO dto = termsandconditionsService.getMostRecentDescription();
        if (dto == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dto);
    }
}

