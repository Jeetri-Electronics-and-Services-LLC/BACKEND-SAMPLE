//package com.sample.controller;
//
//import com.sample.entity.Portfolio;
//import com.sample.service.PortfolioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/portfolios")
//public class PortfolioController {
//
//    @Autowired
//    private PortfolioService portfolioService;
//
//    @GetMapping("/getallportfolios")
//    public List<Portfolio> getAllPortfolios() {
//        return portfolioService.getAllPortfolios();
//    }
//
//    @GetMapping("/getportfoliosbyid/{id}")
//    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable Long id) {
//        return portfolioService.getPortfolioById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addportfolios")
//    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
//        return portfolioService.createPortfolio(portfolio);
//    }
//
//    @PutMapping("/updateportfolios/{id}")
//    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable Long id, @RequestBody Portfolio portfolioDetails) {
//        return ResponseEntity.ok(portfolioService.updatePortfolio(id, portfolioDetails));
//    }
//
//    @DeleteMapping("/deleteportfoliosbyid/{id}")
//    public ResponseEntity<Void> deletePortfolio(@PathVariable Long id) {
//        portfolioService.deletePortfolio(id);
//        return ResponseEntity.noContent().build();
//    }
//}








package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Portfolio;
import com.sample.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    // POST request to get all portfolios
    @PostMapping("/getallportfolios")
    public List<Portfolio> getAllPortfolios() {
        return portfolioService.getAllPortfolios();
    }
   

    // POST request to get a portfolio by ID
    @PostMapping("/getportfoliosbyid")
    public ResponseEntity<Portfolio> getPortfolioById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	return portfolioService.getPortfolioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    // POST request to create a new portfolio
    @PostMapping("/addportfolios")
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return portfolioService.createPortfolio(portfolio);
    }

    // POST request to update a portfolio by ID
    @PostMapping("/updateportfolios/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	 String name = request.get("name").toString();

         // Retrieve the existing city and update its name
    	 Portfolio existingPortfolio = portfolioService.getPortfolioById(id).orElse(null);
         if (existingPortfolio == null) {
             return ResponseEntity.notFound().build();
         }

         existingPortfolio.setName(name);
         Portfolio updatedPortfolio = portfolioService.updatePortfolio(id, existingPortfolio);

         return ResponseEntity.ok(updatedPortfolio);
    }
    

    // POST request to delete a portfolio by ID
    @PostMapping("/deleteportfoliosbyid")
    public ResponseEntity<Void> deletePortfolio(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	portfolioService.deletePortfolio(id);
        return ResponseEntity.noContent().build();
    }

    
}
