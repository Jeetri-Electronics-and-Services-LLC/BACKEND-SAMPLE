package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.State;
import com.sample.repository.StateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    public Optional<State> getStateById(Long id) {
        return stateRepository.findById(id);
    }

    public State createState(State state) {
        return stateRepository.save(state);
    }

    public State updateState(Long id, State stateDetails) {
        State state = stateRepository.findById(id).orElseThrow(() -> new RuntimeException("State not found"));
        state.setName(stateDetails.getName());
        return stateRepository.save(state);
    }

    public void deleteState(Long id) {
        stateRepository.deleteById(id);
    }
}

