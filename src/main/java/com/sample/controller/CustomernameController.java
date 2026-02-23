package com.sample.controller;

import com.sample.entity.Customername;
import com.sample.service.CustomernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customernames")
public class CustomernameController {

    @Autowired
    private CustomernameService customernameService;

    @GetMapping("/getallcustomernames")
    public List<Customername> getAllCustomernames() {
        return customernameService.getAllCustomernames();
    }

    @GetMapping("/getcustomername/{id}")
    public ResponseEntity<Customername> getCustomernameById(@PathVariable Long id) {
        Optional<Customername> customername = customernameService.getCustomernameById(id);
        return customername.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addallcustomernames")
    public ResponseEntity<Customername> createCustomername(@RequestBody Customername customername) {
        Customername savedCustomername = customernameService.saveCustomername(customername);
        return new ResponseEntity<>(savedCustomername, HttpStatus.CREATED);
    }

    @PutMapping("/updateallcustomernames{id}")
    public ResponseEntity<Customername> updateCustomername(@PathVariable Long id, @RequestBody Customername customername) {
        Customername updatedCustomername = customernameService.updateCustomername(id, customername);
        return ResponseEntity.ok(updatedCustomername);
    }

    @DeleteMapping("/deleteallcustomernames/{id}")
    public ResponseEntity<Void> deleteCustomername(@PathVariable Long id) {
        customernameService.deleteCustomername(id);
        return ResponseEntity.noContent().build();
    }
}

