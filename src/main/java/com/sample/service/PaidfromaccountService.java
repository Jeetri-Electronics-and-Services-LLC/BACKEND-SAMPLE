package com.sample.service;

import com.sample.entity.Paidfromaccount;
import com.sample.repository.PaidfromaccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaidfromaccountService {

    @Autowired
    private PaidfromaccountRepository repository;

    public List<Paidfromaccount> getAllAccounts() {
        return repository.findAll();
    }

    public Optional<Paidfromaccount> getAccountById(Long id) {
        return repository.findById(id);
    }

    public Paidfromaccount saveAccount(Paidfromaccount account) {
        return repository.save(account);
    }

    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
