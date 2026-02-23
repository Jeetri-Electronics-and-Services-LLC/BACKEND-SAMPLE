package com.sample.service;

import com.sample.entity.Invoicewithouttax;
import com.sample.repository.InvoicewithouttaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoicewithouttaxService {

    @Autowired
    private InvoicewithouttaxRepository repository;

    // Create
    public Invoicewithouttax createInvoicewithouttax(Invoicewithouttax invoicewithouttax) {
        return repository.save(invoicewithouttax);
    }

    // Read All
    public List<Invoicewithouttax> getAllInvoicewithouttaxes() {
        return repository.findAll();
    }

    // Read by ID
    public Optional<Invoicewithouttax> getInvoicewithouttaxById(Long id) {
        return repository.findById(id);
    }

    // Update
    public Invoicewithouttax updateInvoicewithouttax(Long id, Invoicewithouttax updatedInvoicewithouttax) {
        return repository.findById(id).map(invoice -> {
            invoice.setDescriptionwot(updatedInvoicewithouttax.getDescriptionwot());
            invoice.setPricewot(updatedInvoicewithouttax.getPricewot());
            invoice.setInvoice(updatedInvoicewithouttax.getInvoice());
            return repository.save(invoice);
        }).orElseThrow(() -> new RuntimeException("Invoicewithouttax not found with ID: " + id));
    }

    // Delete
    public void deleteInvoicewithouttax(Long id) {
        repository.deleteById(id);
    }
}
