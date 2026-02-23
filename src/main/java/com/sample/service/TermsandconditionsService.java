package com.sample.service;

import com.sample.entity.RecentDescriptionDTO;
import com.sample.entity.Termsandconditions;
import com.sample.repository.TermsandconditionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TermsandconditionsService {

    @Autowired
    private TermsandconditionsRepository termsandconditionsRepository;

    public List<Termsandconditions> getAllTermsandconditions() {
        return termsandconditionsRepository.findAll();
    }

    public Optional<Termsandconditions> getTermsandconditionsById(Long id) {
        return termsandconditionsRepository.findById(id);
    }

    public Termsandconditions createTermsandconditions(Termsandconditions termsandconditions) {
        return termsandconditionsRepository.save(termsandconditions);
    }

    public Termsandconditions updateTermsandconditions(Long id, Termsandconditions updatedTermsandconditions) {
        return termsandconditionsRepository.findById(id)
                .map(existing -> {
                    existing.setType(updatedTermsandconditions.getType());
                    existing.setCreateddate(updatedTermsandconditions.getCreateddate());
                    existing.setCreatedby(updatedTermsandconditions.getCreatedby());
                    existing.setDescription(updatedTermsandconditions.getDescription());
                    return termsandconditionsRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Terms and Conditions not found with id " + id));
    }

    public void deleteTermsandconditions(Long id) {
        termsandconditionsRepository.deleteById(id);
    }
    
    public RecentDescriptionDTO getMostRecentDescription() {
        Termsandconditions mostRecent = termsandconditionsRepository.findMostRecentTermsAndConditions();
        if (mostRecent == null) {
            return null;
        }

        RecentDescriptionDTO dto = new RecentDescriptionDTO();
        dto.setId(mostRecent.getId());
        dto.setDescription(mostRecent.getDescription());
        return dto;
    }
}
