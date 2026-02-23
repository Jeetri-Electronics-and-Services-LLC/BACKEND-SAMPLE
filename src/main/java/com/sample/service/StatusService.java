package com.sample.service;

import com.sample.entity.Status;
import com.sample.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    public Optional<Status> getStatusById(Long id) {
        return statusRepository.findById(id);
    }

    public Status saveStatus(Status status) {
        return statusRepository.save(status);
    }

    public Status updateStatus(Long id, Status updatedStatus) {
        return statusRepository.findById(id)
                .map(status -> {
                    status.setName(updatedStatus.getName());
                    return statusRepository.save(status);
                })
                .orElseGet(() -> {
                    updatedStatus.setId(id);
                    return statusRepository.save(updatedStatus);
                });
    }

    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
}
