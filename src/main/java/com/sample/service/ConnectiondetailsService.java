package com.sample.service;

import com.sample.entity.Connectiondetails;
import com.sample.repository.ConnectiondetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConnectiondetailsService {

    @Autowired
    private ConnectiondetailsRepository connectiondetailsRepository;

    public List<Connectiondetails> getAll() {
        return connectiondetailsRepository.findAll();
    }

    public Optional<Connectiondetails> getById(Long id) {
        return connectiondetailsRepository.findById(id);
    }

    public Connectiondetails create(Connectiondetails connectiondetails) {
        return connectiondetailsRepository.save(connectiondetails);
    }

    public Connectiondetails update(Long id, Connectiondetails connectiondetails) {
        if (connectiondetailsRepository.existsById(id)) {
            connectiondetails.setId(id);
            return connectiondetailsRepository.save(connectiondetails);
        }
        return null;
    }

    public void delete(Long id) {
        connectiondetailsRepository.deleteById(id);
    }
}
