package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sample.entity.Shipment;
import com.sample.service.ShipmentService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @GetMapping("/{id}")
    public Optional<Shipment> getShipmentById(@PathVariable Long id) {
        return shipmentService.getShipmentById(id);
    }

    @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return shipmentService.saveShipment(shipment);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }
    
    //add shipmentdetails based on userid & invoiceid
    @PostMapping("/basedoninvoiceaddshipment/{userId}/{invoiceId}")
    public ResponseEntity<Shipment> addShipment(
            @PathVariable Long userId, 
            @PathVariable Long invoiceId, 
            @RequestBody Shipment shipment) {
        
        Shipment savedShipment = shipmentService.addShipment(userId, invoiceId, shipment);
        return ResponseEntity.ok(savedShipment);
    }
}
