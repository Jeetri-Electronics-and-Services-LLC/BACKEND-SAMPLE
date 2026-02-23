//package com.sample.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.sample.entity.Customertype;
//import com.sample.service.CustomertypeService;
//import java.util.List;
//
//@RestController
//@RequestMapping("/customertypes")
//public class CustomertypeController {
//
//    @Autowired
//    private CustomertypeService customertypeService;
//
//    @GetMapping("/getallcustomertypes")
//    public List<Customertype> getAllCustomertypes() {
//        return customertypeService.getAllCustomertypes();
//    }
//
//    @GetMapping("/getcustomertype/{id}")
//    public ResponseEntity<Customertype> getCustomertypeById(@PathVariable Long id) {
//        return customertypeService.getCustomertypeById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addcustomertypes")
//    public Customertype addCustomertype(@RequestBody Customertype customertype) {
//        return customertypeService.addCustomertype(customertype);
//    }
//
//    @PutMapping("/updatecustomertype/{id}")
//    public ResponseEntity<Customertype> updateCustomertype(@PathVariable Long id, @RequestBody Customertype customertype) {
//        Customertype updatedCustomertype = customertypeService.updateCustomertype(id, customertype);
//        if (updatedCustomertype != null) {
//            return ResponseEntity.ok(updatedCustomertype);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/deletecustomertype/{id}")
//    public ResponseEntity<Void> deleteCustomertype(@PathVariable Long id) {
//        customertypeService.deleteCustomertype(id);
//        return ResponseEntity.noContent().build();
//    }
//}
//








package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.City;
import com.sample.entity.Customertype;
import com.sample.service.CustomertypeService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customertypes")
public class CustomertypeController {

    @Autowired
    private CustomertypeService customertypeService;

    // Change GET to POST for getting all customer types
    @PostMapping("/getallcustomertypes")
    public ResponseEntity<List<Customertype>> getAllCustomertypes(@RequestBody(required = false) Map<String, Object> request) {
        List<Customertype> customertypes = customertypeService.getAllCustomertypes();
        return ResponseEntity.ok(customertypes);
    }

   
    // Change GET to POST for getting a customer type by ID
    @PostMapping("/getcustomertypebyid")
    public ResponseEntity<Customertype> getCustomertypeById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return customertypeService.getCustomertypeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    

    // POST method to add a new customer type
    @PostMapping("/addcustomertypes")
    public ResponseEntity<Customertype> addCustomertype(@RequestBody Customertype customertype) {
        Customertype createdCustomertype = customertypeService.addCustomertype(customertype);
        return ResponseEntity.ok(createdCustomertype);
    }

    // POST method to update an existing customer type
    @PostMapping("/updatecustomertype/{id}")
    public ResponseEntity<Customertype> updateCustomertype(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        
    	String name = request.get("name").toString();
        Customertype existingCustomertype = customertypeService.getCustomertypeById(id).orElse(null);
        if (existingCustomertype == null) {
        	return ResponseEntity.notFound().build();
        } 
        
        existingCustomertype.setName(name);
        Customertype updatedCustomertype = customertypeService.updateCustomertype(id, existingCustomertype);

        return ResponseEntity.ok(updatedCustomertype);
    }
    
    

    // POST method to delete a customer type
    @PostMapping("/deletecustomertype")
    public ResponseEntity<Void> deleteCustomertype(@RequestBody Map<String, Object> request) {
    	 Long id = Long.parseLong(request.get("id").toString());
    	customertypeService.deleteCustomertype(id);
        return ResponseEntity.noContent().build();
    }
    
}

