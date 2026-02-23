package com.sample.controller;

import com.sample.entity.PaymentBalanceDTO;
import com.sample.entity.Paymentbalance;
import com.sample.entity.Receiptpayment;
import com.sample.service.PaymentbalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paymentbalances")
public class PaymentbalanceController {

    @Autowired
    private PaymentbalanceService paymentbalanceService;

 // API to save Receiptpayment based on Invoice ID
    @PostMapping("/addpaymentbalance/{invoiceId}")
    public Paymentbalance addPaymentbalance(
            @PathVariable Long invoiceId,
            @RequestBody Paymentbalance paymentbalance) {
        // Save Receiptpayment using service
        return paymentbalanceService.savePaymentbalance(invoiceId, paymentbalance);
    }
    
    @PostMapping("/displaylistofallpaymentbalance")
    public List<PaymentBalanceDTO> getAllPaymentBalances() {
        return paymentbalanceService.getAllPaymentBalances();
    }
}
