package com.sample.service;

import com.sample.entity.Estimatestatus;
import com.sample.repository.EstimatestatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstimatestatusService {

    @Autowired
    private EstimatestatusRepository estimatestatusRepository;

    public List<Estimatestatus> getAllEstimatestatuses() {
        return estimatestatusRepository.findAll();
    }

    public Optional<Estimatestatus> getEstimatestatusById(Long id) {
        return estimatestatusRepository.findById(id);
    }

    public Estimatestatus createOrUpdateEstimatestatus(Estimatestatus estimatestatus) {
        return estimatestatusRepository.save(estimatestatus);
    }

    public void deleteEstimatestatus(Long id) {
        estimatestatusRepository.deleteById(id);
    }
}
