package com.sample.service;

import com.sample.entity.Invoice;
import com.sample.entity.Shipmenttracking;
import com.sample.repository.InvoiceRepository;
import com.sample.repository.ShipmenttrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmenttrackingService {

    @Autowired
    private ShipmenttrackingRepository shipmenttrackingRepository;
    
    @Autowired
    private InvoiceRepository invoiceRepository;

    // Create or Update
    public Shipmenttracking saveShipmenttracking(Shipmenttracking shipmenttracking) {
        return shipmenttrackingRepository.save(shipmenttracking);
    }

    // Get All
    public List<Shipmenttracking> getAllShipmenttrackings() {
        return shipmenttrackingRepository.findAll();
    }

    // Get by ID
    public Optional<Shipmenttracking> getShipmenttrackingById(Long id) {
        return shipmenttrackingRepository.findById(id);
    }

    // Delete by ID
    public void deleteShipmenttracking(Long id) {
        shipmenttrackingRepository.deleteById(id);
    }

 
    
    
}
