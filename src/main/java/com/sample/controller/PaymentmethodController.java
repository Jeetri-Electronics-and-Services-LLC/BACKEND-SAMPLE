//package com.sample.controller;
//
//import com.sample.entity.Paymentmethod;
//import com.sample.service.PaymentmethodService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/paymentmethods")
//public class PaymentmethodController {
//
//    @Autowired
//    private PaymentmethodService paymentmethodService;
//
//    // Create a new payment method
//    @PostMapping("/addpaymentmethods")
//    public ResponseEntity<Paymentmethod> createPaymentMethod(@RequestBody Paymentmethod paymentmethod) {
//        return ResponseEntity.ok(paymentmethodService.createPaymentMethod(paymentmethod));
//    }
//
//    // Get all payment methods
//    @GetMapping("/getallpaymentmethods")
//    public ResponseEntity<List<Paymentmethod>> getAllPaymentMethods() {
//        return ResponseEntity.ok(paymentmethodService.getAllPaymentMethods());
//    }
//
//    // Get a payment method by ID
//    @GetMapping("/getpaymentmethodsbyid/{id}")
//    public ResponseEntity<Paymentmethod> getPaymentMethodById(@PathVariable Long id) {
//        return paymentmethodService.getPaymentMethodById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // Update a payment method
//    @PutMapping("/updatepaymentmethods/{id}")
//    public ResponseEntity<Paymentmethod> updatePaymentMethod(
//            @PathVariable Long id,
//            @RequestBody Paymentmethod paymentmethodDetails) {
//        return ResponseEntity.ok(paymentmethodService.updatePaymentMethod(id, paymentmethodDetails));
//    }
//
//    // Delete a payment method
//    @DeleteMapping("/deletepaymentmethods/{id}")
//    public ResponseEntity<Void> deletePaymentMethod(@PathVariable Long id) {
//        paymentmethodService.deletePaymentMethod(id);
//        return ResponseEntity.noContent().build();
//    }
//}












package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Paymentmethod;
import com.sample.service.PaymentmethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paymentmethods")
public class PaymentmethodController {

    @Autowired
    private PaymentmethodService paymentmethodService;

    // Create a new payment method
    @PostMapping("/addpaymentmethods")
    public ResponseEntity<Paymentmethod> createPaymentMethod(@RequestBody Paymentmethod paymentmethod) {
        return ResponseEntity.ok(paymentmethodService.createPaymentMethod(paymentmethod));
    }

    // post all payment methods
    @PostMapping("/getallpaymentmethods")
    public ResponseEntity<List<Paymentmethod>> getAllPaymentMethods(@RequestBody(required = false) Map<String, Object> request) {
    	List<Paymentmethod> paymentmethods = paymentmethodService.getAllPaymentMethods();
        return ResponseEntity.ok(paymentmethods);
    }
    
    

    // post a payment method by ID
    @PostMapping("/getpaymentmethodsbyid")
    public ResponseEntity<Paymentmethod> getPaymentMethodById(@RequestBody Map<String, Object> request) {
    	 Long id = Long.parseLong(request.get("id").toString());
         return paymentmethodService.getPaymentMethodById(id)
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
    }
    
    
   
    // Update a payment method
    @PostMapping("/updatepaymentmethods/{id}")
    public ResponseEntity<Paymentmethod> updatePaymentMethod(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	// Extract name from request body
        String name = request.get("name").toString();

        // Retrieve the existing city and update its name
        Paymentmethod existingPaymentmethod = paymentmethodService.getPaymentMethodById(id).orElse(null);
        if (existingPaymentmethod == null) {
            return ResponseEntity.notFound().build();
        }

        existingPaymentmethod.setName(name);
        Paymentmethod updatedPaymentmethod = paymentmethodService.updatePaymentMethod(id, existingPaymentmethod);

        return ResponseEntity.ok(updatedPaymentmethod);
    }
    
    // Delete a payment method
    @PostMapping("/deletepaymentmethods")
    public ResponseEntity<Void> deletePaymentMethod(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	paymentmethodService.deletePaymentMethod(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
