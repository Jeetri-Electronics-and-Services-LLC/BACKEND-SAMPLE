package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Country;
import com.sample.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(Long id, Country countryDetails) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
        country.setName(countryDetails.getName());
        return countryRepository.save(country);
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
