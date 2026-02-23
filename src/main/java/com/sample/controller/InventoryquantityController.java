package com.sample.controller;

import com.sample.entity.InventoryQuantityDTO;
import com.sample.entity.InventoryQuantityDTO1;
import com.sample.entity.Inventoryquantity;
import com.sample.service.InventoryquantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventoryquantities")
public class InventoryquantityController {

    @Autowired
    private InventoryquantityService service;

    @PostMapping
    public ResponseEntity<Inventoryquantity> createInventoryquantity(@RequestBody Inventoryquantity inventoryquantity) {
        Inventoryquantity created = service.createInventoryquantity(inventoryquantity);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<Inventoryquantity>> getAllInventoryquantities() {
        List<Inventoryquantity> inventoryList = service.getAllInventoryquantities();
        return ResponseEntity.ok(inventoryList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventoryquantity> getInventoryquantityById(@PathVariable("id") Long productid) {
        Optional<Inventoryquantity> inventory = service.getInventoryquantityById(productid);
        return inventory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventoryquantity> updateInventoryquantity(@PathVariable("id") Long productid, @RequestBody Inventoryquantity inventoryDetails) {
        Inventoryquantity updated = service.updateInventoryquantity(productid, inventoryDetails);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventoryquantity(@PathVariable("id") Long productid) {
        boolean deleted = service.deleteInventoryquantity(productid);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //Add IventoryQuantity Details Based on product Id and change the quantity value of createproducttable to totalavailablequantity value in inventotyquantitytable
    @PostMapping("/addinventoryquantity/{productid}")
    public ResponseEntity<String> addInventory(@PathVariable Long productid, @RequestBody InventoryQuantityDTO1 inventoryDTO1) {
        try {
            String response = service.addInventory(productid, inventoryDTO1);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    // display only particular fields in inventoryquantity(in fronteend table-inventoryquantityhistory)
    @PostMapping("/getInventoryQuantities")
    public List<InventoryQuantityDTO> getInventoryQuantities() {
        return service.getInventoryQuantities();
    }
}
