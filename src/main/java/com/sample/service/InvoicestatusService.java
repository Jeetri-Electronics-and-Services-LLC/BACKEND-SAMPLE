package com.sample.service;

import com.sample.entity.Invoicestatus;
import com.sample.repository.InvoicestatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoicestatusService {

    @Autowired
    private InvoicestatusRepository invoicestatusRepository;

    // Create or Update Invoicestatus
    public Invoicestatus saveInvoicestatus(Invoicestatus invoicestatus) {
        return invoicestatusRepository.save(invoicestatus);
    }

    // Get all Invoicestatus records
    public List<Invoicestatus> getAllInvoicestatus() {
        return invoicestatusRepository.findAll();
    }

    // Get Invoicestatus by ID
    public Optional<Invoicestatus> getInvoicestatusById(Long id) {
        return invoicestatusRepository.findById(id);
    }

    // Delete Invoicestatus by ID
    public void deleteInvoicestatus(Long id) {
        invoicestatusRepository.deleteById(id);
    }
}
