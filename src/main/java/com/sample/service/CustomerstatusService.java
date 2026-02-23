package com.sample.service;

import com.sample.entity.Customerstatus;
import com.sample.repository.CustomerstatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerstatusService {

    @Autowired
    private CustomerstatusRepository repository;

    public Customerstatus addCustomerstatus(Customerstatus customerstatus) {
        return repository.save(customerstatus);
    }

    public List<Customerstatus> getAllCustomerstatuses() {
        return repository.findAll();
    }

    public Customerstatus getCustomerstatusById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Customerstatus not found with id: " + id));
    }

    public Customerstatus updateCustomerstatus(Long id, Customerstatus updatedCustomerstatus) {
        Customerstatus existingCustomerstatus = getCustomerstatusById(id);
        existingCustomerstatus.setName(updatedCustomerstatus.getName());
        return repository.save(existingCustomerstatus);
    }

    public void deleteCustomerstatus(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Customerstatus not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
