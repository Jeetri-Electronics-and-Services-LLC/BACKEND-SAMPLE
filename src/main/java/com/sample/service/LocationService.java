package com.sample.service;

import com.sample.entity.Location;
import com.sample.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location updateLocation(Long id, Location updatedLocation) {
        return locationRepository.findById(id)
                .map(location -> {
                    location.setName(updatedLocation.getName());
                    return locationRepository.save(location);
                })
                .orElseGet(() -> {
                    updatedLocation.setId(id);
                    return locationRepository.save(updatedLocation);
                });
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
