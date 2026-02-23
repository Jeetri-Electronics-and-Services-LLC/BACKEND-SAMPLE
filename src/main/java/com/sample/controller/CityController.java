//package com.sample.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.sample.entity.City;
//import com.sample.service.CityService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/cities")
//public class CityController {
//
//    @Autowired
//    private CityService cityService;
//
//    @GetMapping("/getallcity")
//    public List<City> getAllCities() {
//        return cityService.getAllCities();
//    }
//
//    @GetMapping("/getcity/{id}")
//    public ResponseEntity<City> getCityById(@PathVariable Long id) {
//        return cityService.getCityById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addcity")
//    public City createCity(@RequestBody City city) {
//        return cityService.createCity(city);
//    }
//
//    @PutMapping("/updatecity/{id}")
//    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City cityDetails) {
//        return ResponseEntity.ok(cityService.updateCity(id, cityDetails));
//    }
//
//    @DeleteMapping("/deletecity/{id}")
//    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
//        cityService.deleteCity(id);
//        return ResponseEntity.noContent().build();
//    }
//}
//








package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.City;
import com.sample.service.CityService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    // POST method to get all cities
    @PostMapping("/getallcity")
    public ResponseEntity<List<City>> getAllCities(@RequestBody(required = false) Map<String, Object> request) {
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    // POST method to get city by id
    @PostMapping("/getcity")
    public ResponseEntity<City> getCityById(@RequestBody Map<String, Object> request) {
        Long id = Long.parseLong(request.get("id").toString());
        return cityService.getCityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST method to add a city
    @PostMapping("/addcity")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City createdCity = cityService.createCity(city);
        return ResponseEntity.ok(createdCity);
    }

    // POST method to update a city
    @PostMapping("/updatecity/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        // Extract name from request body
        String name = request.get("name").toString();

        // Retrieve the existing city and update its name
        City existingCity = cityService.getCityById(id).orElse(null);
        if (existingCity == null) {
            return ResponseEntity.notFound().build();
        }

        existingCity.setName(name);
        City updatedCity = cityService.updateCity(id, existingCity);

        return ResponseEntity.ok(updatedCity);
    }

    // POST method to delete a city
    @PostMapping("/deletecity")
    public ResponseEntity<Void> deleteCity(@RequestBody Map<String, Object> request) {
        Long id = Long.parseLong(request.get("id").toString());
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}

