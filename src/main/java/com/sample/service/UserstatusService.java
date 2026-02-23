package com.sample.service;

import com.sample.entity.Userstatus;
import com.sample.repository.UserstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserstatusService {

    @Autowired
    private UserstatusRepository userstatusRepository;

    // Create a new Userstatus
    public Userstatus createUserstatus(Userstatus userstatus) {
        return userstatusRepository.save(userstatus);
    }

    // Update an existing Userstatus
    public Userstatus updateUserstatus(Long id, Userstatus userstatus) {
        if (userstatusRepository.existsById(id)) {
            userstatus.setId(id);
            return userstatusRepository.save(userstatus);
        }
        return null; // Return null if the Userstatus does not exist
    }

    // Get all Userstatuses
    public List<Userstatus> getAllUserstatuses() {
        return userstatusRepository.findAll();
    }

    // Get Userstatus by ID
    public Optional<Userstatus> getUserstatusById(Long id) {
        return userstatusRepository.findById(id);
    }

    // Delete Userstatus by ID
    public void deleteUserstatus(Long id) {
        userstatusRepository.deleteById(id);
    }
}
