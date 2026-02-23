package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.entity.Customertype;
import com.sample.repository.CustomertypeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CustomertypeService {

    @Autowired
    private CustomertypeRepository customertypeRepository;

    //Get ALL CustomerType
    public List<Customertype> getAllCustomertypes() {
        return customertypeRepository.findAll();
    }

  //Get CustomerType BY ID
    public Optional<Customertype> getCustomertypeById(Long id) {
        return customertypeRepository.findById(id);
    }

    //Add CustomerType
    public Customertype addCustomertype(Customertype customertype) {
        return customertypeRepository.save(customertype);
    }

 // Update Customertype Method
    public Customertype updateCustomertype(Long id, Customertype customertypeDetails) {
        return customertypeRepository.findById(id)
            .map(existingCustomertype -> {
                existingCustomertype.setName(customertypeDetails.getName());
                return customertypeRepository.save(existingCustomertype);
            })
            .orElse(null);
    }
    
 //Delete CustomerType
    public void deleteCustomertype(Long id) {
        customertypeRepository.deleteById(id);
    }
}
