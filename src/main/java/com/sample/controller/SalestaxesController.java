//package com.sample.controller;
//
//import com.sample.entity.Salestaxes;
//import com.sample.service.SalestaxesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/salestaxes")
//public class SalestaxesController {
//
//    @Autowired
//    private SalestaxesService salestaxesService;
//
//    // GET all sales taxes
//    @GetMapping("/getallsalestaxes")
//    public List<Salestaxes> getAllTaxes() {
//        return salestaxesService.getAllTaxes();
//    }
//
//    // GET sales tax by id
//    @GetMapping("/getsalestaxesbyid/{id}")
//    public ResponseEntity<Salestaxes> getTaxById(@PathVariable Long id) {
//        Optional<Salestaxes> tax = salestaxesService.getTaxById(id);
//        return tax.map(ResponseEntity::ok)
//                  .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // POST to add a new sales tax
//    @PostMapping("/addsalestaxes")
//    public Salestaxes createTax(@RequestBody Salestaxes salestaxes) {
//        return salestaxesService.saveTax(salestaxes);
//    }
//
//    // PUT to update an existing sales tax
//    @PutMapping("/updateallsalestaxes/{id}")
//    public ResponseEntity<Salestaxes> updateTax(@PathVariable Long id, @RequestBody Salestaxes salestaxes) {
//        Salestaxes updatedTax = salestaxesService.updateTax(id, salestaxes);
//        if (updatedTax != null) {
//            return ResponseEntity.ok(updatedTax);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // DELETE a sales tax by id
//    @DeleteMapping("/deletesalestaxes/{id}")
//    public ResponseEntity<Void> deleteTax(@PathVariable Long id) {
//        salestaxesService.deleteTax(id);
//        return ResponseEntity.noContent().build();
//    }
//    
//    @GetMapping("/findsalestax/{city}/{state}")
//    public ResponseEntity<String> getSalesTax(@PathVariable String city, @PathVariable String state) {
//        String tax = salestaxesService.getSalesTaxByCityAndState(city, state);
//        return ResponseEntity.ok(tax);
//    }
//}









package com.sample.controller;

import com.sample.entity.Products;
import com.sample.entity.Salestaxes;
import com.sample.service.SalestaxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/salestaxes")
public class SalestaxesController {

    @Autowired
    private SalestaxesService salestaxesService;

    // POST to get all sales taxes
    @PostMapping("/getallsalestaxes")
    public ResponseEntity<List<Salestaxes>> getAllTaxes() {
        List<Salestaxes> taxes = salestaxesService.getAllTaxes();
        return ResponseEntity.ok(taxes);
    }

    // POST to get sales tax by id
    @PostMapping("/getsalestaxesbyid")
    public ResponseEntity<Salestaxes> getTaxById(@RequestBody Map<String, Long> request) {
        Long id = request.get("id");
        Optional<Salestaxes> tax = salestaxesService.getTaxById(id);
        return tax.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST to add a new sales tax
    @PostMapping("/addsalestaxes")
    public ResponseEntity<Salestaxes> createTax(@RequestBody Salestaxes salestaxes) {
        Salestaxes createdTax = salestaxesService.saveTax(salestaxes);
        return ResponseEntity.ok(createdTax);
    }

    // POST to update an existing sales tax
 // POST to update an existing sales tax
    @PostMapping("/updatesalestaxes/{id}")
    public ResponseEntity<String> updateSalestaxes(@RequestBody Salestaxes salestaxes, @PathVariable Long id) {
        Salestaxes updatedTax = salestaxesService.updateTax(id, salestaxes);
        if (updatedTax != null) {
            return new ResponseEntity<>("Salestaxes updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Salestaxes not found", HttpStatus.NOT_FOUND);
        }
    }

    
 // POST to delete a sales tax by id
    @PostMapping("/deletesalestaxes")
    public ResponseEntity<Void> deleteTax(@RequestBody Map<String, Long> request) {
        Long id = request.get("id");
        salestaxesService.deleteTax(id);
        return ResponseEntity.noContent().build();
    }

    // POST to find sales tax by city and state
    @PostMapping("/findsalestax")
    public ResponseEntity<String> getSalesTax(@RequestBody Map<String, String> request) {
        String city = request.get("city");
        String state = request.get("state");
        String tax = salestaxesService.getSalesTaxByCityAndState(city, state);
        return ResponseEntity.ok(tax);
    }
}
