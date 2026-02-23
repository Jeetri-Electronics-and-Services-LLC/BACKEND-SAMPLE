//package com.sample.controller;

//
//
//import com.sample.entity.ReceiptpaymentDTO;
//import com.sample.service.ReceiptpaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/receiptpayments")
//public class ReceiptpaymentController {
//
//    @Autowired
//    private ReceiptpaymentService receiptpaymentService;
//
//    // Get all Receiptpayments
//    @GetMapping("/getallreceiptpayments")
//    public List<ReceiptpaymentDTO> getAllReceiptpayments() {
//        return receiptpaymentService.getAllReceiptpayments();
//    }
//
//    // Get Receiptpayment by ID
//    @GetMapping("/getreceiptpaymentsbyid/{id}")
//    public ResponseEntity<ReceiptpaymentDTO> getReceiptpaymentById(@PathVariable Long id) {
//        return receiptpaymentService.getReceiptpaymentById(id)
//            .map(ResponseEntity::ok)
//            .orElse(ResponseEntity.notFound().build());
//    }
//
//    // Create new Receiptpayment
//    @PostMapping("/addreceiptpayments")
//    public ResponseEntity<ReceiptpaymentDTO> createReceiptpayment(@RequestBody ReceiptpaymentDTO receiptpaymentDTO) {
//        ReceiptpaymentDTO createdReceiptpayment = receiptpaymentService.createReceiptpayment(receiptpaymentDTO);
//        return ResponseEntity.status(201).body(createdReceiptpayment); // 201 Created
//    }
//
//    // Update existing Receiptpayment
//    @PutMapping("/updatereceiptpayments/{id}")
//    public ResponseEntity<ReceiptpaymentDTO> updateReceiptpayment(@PathVariable Long id, @RequestBody ReceiptpaymentDTO receiptpaymentDTO) {
//        return receiptpaymentService.updateReceiptpayment(id, receiptpaymentDTO)
//            .map(ResponseEntity::ok)
//            .orElse(ResponseEntity.notFound().build());
//    }
//
//    // Delete Receiptpayment
//    @DeleteMapping("/deletereceiptpayments/{id}")
//    public ResponseEntity<Void> deleteReceiptpayment(@PathVariable Long id) {
//        if (receiptpaymentService.deleteReceiptpayment(id)) {
//            return ResponseEntity.noContent().build(); // 204 No Content
//        } else {
//            return ResponseEntity.notFound().build(); // 404 Not Found
//        }
//    }
//// API to save Receiptpayment based on Invoice ID
// @PostMapping("/add/{invoiceId}")
//    public Receiptpayment addReceiptPayment(
//            @PathVariable Long invoiceId,
//            @RequestBody Receiptpayment receiptpayment) {
//        // Save Receiptpayment using service
//        return receiptpaymentService.saveReceiptPayment(invoiceId, receiptpayment);
//    }
//    
//    @GetMapping("/basedoninvoicedisplaylistRP/{invoiceId}")
//    public List<ReceiptpaymentDTOs> getReceiptpaymentsByInvoiceId(@PathVariable Long invoiceId) {
//        return receiptpaymentService.getReceiptpaymentsByInvoiceId(invoiceId);
//    }
//}



package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.CustomerDetailsDto;
import com.sample.entity.Invoice;
import com.sample.entity.ReceiptPaymentDTO3;
import com.sample.entity.ReceiptPaymentDTO4;
import com.sample.entity.Receiptpayment;
import com.sample.entity.ReceiptpaymentDTO;
import com.sample.entity.ReceiptpaymentDTO2;
import com.sample.entity.ReceiptpaymentDTOs;
import com.sample.service.ReceiptpaymentService;

import ch.qos.logback.core.model.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/receiptpayments")
public class ReceiptpaymentController {

    @Autowired
    private ReceiptpaymentService receiptpaymentService;

    // Get all Receiptpayments (Changed to POST)
    @PostMapping("/getallreceiptpayments")
    public ResponseEntity<List<ReceiptpaymentDTO>> getAllReceiptpayments() {
        List<ReceiptpaymentDTO> receiptpayments = receiptpaymentService.getAllReceiptpayments();
        return ResponseEntity.ok(receiptpayments);
    }

