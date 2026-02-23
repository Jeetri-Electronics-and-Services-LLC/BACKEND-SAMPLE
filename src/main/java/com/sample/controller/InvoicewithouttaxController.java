package com.sample.controller;

import com.sample.entity.Invoicewithouttax;
import com.sample.service.InvoicewithouttaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoicewithouttaxes")
public class InvoicewithouttaxController {

    @Autowired
    private InvoicewithouttaxService service;

    // Create
    @PostMapping
    public ResponseEntity<Invoicewithouttax> createInvoicewithouttax(@RequestBody Invoicewithouttax invoicewithouttax) {
        return ResponseEntity.ok(service.createInvoicewithouttax(invoicewithouttax));
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<Invoicewithouttax>> getAllInvoicewithouttaxes() {
        return ResponseEntity.ok(service.getAllInvoicewithouttaxes());
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Invoicewithouttax> getInvoicewithouttaxById(@PathVariable Long id) {
        return service.getInvoicewithouttaxById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Invoicewithouttax> updateInvoicewithouttax(@PathVariable Long id, @RequestBody Invoicewithouttax updatedInvoicewithouttax) {
        return ResponseEntity.ok(service.updateInvoicewithouttax(id, updatedInvoicewithouttax));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoicewithouttax(@PathVariable Long id) {
        service.deleteInvoicewithouttax(id);
        return ResponseEntity.noContent().build();
    }
}
