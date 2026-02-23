package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Estimatewithouttax;
import com.sample.repository.EstimatewithouttaxRepository;

@Service
public class EstimatewithouttaxService {

    @Autowired
    private EstimatewithouttaxRepository repository;

    public List<Estimatewithouttax> getAllEstimatesWithoutTax() {
        return repository.findAll();
    }

    public Estimatewithouttax getEstimateWithoutTaxById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Estimatewithouttax saveEstimateWithoutTax(Estimatewithouttax estimateWithoutTax) {
        return repository.save(estimateWithoutTax);
    }

    public Estimatewithouttax updateEstimateWithoutTax(Long id, Estimatewithouttax estimateWithoutTax) {
        Estimatewithouttax existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setDescriptionwot(estimateWithoutTax.getDescriptionwot());
            existing.setPricewot(estimateWithoutTax.getPricewot());
            existing.setEstimate(estimateWithoutTax.getEstimate());
            return repository.save(existing);
        }
        return null;
    }

    public boolean deleteEstimateWithoutTax(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
