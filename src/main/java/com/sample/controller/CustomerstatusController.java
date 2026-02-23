//package com.sample.controller;
//
//import com.sample.entity.Customerstatus;
//import com.sample.service.CustomerstatusService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/customerstatus")
//public class CustomerstatusController {
//
//    @Autowired
//    private CustomerstatusService service;
//
//    @PostMapping
//    public ResponseEntity<Customerstatus> addCustomerstatus(@RequestBody Customerstatus customerstatus) {
//        Customerstatus createdCustomerstatus = service.addCustomerstatus(customerstatus);
//        return ResponseEntity.ok(createdCustomerstatus);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Customerstatus>> getAllCustomerstatuses() {
//        List<Customerstatus> customerstatuses = service.getAllCustomerstatuses();
//        return ResponseEntity.ok(customerstatuses);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Customerstatus> getCustomerstatusById(@PathVariable Long id) {
//        Customerstatus customerstatus = service.getCustomerstatusById(id);
//        return ResponseEntity.ok(customerstatus);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Customerstatus> updateCustomerstatus(
//            @PathVariable Long id,
//            @RequestBody Customerstatus customerstatus) {
//        Customerstatus updatedCustomerstatus = service.updateCustomerstatus(id, customerstatus);
//        return ResponseEntity.ok(updatedCustomerstatus);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteCustomerstatus(@PathVariable Long id) {
//        service.deleteCustomerstatus(id);
//        return ResponseEntity.ok("Customerstatus deleted successfully with id: " + id);
//    }
//}






package com.sample.controller;

import com.sample.entity.Customerstatus;
import com.sample.entity.ExpenseDTO1;
import com.sample.service.CustomerstatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customerstatus")
public class CustomerstatusController {

    @Autowired
    private CustomerstatusService service;

    // Add a new customer status
    @PostMapping("/addcustomerstatus")
    public ResponseEntity<Customerstatus> addCustomerstatus(@RequestBody Customerstatus customerstatus) {
        Customerstatus createdCustomerstatus = service.addCustomerstatus(customerstatus);
        return ResponseEntity.ok(createdCustomerstatus);
    }

    // Fetch all customer statuses
    @PostMapping("/getAllcustomerstatus")
    public ResponseEntity<List<Customerstatus>> getAllCustomerstatuses() {
        List<Customerstatus> customerstatuses = service.getAllCustomerstatuses();
        return ResponseEntity.ok(customerstatuses);
    }

    // Fetch a customer status by ID
    @PostMapping("/getByIdcustomerstatus")
    public ResponseEntity<Customerstatus> getCustomerstatusById(@RequestBody Map<String, Long> requestBody) {
    	try {
            Long id = requestBody.get("id");
            Customerstatus customerstatus = service.getCustomerstatusById(id);
            return ResponseEntity.ok(customerstatus);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
        
    }
    

    // Update a customer status (ID in URL)
    @PostMapping("/updatecustomerstatus/{id}")
    public ResponseEntity<Customerstatus> updateCustomerstatus(
            @PathVariable Long id,
            @RequestBody Customerstatus customerstatus) {
        Customerstatus updatedCustomerstatus = service.updateCustomerstatus(id, customerstatus);
        return ResponseEntity.ok(updatedCustomerstatus);
    }

    // Delete a customer status (ID in JSON)
    @PostMapping("/deletecustomerstatusbyid")
    public ResponseEntity<String> deleteCustomerstatus(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        service.deleteCustomerstatus(id);
        return ResponseEntity.ok("Customerstatus deleted successfully with id: " + id);
    }
    
       
}

