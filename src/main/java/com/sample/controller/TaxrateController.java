//package com.sample.controller;
//
//import com.sample.entity.Taxrate;
//import com.sample.service.TaxrateService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/taxrates")
//public class TaxrateController {
//
//    @Autowired
//    private TaxrateService taxrateService;
//
//    @GetMapping("/getalltaxrates")
//    public List<Taxrate> getAllTaxrates() {
//        return taxrateService.getAllTaxrates();
//    }
//
//    @GetMapping("/gettaxrate/{id}")
//    public ResponseEntity<Taxrate> getTaxrateById(@PathVariable Long id) {
//        Optional<Taxrate> taxrate = taxrateService.getTaxrateById(id);
//        return taxrate.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addtaxrate")
//    public Taxrate createTaxrate(@RequestBody Taxrate taxrate) {
//        return taxrateService.saveTaxrate(taxrate);
//    }
//
//    @PutMapping("/updatetaxrate/{id}")
//    public ResponseEntity<Taxrate> updateTaxrate(@PathVariable Long id, @RequestBody Taxrate taxrateDetails) {
//        try {
//            Taxrate updatedTaxrate = taxrateService.updateTaxrate(id, taxrateDetails);
//            return ResponseEntity.ok(updatedTaxrate);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/deletetaxrate/{id}")
//    public ResponseEntity<Void> deleteTaxrate(@PathVariable Long id) {
//        try {
//            taxrateService.deleteTaxrate(id);
//            return ResponseEntity.noContent().build();
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}







package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Taxrate;
import com.sample.service.TaxrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/taxrates")
public class TaxrateController {

    @Autowired
    private TaxrateService taxrateService;

    // Endpoint to get all tax rates
    @PostMapping("/getalltaxrates")
    public ResponseEntity<List<Taxrate>> getAllTaxrates() {
        List<Taxrate> taxrates = taxrateService.getAllTaxrates();
        return ResponseEntity.ok(taxrates);
    }

    // Endpoint to get a tax rate by ID
    @PostMapping("/gettaxrate")
    public ResponseEntity<Taxrate> getTaxrateById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return taxrateService.getTaxrateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   

    // Endpoint to add a new tax rate
    @PostMapping("/addtaxrate")
    public ResponseEntity<Taxrate> createTaxrate(@RequestBody Taxrate taxrate) {
        Taxrate createdTaxrate = taxrateService.saveTaxrate(taxrate);
        return ResponseEntity.ok(createdTaxrate);
    }

    // Endpoint to update an existing tax rate
    @PostMapping("/updatetaxrate/{id}")
    public ResponseEntity<Taxrate> updateTaxrate(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	String names = request.get("names").toString();

        // Retrieve the existing city and update its name
    	Taxrate existingTaxrate = taxrateService.getTaxrateById(id).orElse(null);
        if (existingTaxrate == null) {
            return ResponseEntity.notFound().build();
        }

        existingTaxrate.setNames(names);
        Taxrate updatedCity = taxrateService.updateTaxrate(id, existingTaxrate);

        return ResponseEntity.ok(updatedCity);
    }
    

    // Endpoint to delete a tax rate
    @PostMapping("/deletetaxrate")
    public ResponseEntity<String> deleteTaxrate(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	taxrateService.deleteTaxrate(id);
        return new ResponseEntity<>("Taxrate deleted successfully", HttpStatus.OK);
    }
    
    
    
    
    
}
