package com.sample.service;

import com.sample.entity.Salesfromdeliveryoptions;
import com.sample.repository.SalesfromdeliveryoptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesfromdeliveryoptionsService {

    @Autowired
    private SalesfromdeliveryoptionsRepository salesfromdeliveryoptionsRepository;

    public List<Salesfromdeliveryoptions> getAllSalesfromdeliveryoptions() {
        return salesfromdeliveryoptionsRepository.findAll();
    }

    public Optional<Salesfromdeliveryoptions> getSalesfromdeliveryoptionsById(Long id) {
        return salesfromdeliveryoptionsRepository.findById(id);
    }

    public Salesfromdeliveryoptions saveSalesfromdeliveryoptions(Salesfromdeliveryoptions salesfromdeliveryoptions) {
        return salesfromdeliveryoptionsRepository.save(salesfromdeliveryoptions);
    }

    public Salesfromdeliveryoptions updateSalesfromdeliveryoptions(Long id, Salesfromdeliveryoptions salesfromdeliveryoptionsDetails) {
        Optional<Salesfromdeliveryoptions> optionalSalesfromdeliveryoptions = salesfromdeliveryoptionsRepository.findById(id);

        if (optionalSalesfromdeliveryoptions.isPresent()) {
            Salesfromdeliveryoptions salesfromdeliveryoptions = optionalSalesfromdeliveryoptions.get();
            salesfromdeliveryoptions.setName(salesfromdeliveryoptionsDetails.getName());
            return salesfromdeliveryoptionsRepository.save(salesfromdeliveryoptions);
        } else {
            throw new RuntimeException("Salesfromdeliveryoptions not found with id " + id);
        }
    }

    public void deleteSalesfromdeliveryoptions(Long id) {
        salesfromdeliveryoptionsRepository.deleteById(id);
    }
}
