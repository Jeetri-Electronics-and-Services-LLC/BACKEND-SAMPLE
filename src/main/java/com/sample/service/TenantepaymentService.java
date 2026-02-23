package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Tenanteinvoice;
import com.sample.entity.Tenantepayment;
import com.sample.entity.TenantepaymentDTO;
import com.sample.repository.TenanteinvoiceRepository;
import com.sample.repository.TenantepaymentRepository;

@Service
public class TenantepaymentService {

	@Autowired
    private TenantepaymentRepository paymentRepository;

    @Autowired
    private TenanteinvoiceRepository invoiceRepository;

    // ✅ POST: Add Tenantepayment using DTO
    public Tenantepayment addPayment(TenantepaymentDTO dto) {

        Tenanteinvoice invoice = invoiceRepository.findById(dto.getInvoiceId())
                .orElseThrow(() -> new RuntimeException(
                        "Invoice not found with id: " + dto.getInvoiceId()));

        Tenantepayment payment = new Tenantepayment();
        payment.setCustomerid(dto.getCustomerid());
        payment.setCustomername(dto.getCustomername());
        payment.setDate(dto.getDate());
        payment.setBalance(dto.getBalance());
        payment.setInvoice(invoice);

        return paymentRepository.save(payment);
    }
    
}
