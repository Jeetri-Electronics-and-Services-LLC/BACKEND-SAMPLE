//package com.sample.controller;
//
//import com.sample.entity.Location;
//import com.sample.service.LocationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/locations")
//public class LocationController {
//
//    @Autowired
//    private LocationService locationService;
//
//    @GetMapping("/getalllocations")
//    public List<Location> getAllLocations() {
//        return locationService.getAllLocations();
//    }
//
//    @GetMapping("/getlocations/{id}")
//    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
//        Optional<Location> location = locationService.getLocationById(id);
//        return location.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addlocations")
//    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
//        Location savedLocation = locationService.saveLocation(location);
//        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/updatelocation/{id}")
//    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location) {
//        Location updatedLocation = locationService.updateLocation(id, location);
//        return ResponseEntity.ok(updatedLocation);
//    }
//
//    @DeleteMapping("/deletelocation/{id}")
//    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
//        locationService.deleteLocation(id);
//        return ResponseEntity.noContent().build();
//    }
//}









package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Location;
import com.sample.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    // Get all locations with POST request
    @PostMapping("/getalllocations")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    // Get location by ID using POST with JSON request body
    @PostMapping("/getlocations")
    public ResponseEntity<Location> getLocationById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return locationService.getLocationById(id)
        		.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    // Add location (remains POST)
    @PostMapping("/addlocations")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location savedLocation = locationService.saveLocation(location);
        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
    }

    // Update location with POST instead of PUT
    @PostMapping("/updatelocation/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	 String name = request.get("name").toString();
    	// Retrieve the existing city and update its name
    	 Location existingLocation = locationService.getLocationById(id).orElse(null);
         if (existingLocation == null) {
             return ResponseEntity.notFound().build();
         }

         existingLocation.setName(name);
         Location updatedLocation = locationService.updateLocation(id, existingLocation);

         return ResponseEntity.ok(updatedLocation);

    }
    

    // Delete location using POST instead of DELETE
    @PostMapping("/deletelocation")
    public ResponseEntity<Void> deleteLocation(@RequestBody Map<String, Object> request) {
    	 Long id = Long.parseLong(request.get("id").toString());
    	 locationService.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }

    
}

