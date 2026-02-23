package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.Tenantepayment;
import com.sample.entity.TenantepaymentDTO;
import com.sample.service.TenantepaymentService;

@RestController
@RequestMapping("/tenant-payments")
public class TenantepaymentController {

	@Autowired
    private TenantepaymentService paymentService;

    // ✅ POST API to add payment
    @PostMapping("/addtenant-paymentswithinvoice")
    public ResponseEntity<Tenantepayment> addPayment(
            @RequestBody TenantepaymentDTO dto) {

        return ResponseEntity.ok(paymentService.addPayment(dto));
    }
   
}
