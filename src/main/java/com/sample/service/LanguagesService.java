package com.sample.service;

import com.sample.entity.Languages;
import com.sample.repository.LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguagesService {

    @Autowired
    private LanguagesRepository languagesRepository;

    public List<Languages> getAllLanguages() {
        return languagesRepository.findAll();
    }

    public Optional<Languages> getLanguagesById(Long id) {
        return languagesRepository.findById(id);
    }

    public Languages saveLanguages(Languages languages) {
        return languagesRepository.save(languages);
    }

    public Languages updateLanguages(Long id, Languages languagesDetails) {
        Optional<Languages> optionalLanguages = languagesRepository.findById(id);

        if (optionalLanguages.isPresent()) {
            Languages languages = optionalLanguages.get();
            languages.setName(languagesDetails.getName());
            return languagesRepository.save(languages);
        } else {
            throw new RuntimeException("Languages not found with id " + id);
        }
    }

    public void deleteLanguages(Long id) {
        languagesRepository.deleteById(id);
    }
}
