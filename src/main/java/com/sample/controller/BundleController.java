//package com.sample.controller;

//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.sample.entity.Bundle;
//import com.sample.entity.BundleRequestDTO;
//import com.sample.entity.Products;
//import com.sample.service.BundleService;
//
//
//@RestController
//@RequestMapping("/bundles")
//public class BundleController {
//
//    @Autowired
//    private BundleService bundleService;
//    
//
//
//    @PostMapping("/addbundle")
//    public ResponseEntity<Bundle> addBundle(@RequestBody Bundle bundle) {
//        try {
//            Bundle savedBundle = bundleService.saveBundle(bundle);
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedBundle);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    
//    // Get all bundles along with products
//    @GetMapping("/all")
//    public ResponseEntity<List<Bundle>> getAllBundles() {
//    try {
//    List<Bundle> bundles = bundleService.getAllBundles();
//    return new ResponseEntity<>(bundles, HttpStatus.OK);
//    } catch (Exception e) {
//    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    }
//    // Delete a bundle along with products
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<HttpStatus> deleteBundle(@PathVariable("id") Long id) {
//    try {
//    bundleService.deleteBundleById(id);
//    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    } catch (Exception e) {
//    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    }
//    
//    @GetMapping("/getonebundle/{id}")
//    public ResponseEntity<Bundle> getBundleById(@PathVariable Long id) {
//        Optional<Bundle> bundle = bundleService.findBundleById(id);
//        return bundle.map(ResponseEntity::ok)
//                     .orElse(ResponseEntity.notFound().build());
//    }
//    
// // Create a new bundle along with products
//    @PostMapping("/createbundlle")
//    public ResponseEntity<Bundle> createBundle(@RequestBody BundleRequestDTO bundleRequest) {
//        try {
//            Bundle createdBundle = bundleService.createBundleWithProducts(bundleRequest);
//            return new ResponseEntity<>(createdBundle, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    
//
//    
//    @GetMapping("/bundlename/{name}")
//    public ResponseEntity<Bundle> getBundleByName(@PathVariable String name) {
//        return bundleService.findBundleByName(name)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//    
//    @PutMapping("/updatebundle/{id}")
//    public ResponseEntity<Bundle> updateBundle(@PathVariable Long id, @RequestBody Bundle updatedBundle) {
//        Bundle updated = bundleService.updateBundle(id, updatedBundle);
//
//        if (updated != null) {
//            return ResponseEntity.ok(updated);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    
//    @GetMapping("/listofbundlenames")
//    public List<String> getBundleNames() {
//        return bundleService.getAllBundleNames();
//    }
//    
//    @GetMapping("/bundledetailsproducts/{bundleName}")
//    public Map<String, Object> getBundleDetails(@PathVariable String bundleName) {
//        List<Object[]> bundleDetails = bundleService.getBundleDetails(bundleName);
//        
//        Map<String, Object> response = new HashMap<>();
//        if (bundleDetails.isEmpty()) {
//            response.put("message", "No bundle found with the given name");
//        } else {
//            response.put("bundleName", bundleDetails.get(0)[0]);
//            response.put("bundleDescription", bundleDetails.get(0)[1]);
//
//            // List to store products info
//            List<Map<String, Object>> products = new ArrayList<>();
//
//            for (Object[] row : bundleDetails) {
//                Map<String, Object> product = new HashMap<>();
//                product.put("productName", row[2]);
//                product.put("productDescription", row[3]);
//                product.put("productSalesPrice", row[4]);
//                products.add(product);
//            }
//
//            response.put("products", products);
//        }
//
//        return response;
//    }
//    
////  @GetMapping("/getbundle")
////  public List<Bundle> getAllBundleData() {
////    return bundleService.getAllBundles();
////  }
//
////  @PutMapping("/updatebundle/{id}")
////  public ResponseEntity<Bundle> updateBundle(@PathVariable Long id, @RequestBody Bundle bundle) {
////      try {
////          Bundle updatedBundle = bundleService.updateBundle(id, bundle);
////          return ResponseEntity.ok(updatedBundle);
////      } catch (Exception e) {
////          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
////      }
////  }
//  
////  @DeleteMapping("/deletebundle/{id}")
////  public ResponseEntity<Void> deleteBundle(@PathVariable Long id) {
////      try {
////          bundleService.deleteBundle(id);
////          return ResponseEntity.noContent().build(); // 204 No Content
////      } catch (Exception e) {
////          return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
////      }
////  }
//    
////  @GetMapping("/bundlename/{name}")
////  public ResponseEntity<Bundle> getBundleByName(@PathVariable String name) {
////      return bundleService.findBundleByName(name)
////              .map(ResponseEntity::ok)
////              .orElse(ResponseEntity.notFound().build());
////  }
//  
////  @GetMapping("/name/{name}/products")
////  public ResponseEntity<List<Products>> getProductsByBundleName(@PathVariable String name) {
////      List<Products> products = bundleService.findProductsByBundleName(name);
////      if (products != null) {
////          return ResponseEntity.ok(products);
////      } else {
////          return ResponseEntity.notFound().build();
////      }
////  }
//  //based on bundle name only list of products
////  @GetMapping("/bundleproductname/{name}")
////  public ResponseEntity<List<Products>> getProductsByBundleName(@PathVariable String name) {
////      List<Products> products = bundleService.findProductsByBundleName(name);
////      if (products != null) {
////          return ResponseEntity.ok(products);
////      } else {
////          return ResponseEntity.notFound().build();
////      }
////  }
//}







package com.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.Bundle;
import com.sample.entity.BundleRequestDTO;
import com.sample.service.BundleService;

@RestController
@RequestMapping("/bundles")
public class BundleController {

    @Autowired
    private BundleService bundleService;

    // Create a new bundle
    @PostMapping("/addbundle")
    public ResponseEntity<Bundle> addBundle(@RequestBody Bundle bundle) {
        try {
            Bundle savedBundle = bundleService.saveBundle(bundle);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBundle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get all bundles along with products
    @PostMapping("/all")
    public ResponseEntity<List<Bundle>> getAllBundles() {
        try {
            List<Bundle> bundles = bundleService.getAllBundles();
            return new ResponseEntity<>(bundles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a bundle (POST method, id should be in the request body)
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> deleteBundle(@RequestBody Map<String, Long> request) {
        Long id = request.get("id");
        try {
            bundleService.deleteBundleById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a bundle by ID
    @PostMapping("/getonebundle")
    public ResponseEntity<Bundle> getBundleById(@RequestBody Map<String, Long> request) {
        Long id = request.get("id");
        Optional<Bundle> bundle = bundleService.findBundleById(id);
        return bundle.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

 // Create a new bundle along with products
  @PostMapping("/createbundlle")
  public ResponseEntity<Bundle> createBundle(@RequestBody BundleRequestDTO bundleRequest) {
      try {
          Bundle createdBundle = bundleService.createBundleWithProducts(bundleRequest);
          return new ResponseEntity<>(createdBundle, HttpStatus.CREATED);
      } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

    // Get a bundle by name
    @PostMapping("/bundlename")
    public ResponseEntity<Bundle> getBundleByName(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        return bundleService.findBundleByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a bundle
// // Update a bundle using POST request with all values in the JSON object (including the ID)
//    @PostMapping("/updatebundle")
//    public ResponseEntity<Bundle> updateBundle(@RequestBody Bundle updatedBundle) {
//        Long id = updatedBundle.getId(); // Assuming the ID is part of the Bundle object
//
//        // Call the service to update the bundle with the provided ID and updated data
//        Bundle updated = bundleService.updateBundle(id, updatedBundle);
//
//        // If the update is successful, return the updated bundle in the response
//        if (updated != null) {
//            return ResponseEntity.ok(updated);
//        } else {
//            // If the bundle with the specified ID is not found, return a 404 status
//            return ResponseEntity.notFound().build();
//        }
//    }

    
    

    // Get a list of bundle names
    @PostMapping("/listofbundlenames")
    public ResponseEntity<List<String>> getBundleNames() {
        List<String> bundleNames = bundleService.getAllBundleNames();
        return ResponseEntity.ok(bundleNames);
    }

    // Get bundle details along with products
    @PostMapping("/bundledetailsproducts")
    public ResponseEntity<Map<String, Object>> getBundleDetails(@RequestBody Map<String, String> request) {
        String bundleName = request.get("bundleName");
        List<Object[]> bundleDetails = bundleService.getBundleDetails(bundleName);
        
        Map<String, Object> response = new HashMap<>();
        if (bundleDetails.isEmpty()) {
            response.put("message", "No bundle found with the given name");
        } else {
            response.put("bundleName", bundleDetails.get(0)[0]);
            response.put("bundleDescription", bundleDetails.get(0)[1]);

            // List to store products info
            List<Map<String, Object>> products = new ArrayList<>();

            for (Object[] row : bundleDetails) {
                Map<String, Object> product = new HashMap<>();
                product.put("productName", row[2]);
                product.put("productDescription", row[3]);
                product.put("productSalesPrice", row[4]);
                products.add(product);
            }

            response.put("products", products);
        }

        return ResponseEntity.ok(response);
    }
}
