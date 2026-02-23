package com.sample.service;

import com.sample.entity.Salestaxes;
import com.sample.repository.SalestaxesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalestaxesService {
	
	private static final String DEFAULT_TAX_RATE = "8.25%"; // Default sales tax rate


    @Autowired
    private SalestaxesRepository salestaxesRepository;

    public List<Salestaxes> getAllTaxes() {
        return salestaxesRepository.findAll();
    }

    public Optional<Salestaxes> getTaxById(Long id) {
        return salestaxesRepository.findById(id);
    }

    public Salestaxes saveTax(Salestaxes salestaxes) {
        return salestaxesRepository.save(salestaxes);
    }

    public Salestaxes updateTax(Long id, Salestaxes updatedSalestaxes) {
        return salestaxesRepository.findById(id)
            .map(salestaxes -> {
                salestaxes.setCity(updatedSalestaxes.getCity());
                salestaxes.setState(updatedSalestaxes.getState());
                salestaxes.setTaxes(updatedSalestaxes.getTaxes());
                return salestaxesRepository.save(salestaxes);
            }).orElse(null);
    }

    public void deleteTax(Long id) {
        salestaxesRepository.deleteById(id);
    }
    
    public String getSalesTaxByCityAndState(String city, String state) {
        Salestaxes salestaxes = salestaxesRepository.findTaxByCityAndState(city, state);
        return salestaxes != null ? salestaxes.getTaxes() : DEFAULT_TAX_RATE; // Return tax or default rate if not found
    }

	

}
