//for customer dd
package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.entity.Taxrates;
import com.sample.repository.TaxratesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaxratesService {

    @Autowired
    private TaxratesRepository taxratesRepository;

    public List<Taxrates> findAll() {
        return taxratesRepository.findAll();
    }

    public Optional<Taxrates> findById(Long id) {
        return taxratesRepository.findById(id);
    }

    public Taxrates save(Taxrates taxrates) {
        return taxratesRepository.save(taxrates);
    }
    
    public Optional<Taxrates> update(Long id, Taxrates taxrateDetails) {
        return taxratesRepository.findById(id).map(taxrate -> {
            taxrate.setName(taxrateDetails.getName());
            taxrate.setPercentage(taxrateDetails.getPercentage());
            return taxratesRepository.save(taxrate);
        });
    }

    public void deleteById(Long id) {
        taxratesRepository.deleteById(id);
    }

	

	}
