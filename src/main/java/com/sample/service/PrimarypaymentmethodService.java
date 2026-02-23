package com.sample.service;

import com.sample.entity.Primarypaymentmethod;
import com.sample.repository.PrimarypaymentmethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrimarypaymentmethodService {

    @Autowired
    private PrimarypaymentmethodRepository primarypaymentmethodRepository;

    public List<Primarypaymentmethod> getAllPrimarypaymentmethods() {
        return primarypaymentmethodRepository.findAll();
    }

    public Optional<Primarypaymentmethod> getPrimarypaymentmethodById(Long id) {
        return primarypaymentmethodRepository.findById(id);
    }

    public Primarypaymentmethod savePrimarypaymentmethod(Primarypaymentmethod primarypaymentmethod) {
        return primarypaymentmethodRepository.save(primarypaymentmethod);
    }

    public Primarypaymentmethod updatePrimarypaymentmethod(Long id, Primarypaymentmethod primarypaymentmethodDetails) {
        Optional<Primarypaymentmethod> optionalPrimarypaymentmethod = primarypaymentmethodRepository.findById(id);

        if (optionalPrimarypaymentmethod.isPresent()) {
            Primarypaymentmethod primarypaymentmethod = optionalPrimarypaymentmethod.get();
            primarypaymentmethod.setName(primarypaymentmethodDetails.getName());
            return primarypaymentmethodRepository.save(primarypaymentmethod);
        } else {
            throw new RuntimeException("Primarypaymentmethod not found with id " + id);
        }
    }

    public void deletePrimarypaymentmethod(Long id) {
        primarypaymentmethodRepository.deleteById(id);
    }
}
