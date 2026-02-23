//package com.sample.controller;
//
//import com.sample.entity.Salesfromdeliveryoptions;
//import com.sample.service.SalesfromdeliveryoptionsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/salesfromdeliveryoptions")
//public class SalesfromdeliveryoptionsController {
//
//    @Autowired
//    private SalesfromdeliveryoptionsService salesfromdeliveryoptionsService;
//
//    @GetMapping("/getsalesall")
//    public List<Salesfromdeliveryoptions> getAllSalesfromdeliveryoptions() {
//        return salesfromdeliveryoptionsService.getAllSalesfromdeliveryoptions();
//    }
//
//    @GetMapping("/getsales/{id}")
//    public ResponseEntity<Salesfromdeliveryoptions> getSalesfromdeliveryoptionsById(@PathVariable Long id) {
//        Optional<Salesfromdeliveryoptions> salesfromdeliveryoptions = salesfromdeliveryoptionsService.getSalesfromdeliveryoptionsById(id);
//        return salesfromdeliveryoptions.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addsales")
//    public Salesfromdeliveryoptions createSalesfromdeliveryoptions(@RequestBody Salesfromdeliveryoptions salesfromdeliveryoptions) {
//        return salesfromdeliveryoptionsService.saveSalesfromdeliveryoptions(salesfromdeliveryoptions);
//    }
//
//    @PutMapping("/updatesales/{id}")
//    public ResponseEntity<Salesfromdeliveryoptions> updateSalesfromdeliveryoptions(@PathVariable Long id, @RequestBody Salesfromdeliveryoptions salesfromdeliveryoptionsDetails) {
//        try {
//            Salesfromdeliveryoptions updatedSalesfromdeliveryoptions = salesfromdeliveryoptionsService.updateSalesfromdeliveryoptions(id, salesfromdeliveryoptionsDetails);
//            return ResponseEntity.ok(updatedSalesfromdeliveryoptions);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/deletesales/{id}")
//    public ResponseEntity<Void> deleteSalesfromdeliveryoptions(@PathVariable Long id) {
//        try {
//            salesfromdeliveryoptionsService.deleteSalesfromdeliveryoptions(id);
//            return ResponseEntity.noContent().build();
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}








package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Salesfromdeliveryoptions;
import com.sample.service.SalesfromdeliveryoptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/salesfromdeliveryoptions")
public class SalesfromdeliveryoptionsController {

    @Autowired
    private SalesfromdeliveryoptionsService salesfromdeliveryoptionsService;

    @PostMapping("/getsalesall")
    public ResponseEntity<List<Salesfromdeliveryoptions>> getAllSalesfromdeliveryoptions() {
        List<Salesfromdeliveryoptions> salesOptions = salesfromdeliveryoptionsService.getAllSalesfromdeliveryoptions();
        return ResponseEntity.ok(salesOptions);
    }

    @PostMapping("/getsalesbyid")
    public ResponseEntity<Salesfromdeliveryoptions> getSalesfromdeliveryoptionsById(@RequestBody Map<String, Object> request) {
    	 Long id = Long.parseLong(request.get("id").toString());
        return salesfromdeliveryoptionsService.getSalesfromdeliveryoptionsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   

    @PostMapping("/addsales")
    public ResponseEntity<Salesfromdeliveryoptions> createSalesfromdeliveryoptions(@RequestBody Salesfromdeliveryoptions salesfromdeliveryoptions) {
        Salesfromdeliveryoptions createdSalesfromdeliveryoptions = salesfromdeliveryoptionsService.saveSalesfromdeliveryoptions(salesfromdeliveryoptions);
        return ResponseEntity.ok(createdSalesfromdeliveryoptions);
    }

    @PostMapping("/updatesales/{id}")
    public ResponseEntity<Salesfromdeliveryoptions> updateSalesfromdeliveryoptions(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	 String name = request.get("name").toString();

         // Retrieve the existing city and update its name
    	 Salesfromdeliveryoptions existingSalesfromdeliveryoptions = salesfromdeliveryoptionsService.getSalesfromdeliveryoptionsById(id).orElse(null);
         if (existingSalesfromdeliveryoptions == null) {
             return ResponseEntity.notFound().build();
         }

         existingSalesfromdeliveryoptions.setName(name);
         Salesfromdeliveryoptions updatedSalesfromdeliveryoptions = salesfromdeliveryoptionsService.updateSalesfromdeliveryoptions(id, existingSalesfromdeliveryoptions);

         return ResponseEntity.ok(updatedSalesfromdeliveryoptions);
    }
    

    @PostMapping("/deletesales")
    public ResponseEntity<Void> deleteSalesfromdeliveryoptions(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	salesfromdeliveryoptionsService.deleteSalesfromdeliveryoptions(id);
        return ResponseEntity.noContent().build();

    }
   
}
