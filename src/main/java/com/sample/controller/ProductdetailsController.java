//package com.sample.controller;
//
//import com.sample.entity.Productdetails;
//import com.sample.service.ProductdetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/productdetails")
//public class ProductdetailsController {
//
//    @Autowired
//    private ProductdetailsService productdetailsService;
//
//    // Get all product details
//    @GetMapping("/getproductdetails")
//    public List<Productdetails> getAllProductDetails() {
//        return productdetailsService.getAllProductDetails();
//    }
//
//    // Get product details by ID
//    @GetMapping("/getproductdetail/{id}")
//    public ResponseEntity<Productdetails> getProductDetailsById(@PathVariable Long id) {
//        Optional<Productdetails> productdetails = productdetailsService.getProductDetailsById(id);
//        return productdetails.map(ResponseEntity::ok)
//                             .orElse(ResponseEntity.notFound().build());
//    }
//
//    // Create new product details
//    @PostMapping("/addproductdetails")
//    public Productdetails createProductDetails(@RequestBody Productdetails productdetails) {
//        return productdetailsService.saveOrUpdateProductDetails(productdetails);
//    }
//
//    // Update product details by ID
//    @PutMapping("/updateproductdetails/{id}")
//    public ResponseEntity<Productdetails> updateProductDetails(@PathVariable Long id, @RequestBody Productdetails updatedDetails) {
//        Optional<Productdetails> productdetails = productdetailsService.getProductDetailsById(id);
//        if (productdetails.isPresent()) {
//            Productdetails existingDetails = productdetails.get();
//            existingDetails.setName(updatedDetails.getName());
//            existingDetails.setDescription(updatedDetails.getDescription());
//            existingDetails.setQty(updatedDetails.getQty());
//            existingDetails.setSalesprice(updatedDetails.getSalesprice());
//            existingDetails.setAmount(updatedDetails.getAmount());
//            existingDetails.setInvoice(updatedDetails.getInvoice());
//
//            Productdetails savedDetails = productdetailsService.saveOrUpdateProductDetails(existingDetails);
//            return ResponseEntity.ok(savedDetails);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Delete product details by ID
//    @DeleteMapping("/deleteproductdetails/{id}")
//    public ResponseEntity<Void> deleteProductDetails(@PathVariable Long id) {
//        Optional<Productdetails> productdetails = productdetailsService.getProductDetailsById(id);
//        if (productdetails.isPresent()) {
//            productdetailsService.deleteProductDetails(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//
//

















package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Productdetails;
import com.sample.service.ProductdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/productdetails")
public class ProductdetailsController {

    @Autowired
    private ProductdetailsService productdetailsService;

    // Get all product details (converted to POST)
    @PostMapping("/getproductdetails")
    public ResponseEntity<List<Productdetails>> getAllProductDetails() {
        List<Productdetails> productList = productdetailsService.getAllProductDetails();
        return ResponseEntity.ok(productList);
    }

    // Get product details by ID (converted to POST, ID passed in request body)
    @PostMapping("/getproductdetailbyid")
    public ResponseEntity<Productdetails> getProductDetailsById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return productdetailsService.getProductDetailsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    // Create new product details (already POST, unchanged)
    @PostMapping("/addproductdetails")
    public ResponseEntity<Productdetails> createProductDetails(@RequestBody Productdetails productdetails) {
        Productdetails createdDetails = productdetailsService.saveOrUpdateProductDetails(productdetails);
        return ResponseEntity.ok(createdDetails);
    }

    // Update product details by ID (converted to POST, ID and updated details passed in request body)
 // Update product details by ID (ID passed in URL, updated details in request body)
    @PostMapping("/updateproductdetails/{id}")
    public ResponseEntity<Productdetails> updateProductDetails(@PathVariable Long id, @RequestBody Productdetails updatedDetails) {
        Optional<Productdetails> existingProductDetails = productdetailsService.getProductDetailsById(id);
        if (existingProductDetails.isPresent()) {
            Productdetails existingDetails = existingProductDetails.get();

            // Update the relevant fields with the new data from updatedDetails
            existingDetails.setName(updatedDetails.getName());
            existingDetails.setDescription(updatedDetails.getDescription());
            existingDetails.setQty(updatedDetails.getQty());
            existingDetails.setSalesprice(updatedDetails.getSalesprice());
            existingDetails.setAmount(updatedDetails.getAmount());
            existingDetails.setSalestaxes_id(updatedDetails.getSalestaxes_id());
            existingDetails.setInvoice(updatedDetails.getInvoice());

            // Save the updated details
            Productdetails savedDetails = productdetailsService.saveOrUpdateProductDetails(existingDetails);
            return ResponseEntity.ok(savedDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   

    // Delete product details by ID (converted to POST, ID passed in request body)
    @PostMapping("/deleteproductdetails")
    public ResponseEntity<Void> deleteProductDetails(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
       
            productdetailsService.deleteProductDetails(id);
            return ResponseEntity.noContent().build();
       
    }
   
}

