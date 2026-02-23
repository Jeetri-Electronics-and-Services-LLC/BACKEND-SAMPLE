package com.sample.service;

import com.sample.entity.Deposital;
import com.sample.repository.DepositalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositalService {

    @Autowired
    private DepositalRepository depositalRepository;

    // Create or update a Deposital
    public Deposital saveDeposital(Deposital deposital) {
        return depositalRepository.save(deposital);
    }

    // Get all Depositals
    public List<Deposital> getAllDepositals() {
        return depositalRepository.findAll();
    }

    // Get Deposital by ID
    public Optional<Deposital> getDepositalById(Long id) {
        return depositalRepository.findById(id);
    }

    // Delete Deposital by ID
    public void deleteDepositalById(Long id) {
        depositalRepository.deleteById(id);
    }
    
 // Update a Deposital
    public Deposital updateDeposital(Long id, Deposital updatedDeposital) {
        return depositalRepository.findById(id)
                .map(deposital -> {
                    deposital.setName(updatedDeposital.getName()); // Add other fields as needed
                    return depositalRepository.save(deposital);
                })
                .orElseThrow(() -> new IllegalArgumentException("Deposital with ID " + id + " not found"));
    }
}
