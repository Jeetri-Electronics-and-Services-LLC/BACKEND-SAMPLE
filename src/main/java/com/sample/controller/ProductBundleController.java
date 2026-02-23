//package com.sample.controller;
//
//
//
//import com.sample.service.ProductBundleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Map;
//import java.util.HashMap;
//
//@RestController
//@RequestMapping("/productbundle")
//public class ProductBundleController {
//
//    @Autowired
//    private ProductBundleService productBundleService;
//
//    @GetMapping("/product-bundle-names")
//    public Map<String, List<String>> getProductAndBundleName() {
//        List<String> createProductNames = productBundleService.getAllCreateProductNames();
//        List<String> bundleNames = productBundleService.getAllBundleNames();
//
//        Map<String, List<String>> response = new HashMap<>();
//        response.put("createProductNames", createProductNames);
//        response.put("bundleNames", bundleNames);
//
//        return response;
//    }
//    
//    @GetMapping("/productbundlenameslist")
//    public List<String> getProductAndBundleNames() {
//        return productBundleService.getAllProductAndBundleNames();
//    }
//    
//    
//    
//
//    
//    @GetMapping("/displaydetailsbasedonname/{bundleproductName}")
//    public Object getDetailsByName(@PathVariable String bundleproductName) {
//        // Attempt to find product details
//        Map<String, Object> productDetails = productBundleService.getProductDetailsByName(bundleproductName);
//        if (productDetails != null) {
//            return productDetails; // Return product details directly
//        }
//
//        // Attempt to find bundle details if product was not found
//        Map<String, Object> bundleDetails = productBundleService.getBundleDetailsByName(bundleproductName);
//        if (bundleDetails != null) {
//            return bundleDetails; // Return bundle details directly
//        }
//
//        // If neither product nor bundle is found, return a not found response or empty object
//        return Map.of("message", "Not found"); // Or return an empty object
//    }
//    
////  @GetMapping("/bundlewithproductstofetchwithtype/{bundleproductName}")
////  public Map<String, Object> getDetailsByName(@PathVariable String bundleproductName) {
////      Map<String, Object> response = new HashMap<>();
////
////      // Try to find product details first
////      Map<String, Object> productDetails = productBundleService.getProductDetailsByName(bundleproductName);
////      if (!productDetails.isEmpty()) {
////          response.put("type", "product");
////          response.put("details", productDetails);
////          return response;
////      }
////
////      // Try to find bundle details if product was not found
////      Map<String, Object> bundleDetails = productBundleService.getBundleDetailsByName(bundleproductName);
////      if (!bundleDetails.isEmpty()) {
////          response.put("type", "bundle");
////          response.put("details", bundleDetails);
////          return response;
////      }
////
////      // If neither product nor bundle is found, return an empty response
////      response.put("message", "No product or bundle found with the given name");
////      return response;
////  }
//}










package com.sample.controller;

import com.sample.service.ProductBundleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/productbundle")
public class ProductBundleController {

    @Autowired
    private ProductBundleService productBundleService;

    

    // POST method to get a list of product and bundle names, request body is optional
    @PostMapping("/productbundlenameslist")
    public List<Map<String, Object>> getProductAndBundleIdsAndNames(@RequestBody(required = false) Map<String, String> request) {
        return productBundleService.getAllProductAndBundleIdsAndNames();
    }

    // POST method to get product or bundle details based on name, request body is required
    @PostMapping("/displaydetailsbasedonname")
    public Object getDetailsByName(@RequestBody Map<String, String> request) {
        // Extract 'bundleproductName' from the JSON body
        String bundleproductName = request.get("bundleproductName");

        // Validate the input
        if (bundleproductName == null || bundleproductName.isEmpty()) {
            return Map.of("message", "bundleproductName is required");
        }

        // Attempt to find product details
        Map<String, Object> productDetails = productBundleService.getProductDetailsByName(bundleproductName);
        if (productDetails != null) {
            return productDetails; // Return product details directly
        }

        // Attempt to find bundle details if product was not found
        Map<String, Object> bundleDetails = productBundleService.getBundleDetailsByName(bundleproductName);
        if (bundleDetails != null) {
            return bundleDetails; // Return bundle details directly
        }

        // If neither product nor bundle is found, return a not found response or empty object
        return Map.of("message", "Not found");
    }
}
