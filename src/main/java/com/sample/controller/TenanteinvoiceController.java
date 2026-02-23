package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.InvoiceCustomerSummaryDTO;
import com.sample.entity.Tenanteinvoice;
import com.sample.entity.TenanteinvoiceDTO;
import com.sample.service.TenanteinvoiceService;

@RestController
@RequestMapping("/tenanteinvoice")
@CrossOrigin
public class TenanteinvoiceController {

	@Autowired
    private TenanteinvoiceService tenanteinvoiceService;

    @PostMapping("/addtenanteinvoice")
    public Tenanteinvoice addTenanteinvoice(@RequestBody TenanteinvoiceDTO dto) {
        return tenanteinvoiceService.addInvoice(dto);
    }
    
    // POST API to fetch customer + invoice summary by invoiceId
    @PostMapping("/tenanteinvoicedetails/{id}")
    public ResponseEntity<InvoiceCustomerSummaryDTO> getTenanteInvoiceDetails(
            @PathVariable("id") Long id) {

        InvoiceCustomerSummaryDTO response =
                tenanteinvoiceService.getInvoiceCustomerSummary(id);

        return ResponseEntity.ok(response);
    }
}
