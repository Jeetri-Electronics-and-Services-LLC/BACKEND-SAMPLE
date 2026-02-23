//package com.sample.controller;
//
//import com.sample.entity.Userstatus;
//import com.sample.service.UserstatusService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/userstatus")
//public class UserstatusController {
//
//    @Autowired
//    private UserstatusService userstatusService;
//
//    // Create Userstatus
//    @PostMapping
//    public ResponseEntity<Userstatus> createUserstatus(@RequestBody Userstatus userstatus) {
//        Userstatus savedUserstatus = userstatusService.createUserstatus(userstatus);
//        return new ResponseEntity<>(savedUserstatus, HttpStatus.CREATED);
//    }
//
//    // Update Userstatus
//    @PutMapping("/{id}")
//    public ResponseEntity<Userstatus> updateUserstatus(@PathVariable Long id, @RequestBody Userstatus userstatus) {
//        Userstatus updatedUserstatus = userstatusService.updateUserstatus(id, userstatus);
//        return updatedUserstatus != null ? new ResponseEntity<>(updatedUserstatus, HttpStatus.OK) :
//                new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    // Get all Userstatuses
//    @GetMapping
//    public ResponseEntity<List<Userstatus>> getAllUserstatuses() {
//        List<Userstatus> userstatuses = userstatusService.getAllUserstatuses();
//        return new ResponseEntity<>(userstatuses, HttpStatus.OK);
//    }
//
//    // Get Userstatus by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Userstatus> getUserstatusById(@PathVariable Long id) {
//        Optional<Userstatus> userstatus = userstatusService.getUserstatusById(id);
//        return userstatus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // Delete Userstatus by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUserstatus(@PathVariable Long id) {
//        userstatusService.deleteUserstatus(id);
//        return ResponseEntity.noContent().build();
//    }
//}








package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Userstatus;
import com.sample.service.UserstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/userstatus")
public class UserstatusController {

    @Autowired
    private UserstatusService userstatusService;

    // Create Userstatus (POST request)
    @PostMapping("/createuserstatus")
    public ResponseEntity<Userstatus> createUserstatus(@RequestBody Userstatus userstatus) {
        Userstatus savedUserstatus = userstatusService.createUserstatus(userstatus);
        return new ResponseEntity<>(savedUserstatus, HttpStatus.CREATED);
    }

    // Update Userstatus (POST request)
    @PostMapping("/updateUserstatus/{id}")
    public ResponseEntity<Userstatus> updateUserstatus(@PathVariable Long id, @RequestBody Userstatus userstatus) {
        Userstatus updatedUserstatus = userstatusService.updateUserstatus(id, userstatus);
        return updatedUserstatus != null ? new ResponseEntity<>(updatedUserstatus, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


   
 // Get all Userstatuses 
    @PostMapping("/getallUserstatuses")
    public ResponseEntity<List<Userstatus>> getAllUserstatuses() {
        List<Userstatus> userstatuses = userstatusService.getAllUserstatuses();
        return new ResponseEntity<>(userstatuses, HttpStatus.OK);
    }

    // Get Userstatus by ID (POST request)
    @PostMapping("/getByIdUserstatus")
    public ResponseEntity<Userstatus> getUserstatusById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	return userstatusService.getUserstatusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   

    // Delete Userstatus by ID (POST request)
    @PostMapping("/deleteUserstatus")
    public ResponseEntity<String> deleteUserstatus(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	userstatusService.deleteUserstatus(id);
    	return new ResponseEntity<>("Userstatus deleted successfully", HttpStatus.OK);
    }
   
}