    // Post Receiptpayment by ID (Changed to POST)
    @PostMapping("/getreceiptpaymentsbyid")
    public ResponseEntity<ReceiptpaymentDTO> getReceiptpaymentById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return receiptpaymentService.getReceiptpaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
    

    // Create new Receiptpayment (Already POST)
    @PostMapping("/addreceiptpayments")
    public ResponseEntity<ReceiptpaymentDTO> createReceiptpayment(@RequestBody ReceiptpaymentDTO receiptpaymentDTO) {
        ReceiptpaymentDTO createdReceiptpayment = receiptpaymentService.createReceiptpayment(receiptpaymentDTO);
        return ResponseEntity.status(201).body(createdReceiptpayment); // 201 Created
    }

    // Update existing Receiptpayment (Changed to POST)

    @PostMapping("/updatereceipt/{id}")
    public ResponseEntity<Optional<ReceiptpaymentDTO>> updateReceiptpayment(
        @PathVariable Long id,
        @RequestBody ReceiptpaymentDTO receiptpaymentDTO
    ) {
        // Call the service to update the receipt payment
        Optional<ReceiptpaymentDTO> updatedReceiptpayment = receiptpaymentService.updateReceiptpayment(id, receiptpaymentDTO);
        
        // Return the updated receipt payment in response
        return ResponseEntity.ok(updatedReceiptpayment);
    }

 // Delete Receiptpayment (Changed to POST)
    @PostMapping("/deletereceiptpayments")
    public ResponseEntity<Void> deleteReceiptpayment(@RequestBody Map<String, Long> requestBody) {
    	 Long id = requestBody.get("id");
    	 receiptpaymentService.deleteReceiptpayment(id);
         return ResponseEntity.noContent().build();
     }
    
    //working // API to save Receiptpayment based on Invoice ID
//    @PostMapping("/add/{invoiceId}")
//    public Receiptpayment addReceiptPayment(
//            @PathVariable Long invoiceId,
//            @RequestBody Receiptpayment receiptpayment) {
//        // Save Receiptpayment using service
//        return receiptpaymentService.saveReceiptPayment(invoiceId, receiptpayment);
//    }
//    
    
 // API to save Receiptpayment based on Invoice ID
    @PostMapping("/add/{invoiceId}")
    public Receiptpayment addReceiptPayment(
            @PathVariable Long invoiceId,
            @RequestBody Receiptpayment receiptpayment) {
        // Save Receiptpayment using service
        return receiptpaymentService.saveReceiptPayment(invoiceId, receiptpayment);
    }
    
    @PostMapping("/basedoninvoicedisplaylistRP")
    public List<ReceiptpaymentDTOs> getReceiptpaymentsByInvoiceId(@RequestBody Map<String, Long> request) {
        Long invoiceId = request.get("invoiceId");
        return receiptpaymentService.getReceiptpaymentsByInvoiceId(invoiceId);
    }
    
    @PostMapping("/displayalllistofreceiptpayments")
    public ResponseEntity<List<ReceiptpaymentDTO2>> getAllReceiptPayments() {
        List<ReceiptpaymentDTO2> receiptPayments = receiptpaymentService.getAllReceiptPayments();
        return ResponseEntity.ok(receiptPayments);
    }
    
    @PostMapping("/displaylistofreceiptpaymentparticularfields")
    public List<ReceiptPaymentDTO3> getAllReceiptPayments1() {
        return receiptpaymentService.getAllReceiptPayments1();
    }
    
    
    @PostMapping("/sumofallreceiptpaymentamountbyinvoiceid")
    public BigDecimal getTotalAmount(@RequestBody Map<String, String> request) {
        String invoiceId = request.get("invoiceId"); // Extract invoiceId from request body
        return receiptpaymentService.getTotalAmountByInvoiceId(invoiceId);
    }
    
    @PostMapping("/displaylistofrpgetByInvoiceId")
    public List<ReceiptPaymentDTO4> getReceiptPaymentsByInvoiceId(@RequestBody Map<String, Long> request) {
    	Long invoiceId = request.get("invoiceId");
        return receiptpaymentService.getReceiptPaymentsByInvoiceId(invoiceId);
    }
    

}
