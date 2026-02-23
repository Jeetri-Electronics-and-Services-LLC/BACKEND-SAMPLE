package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.sample.entity.Salestaxbasedonstate;
import com.sample.repository.SalestaxbasedonstateRepository;

@Service
public class SalestaxbasedonstateService {

    @Autowired
    private SalestaxbasedonstateRepository repository;
    
 
    public List<Salestaxbasedonstate> getAllSalesTaxes() {
        return repository.findAll();
    }

    public Salestaxbasedonstate getSalestaxByState(String state) {
        return repository.findByState(state);
    }

    public Salestaxbasedonstate saveSalestax(Salestaxbasedonstate salestax) {
        return repository.save(salestax);
    }

    public void deleteSalestax(Long id) {
        repository.deleteById(id);
    }
    
    //Display Salestax Based On Given State
    public String getSalesTaxByState(String state) {
        Salestaxbasedonstate salestax = repository.findByState(state);

        // If no sales tax is found for the given state, return the default value
        if (salestax == null) {
            return "8.25%";
        }

        return salestax.getSalestax();
    }
}