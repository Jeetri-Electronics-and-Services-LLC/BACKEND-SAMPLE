package com.sample.controller;

import com.sample.entity.Shipmenttracking;
import com.sample.service.ShipmenttrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipmenttracking")
public class ShipmenttrackingController {

    @Autowired
    private ShipmenttrackingService shipmenttrackingService;

    // Create or Update Shipmenttracking
    @PostMapping
    public ResponseEntity<Shipmenttracking> createOrUpdateShipmenttracking(@RequestBody Shipmenttracking shipmenttracking) {
        Shipmenttracking savedShipmenttracking = shipmenttrackingService.saveShipmenttracking(shipmenttracking);
        return new ResponseEntity<>(savedShipmenttracking, HttpStatus.CREATED);
    }

    // Get All Shipmenttrackings
    @GetMapping
    public ResponseEntity<List<Shipmenttracking>> getAllShipmenttrackings() {
        List<Shipmenttracking> shipmenttrackings = shipmenttrackingService.getAllShipmenttrackings();
        return new ResponseEntity<>(shipmenttrackings, HttpStatus.OK);
    }

    // Get Shipmenttracking by ID
    @GetMapping("/{id}")
    public ResponseEntity<Shipmenttracking> getShipmenttrackingById(@PathVariable Long id) {
        Optional<Shipmenttracking> shipmenttracking = shipmenttrackingService.getShipmenttrackingById(id);
        if (shipmenttracking.isPresent()) {
            return new ResponseEntity<>(shipmenttracking.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Shipmenttracking by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipmenttracking(@PathVariable Long id) {
        shipmenttrackingService.deleteShipmenttracking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
}
