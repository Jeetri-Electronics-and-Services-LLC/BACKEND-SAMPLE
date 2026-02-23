//package com.sample.controller;
//
//import com.sample.entity.Paidfromaccount;
//import com.sample.service.PaidfromaccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/paidfromaccount")
//public class PaidfromaccountController {
//
//    @Autowired
//    private PaidfromaccountService service;
//
//    @GetMapping
//    public List<Paidfromaccount> getAllAccounts() {
//        return service.getAllAccounts();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Paidfromaccount> getAccountById(@PathVariable Long id) {
//        return service.getAccountById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Paidfromaccount createAccount(@RequestBody Paidfromaccount account) {
//        return service.saveAccount(account);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Paidfromaccount> updateAccount(@PathVariable Long id, @RequestBody Paidfromaccount account) {
//        return service.getAccountById(id).map(existingAccount -> {
//            existingAccount.setName(account.getName());
//            return ResponseEntity.ok(service.saveAccount(existingAccount));
//        }).orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
//        if (service.getAccountById(id).isPresent()) {
//            service.deleteAccount(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}





package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Paidfromaccount;
import com.sample.service.PaidfromaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paidfromaccount")
public class PaidfromaccountController {

    @Autowired
    private PaidfromaccountService service;

    // Endpoint to retrieve all accounts
    @PostMapping("/getAllpaidfromaccount")
    public ResponseEntity<List<Paidfromaccount>> getAllAccounts(@RequestBody(required = false) Map<String, Object> request) {
        List<Paidfromaccount> accounts = service.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
   

    // Endpoint to retrieve an account by ID
    @PostMapping("/getByIdPaidfromaccount")
    public ResponseEntity<Paidfromaccount> getAccountById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return service.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    // Endpoint to create a new account
    @PostMapping("/createpaidfromaccount")
    public ResponseEntity<Paidfromaccount> createAccount(@RequestBody Paidfromaccount account) {
        Paidfromaccount createdAccount = service.saveAccount(account);
        return ResponseEntity.ok(createdAccount);
    }

    // Endpoint to update an existing account
    @PostMapping("/updatepaidfromaccount/{id}")
    public ResponseEntity<Paidfromaccount> updateAccount(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        // Extract name from request body
        String name = request.get("name").toString();

        // Retrieve the existing Paidfromaccount and update its name
        Paidfromaccount existingPaidfromaccount = service.getAccountById(id).orElse(null);
        if (existingPaidfromaccount == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the name
        existingPaidfromaccount.setName(name);

        // Save the updated entity
        Paidfromaccount updatedPaidfromaccount = service.saveAccount(existingPaidfromaccount);

        // Return the updated entity in the response
        return ResponseEntity.ok(updatedPaidfromaccount);
    }

   

    // Endpoint to delete an account by IDs
    @PostMapping("/deletepaidfromaccount")
    public ResponseEntity<Void> deleteAccount(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        service.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
