package com.sample.service;

import com.sample.entity.Emailestimate;
import com.sample.entity.Estimate;
import com.sample.repository.EmailestimateRepository;
import com.sample.repository.EstimateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailestimateService {

    @Autowired
    EmailestimateRepository emailestimateRepository;
    
    @Autowired
    private EstimateRepository estimateRepository;

    public List<Emailestimate> getAllEmailestimates() {
        return emailestimateRepository.findAll();
    }

    public Optional<Emailestimate> getEmailestimateById(Long id) {
        return emailestimateRepository.findById(id);
    }

    public Emailestimate saveEmailestimate(Emailestimate emailestimate) {
        return emailestimateRepository.save(emailestimate);
    }

    public void deleteEmailestimate(Long id) {
        emailestimateRepository.deleteById(id);
    }
    
    public Emailestimate createEmailEstimate(Long estimateId, Emailestimate emailEstimate) {
        Estimate estimate = estimateRepository.findById(estimateId).orElseThrow(() -> new RuntimeException("Estimate not found"));
        emailEstimate.setEstimate(estimate);
        return emailestimateRepository.save(emailEstimate);
    }
}
