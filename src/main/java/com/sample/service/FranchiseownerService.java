package com.sample.service;

import com.sample.entity.Franchiseowner;
import com.sample.repository.FranchiseownerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranchiseownerService {

    @Autowired
    private FranchiseownerRepository franchiseownerRepository;

    public List<Franchiseowner> getAllFranchiseowners() {
        return franchiseownerRepository.findAll();
    }

    public Optional<Franchiseowner> getFranchiseownerById(Long id) {
        return franchiseownerRepository.findById(id);
    }

    public Franchiseowner saveFranchiseowner(Franchiseowner franchiseowner) {
        return franchiseownerRepository.save(franchiseowner);
    }

    public Franchiseowner updateFranchiseowner(Long id, Franchiseowner updatedFranchiseowner) {
        return franchiseownerRepository.findById(id)
                .map(franchiseowner -> {
                    franchiseowner.setName(updatedFranchiseowner.getName());
                    return franchiseownerRepository.save(franchiseowner);
                })
                .orElseGet(() -> {
                    updatedFranchiseowner.setId(id);
                    return franchiseownerRepository.save(updatedFranchiseowner);
                });
    }

    public void deleteFranchiseowner(Long id) {
        franchiseownerRepository.deleteById(id);
    }
}
