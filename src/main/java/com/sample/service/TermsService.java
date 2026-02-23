package com.sample.service;

import com.sample.entity.Terms;
import com.sample.repository.TermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TermsService {

    @Autowired
    private TermsRepository termsRepository;

    public List<Terms> getAllTerms() {
        return termsRepository.findAll();
    }

    public Optional<Terms> getTermsById(Long id) {
        return termsRepository.findById(id);
    }

    public Terms saveTerms(Terms terms) {
        return termsRepository.save(terms);
    }

    public Terms updateTerms(Long id, Terms updatedTerms) {
        return termsRepository.findById(id)
                .map(terms -> {
                    terms.setName(updatedTerms.getName());
                    return termsRepository.save(terms);
                })
                .orElseGet(() -> {
                    updatedTerms.setId(id);
                    return termsRepository.save(updatedTerms);
                });
    }

    public void deleteTerms(Long id) {
        termsRepository.deleteById(id);
    }
}
