package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.City;
import com.sample.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }
    

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City cityDetails) {
        City city = cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
        city.setName(cityDetails.getName());
        return cityRepository.save(city);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}

