//package com.sample.controller;
//
//import com.sample.entity.Languages;
//import com.sample.service.LanguagesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/languages")
//public class LanguagesController {
//
//    @Autowired
//    private LanguagesService languagesService;
//
//    @GetMapping("/getalllanguages")
//    public List<Languages> getAllLanguages() {
//        return languagesService.getAllLanguages();
//    }
//
//    @GetMapping("/getlanguage/{id}")
//    public ResponseEntity<Languages> getLanguagesById(@PathVariable Long id) {
//        Optional<Languages> languages = languagesService.getLanguagesById(id);
//        return languages.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addalllanguages")
//    public Languages createLanguages(@RequestBody Languages languages) {
//        return languagesService.saveLanguages(languages);
//    }
//
//    @PutMapping("/updatelanguage/{id}")
//    public ResponseEntity<Languages> updateLanguages(@PathVariable Long id, @RequestBody Languages languagesDetails) {
//        try {
//            Languages updatedLanguages = languagesService.updateLanguages(id, languagesDetails);
//            return ResponseEntity.ok(updatedLanguages);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/deletelanguage/{id}")
//    public ResponseEntity<Void> deleteLanguages(@PathVariable Long id) {
//        try {
//            languagesService.deleteLanguages(id);
//            return ResponseEntity.noContent().build();
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}







package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Languages;
import com.sample.service.LanguagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/languages")
public class LanguagesController {

    @Autowired
    private LanguagesService languagesService;

    // Retrieve all languages (POST request)
    @PostMapping("/getalllanguages")
    public ResponseEntity<List<Languages>> getAllLanguages() {
        List<Languages> languagesList = languagesService.getAllLanguages();
        return ResponseEntity.ok(languagesList);
    }

    // Retrieve a specific language by ID (POST request)
    @PostMapping("/getlanguage")
    public ResponseEntity<Languages> getLanguagesById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	 return languagesService.getLanguagesById(id)
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
    }
    

    // Create a new language entry (POST request)
    @PostMapping("/addalllanguages")
    public ResponseEntity<Languages> createLanguages(@RequestBody Languages languages) {
        Languages newLanguage = languagesService.saveLanguages(languages);
        return ResponseEntity.ok(newLanguage);
    }

    // Update an existing language by ID (POST request)
    @PostMapping("/updatelanguage/{id}")
    public ResponseEntity<Languages> updateLanguages(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	String name = request.get("name").toString();
    	// Retrieve the existing city and update its name
    	Languages existingLanguages = languagesService.getLanguagesById(id).orElse(null);
        if (existingLanguages == null) {
            return ResponseEntity.notFound().build();
        }

        existingLanguages.setName(name);
        Languages updatedLanguages = languagesService.updateLanguages(id, existingLanguages);

        return ResponseEntity.ok(updatedLanguages);
    }
    
    
    // Delete a language by ID (POST request)
    @PostMapping("/deletelanguage")
    public ResponseEntity<Void> deleteLanguages(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	languagesService.deleteLanguages(id);
            return ResponseEntity.noContent().build();
        
    }
   
}

