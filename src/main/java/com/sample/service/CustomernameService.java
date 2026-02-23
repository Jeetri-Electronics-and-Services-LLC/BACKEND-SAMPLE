package com.sample.service;

import com.sample.entity.Customername;
import com.sample.repository.CustomernameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomernameService {

    @Autowired
    private CustomernameRepository customernameRepository;

    public List<Customername> getAllCustomernames() {
        return customernameRepository.findAll();
    }

    public Optional<Customername> getCustomernameById(Long id) {
        return customernameRepository.findById(id);
    }

    public Customername saveCustomername(Customername customername) {
        return customernameRepository.save(customername);
    }

    public Customername updateCustomername(Long id, Customername updatedCustomername) {
        return customernameRepository.findById(id)
                .map(customername -> {
                    customername.setNames(updatedCustomername.getNames());
                    return customernameRepository.save(customername);
                })
                .orElseGet(() -> {
                    updatedCustomername.setId(id);
                    return customernameRepository.save(updatedCustomername);
                });
    }

    public void deleteCustomername(Long id) {
        customernameRepository.deleteById(id);
    }
}
