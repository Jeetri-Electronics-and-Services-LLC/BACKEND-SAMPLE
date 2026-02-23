//package com.sample.controller;
//
//import com.sample.entity.Invoicestatus;
//import com.sample.service.InvoicestatusService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/invoicestatus")
//public class InvoicestatusController {
//
//    @Autowired
//    private InvoicestatusService invoicestatusService;
//
//    // Create or Update Invoicestatus
//    @PostMapping("/save")
//    public ResponseEntity<Invoicestatus> saveInvoicestatus(@RequestBody Invoicestatus invoicestatus) {
//        Invoicestatus savedInvoicestatus = invoicestatusService.saveInvoicestatus(invoicestatus);
//        return new ResponseEntity<>(savedInvoicestatus, HttpStatus.CREATED);
//    }
//
//    // Get all Invoicestatus records
//    @GetMapping("/all")
//    public ResponseEntity<List<Invoicestatus>> getAllInvoicestatus() {
//        List<Invoicestatus> invoicestatusList = invoicestatusService.getAllInvoicestatus();
//        return new ResponseEntity<>(invoicestatusList, HttpStatus.OK);
//    }
//
//    // Get Invoicestatus by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Invoicestatus> getInvoicestatusById(@PathVariable Long id) {
//        Optional<Invoicestatus> invoicestatus = invoicestatusService.getInvoicestatusById(id);
//        if (invoicestatus.isPresent()) {
//            return new ResponseEntity<>(invoicestatus.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    // Delete Invoicestatus by ID
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteInvoicestatus(@PathVariable Long id) {
//        invoicestatusService.deleteInvoicestatus(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}




package com.sample.controller;

import com.sample.entity.Invoicestatus;
import com.sample.service.InvoicestatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoicestatus")
public class InvoicestatusController {

    @Autowired
    private InvoicestatusService invoicestatusService;

    // Create or Update Invoicestatus
    @PostMapping("/invoicestatussave")
    public ResponseEntity<Invoicestatus> saveInvoicestatus(@RequestBody Invoicestatus invoicestatus) {
        Invoicestatus savedInvoicestatus = invoicestatusService.saveInvoicestatus(invoicestatus);
        return new ResponseEntity<>(savedInvoicestatus, HttpStatus.CREATED);
    }

    // Get all Invoicestatus records using POST
    @PostMapping("/invoicestatusgetAll")
    public ResponseEntity<List<Invoicestatus>> getAllInvoicestatus() {
        List<Invoicestatus> invoicestatusList = invoicestatusService.getAllInvoicestatus();
        return new ResponseEntity<>(invoicestatusList, HttpStatus.OK);
    }

    // Get Invoicestatus by ID using POST
    @PostMapping("/invoicestatusgetById")
    public ResponseEntity<Invoicestatus> getInvoicestatusById(@RequestBody Long id) {
        Optional<Invoicestatus> invoicestatus = invoicestatusService.getInvoicestatusById(id);
        if (invoicestatus.isPresent()) {
            return new ResponseEntity<>(invoicestatus.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete Invoicestatus by ID using POST
    @PostMapping("/invoicestatusdelete")
    public ResponseEntity<Void> deleteInvoicestatus(@RequestBody Long id) {
        invoicestatusService.deleteInvoicestatus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
