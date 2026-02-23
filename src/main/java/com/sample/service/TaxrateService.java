package com.sample.service;

import com.sample.entity.Taxrate;
import com.sample.repository.TaxrateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxrateService {

    @Autowired
    private TaxrateRepository taxrateRepository;

    public List<Taxrate> getAllTaxrates() {
        return taxrateRepository.findAll();
    }

    public Optional<Taxrate> getTaxrateById(Long id) {
        return taxrateRepository.findById(id);
    }

    public Taxrate saveTaxrate(Taxrate taxrate) {
        return taxrateRepository.save(taxrate);
    }

    public Taxrate updateTaxrate(Long id, Taxrate taxrateDetails) {
        Optional<Taxrate> optionalTaxrate = taxrateRepository.findById(id);

        if (optionalTaxrate.isPresent()) {
            Taxrate taxrate = optionalTaxrate.get();
            taxrate.setNames(taxrateDetails.getNames());
            return taxrateRepository.save(taxrate);
        } else {
            throw new RuntimeException("Taxrate not found with id " + id);
        }
    }

    public void deleteTaxrate(Long id) {
        taxrateRepository.deleteById(id);
    }
}
