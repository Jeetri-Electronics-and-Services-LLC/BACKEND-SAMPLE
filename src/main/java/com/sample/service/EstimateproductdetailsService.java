package com.sample.service;

import com.sample.entity.Estimateproductdetails;
import com.sample.repository.EstimateproductdetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstimateproductdetailsService {

    @Autowired
    private EstimateproductdetailsRepository estimateproductdetailsRepository;

    // Create or update Estimateproductdetails
    public Estimateproductdetails save(Estimateproductdetails estimateproductdetails) {
        return estimateproductdetailsRepository.save(estimateproductdetails);
    }

    // Get all Estimateproductdetails
    public List<Estimateproductdetails> getAll() {
        return estimateproductdetailsRepository.findAll();
    }

    // Get Estimateproductdetails by ID
    public Optional<Estimateproductdetails> getById(Long id) {
        return estimateproductdetailsRepository.findById(id);
    }

    // Delete Estimateproductdetails by ID
    public void deleteById(Long id) {
        estimateproductdetailsRepository.deleteById(id);
    }
}
