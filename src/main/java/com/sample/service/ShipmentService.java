package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Inventoryquantity;
import com.sample.entity.Invoice;
import com.sample.entity.Shipment;
import com.sample.entity.User;
import com.sample.repository.InventoryquantityRepository;
import com.sample.repository.InvoiceRepository;
import com.sample.repository.ShipmentRepository;
import com.sample.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private InvoiceRepository invoiceRepository;
    
    @Autowired
    private InventoryquantityRepository repository;

   

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Optional<Shipment> getShipmentById(Long id) {
        return shipmentRepository.findById(id);
    }

    public Shipment saveShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }
    
//  //add shipmentdetails based on userid & invoiceid
//    public Shipment addShipment(Long userId, Long invoiceId, Shipment shipment) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceId);
//
//        if (userOptional.isEmpty() || invoiceOptional.isEmpty()) {
//            throw new IllegalArgumentException("Invalid User ID or Invoice ID");
//        }
//
//        shipment.setUser(userOptional.get());
//        shipment.setInvoice(invoiceOptional.get());
//
//        return shipmentRepository.save(shipment);
//    }
    
    public Shipment addShipment(Long userId, Long invoiceId, Shipment shipment) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceId);

        if (userOptional.isEmpty() || invoiceOptional.isEmpty()) {
            throw new IllegalArgumentException("Invalid User ID or Invoice ID");
        }

        shipment.setUser(userOptional.get());
        shipment.setInvoice(invoiceOptional.get());

        // Deduct shipment quantity from inventory
        Long productId = Long.parseLong(shipment.getProductid());
        Optional<Inventoryquantity> inventoryOptional = repository.findById(productId);

        if (inventoryOptional.isPresent()) {
            Inventoryquantity inventory = inventoryOptional.get();
            
            int shipmentQty = Integer.parseInt(shipment.getShipmentquantity());
            int availableQty = Integer.parseInt(inventory.getTotalavailablequantity());

            if (availableQty >= shipmentQty) {
                int updatedQty = availableQty - shipmentQty;
                inventory.setTotalavailablequantity(String.valueOf(updatedQty)); // Convert back to String
                repository.save(inventory);
            } else {
                throw new IllegalArgumentException("Not enough inventory available for product ID: " + productId);
            }
        } else {
            throw new IllegalArgumentException("Inventory record not found for product ID: " + productId);
        }

        return shipmentRepository.save(shipment);
    }
}
