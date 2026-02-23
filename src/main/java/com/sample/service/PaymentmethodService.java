package com.sample.service;

import com.sample.entity.Paymentmethod;
import com.sample.repository.PaymentmethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentmethodService {

    @Autowired
    private PaymentmethodRepository paymentmethodRepository;

    // Create a new payment method
    public Paymentmethod createPaymentMethod(Paymentmethod paymentmethod) {
        return paymentmethodRepository.save(paymentmethod);
    }

    // Get all payment methods
    public List<Paymentmethod> getAllPaymentMethods() {
        return paymentmethodRepository.findAll();
    }

    // Get a payment method by ID
    public Optional<Paymentmethod> getPaymentMethodById(Long id) {
        return paymentmethodRepository.findById(id);
    }

    // Update a payment method
    public Paymentmethod updatePaymentMethod(Long id, Paymentmethod paymentmethodDetails) {
        Paymentmethod paymentmethod = paymentmethodRepository.findById(id).orElseThrow();
        paymentmethod.setName(paymentmethodDetails.getName());
        return paymentmethodRepository.save(paymentmethod);
    }

    // Delete a payment method
    public void deletePaymentMethod(Long id) {
        paymentmethodRepository.deleteById(id);
    }
}
