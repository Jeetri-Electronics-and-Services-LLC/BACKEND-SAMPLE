//package com.sample.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.sample.entity.Country;
//import com.sample.service.CountryService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/countries")
//public class CountryController {
//
//    @Autowired
//    private CountryService countryService;
//
//    @GetMapping("/getallcountries")
//    public List<Country> getAllCountries() {
//        return countryService.getAllCountries();
//    }
//
//    @GetMapping("/getcountry/{id}")
//    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
//        return countryService.getCountryById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addcountry")
//    public Country createCountry(@RequestBody Country country) {
//        return countryService.createCountry(country);
//    }
//
//    @PutMapping("/updatecountry/{id}")
//    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country countryDetails) {
//        return ResponseEntity.ok(countryService.updateCountry(id, countryDetails));
//    }
//
//    @DeleteMapping("/deletecountry/{id}")
//    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
//        countryService.deleteCountry(id);
//        return ResponseEntity.noContent().build();
//    }
//}










package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.City;
import com.sample.entity.Country;
import com.sample.service.CountryService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // Changed to POST and passing parameters in the request body
    @PostMapping("/getallcountries")
    public ResponseEntity<List<Country>> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    // Changed to POST and passing id in the request body
    @PostMapping("/getcountry")
    public ResponseEntity<Country> getCountryById(@RequestBody Map<String, Object> request) {
    	 Long id = Long.parseLong(request.get("id").toString());
        return countryService.getCountryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    // POST request to create a new country
    @PostMapping("/addcountry")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        return ResponseEntity.ok(countryService.createCountry(country));
    }

    // POST request to update the country details
    @PostMapping("/updatecountry/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	String name = request.get("name").toString();
    	// Retrieve the existing country and update its name
        Country existingCountry = countryService.getCountryById(id).orElse(null);
        if (existingCountry == null) {
            return ResponseEntity.notFound().build();
        }

        existingCountry.setName(name);
        Country updatedCountry = countryService.updateCountry(id, existingCountry);

        return ResponseEntity.ok(updatedCountry);
    }
    
    

    // POST request to delete a country, id passed in request body
    @PostMapping("/deletecountry")
    public ResponseEntity<Void> deleteCountry(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }
    
    
}


