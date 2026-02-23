//package com.sample.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.sample.entity.Taxrates;
//import com.sample.service.TaxratesService;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/taxratess")
//public class TaxratesController {
//
//    @Autowired
//    private TaxratesService taxratesService;
//
//    @GetMapping("/getalltaxratess")
//    public List<Taxrates> getAllTaxrates() {
//        return taxratesService.findAll();
//    }
//
//    @GetMapping("/gettaxrates/{id}")
//    public ResponseEntity<Taxrates> getTaxrateById(@PathVariable Long id) {
//        Optional<Taxrates> taxrates = taxratesService.findById(id);
//        if (taxrates.isPresent()) {
//            return ResponseEntity.ok(taxrates.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("/addtaxratess")
//    public Taxrates createTaxrate(@RequestBody Taxrates taxrates) {
//        return taxratesService.save(taxrates);
//    }
//
//    @PutMapping("/updatetaxratess/{id}")
//    public ResponseEntity<Taxrates> updateTaxrate(@PathVariable Long id, @RequestBody Taxrates taxrateDetails) {
//        Optional<Taxrates> taxratesOptional = taxratesService.findById(id);
//        if (taxratesOptional.isPresent()) {
//            Taxrates taxrates = taxratesOptional.get();
//            taxrates.setName(taxrateDetails.getName());
//            taxrates.setPercentage(taxrateDetails.getPercentage());
//            return ResponseEntity.ok(taxratesService.save(taxrates));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/deletetaxratess/{id}")
//    public ResponseEntity<Void> deleteTaxrate(@PathVariable Long id) {
//        if (taxratesService.findById(id).isPresent()) {
//            taxratesService.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}











package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.City;
import com.sample.entity.Taxrates;
import com.sample.service.TaxratesService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/taxratess")
public class TaxratesController {

    @Autowired
    private TaxratesService taxratesService;

    // Use POST to fetch all tax rates
    @PostMapping("/getalltaxratess")
    public ResponseEntity<List<Taxrates>> getAllTaxrates() {
        List<Taxrates> taxratesList = taxratesService.findAll();
        return ResponseEntity.ok(taxratesList);
    }

    // Use POST to fetch tax rate by ID
    @PostMapping("/gettaxrates")
    public ResponseEntity<Taxrates> getTaxrateById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return taxratesService.findById(id) // Changed getTaxrateById to findById
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    // POST to create a new tax rate
    @PostMapping("/addtaxratess")
    public ResponseEntity<Taxrates> createTaxrate(@RequestBody Taxrates taxrates) {
        Taxrates createdTaxrate = taxratesService.save(taxrates);
        return ResponseEntity.ok(createdTaxrate);
    }

    // Use POST to update tax rates by ID
    @PostMapping("/updatetaxratess/{id}")
    public ResponseEntity<Taxrates> updateTaxrate(@PathVariable Long id, @RequestBody Taxrates taxrateDetails) {
        Optional<Taxrates> taxratesOptional = taxratesService.findById(id);
        if (taxratesOptional.isPresent()) {
            Taxrates taxrates = taxratesOptional.get();
            taxrates.setName(taxrateDetails.getName());
            taxrates.setPercentage(taxrateDetails.getPercentage());
            return ResponseEntity.ok(taxratesService.save(taxrates));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Use POST to delete a tax rate by ID
    @PostMapping("/deletetaxratess")
    public ResponseEntity<String> deleteTaxrates(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	taxratesService.deleteById(id);
        return new ResponseEntity<>("Taxrates deleted successfully", HttpStatus.OK);
}
   
}

