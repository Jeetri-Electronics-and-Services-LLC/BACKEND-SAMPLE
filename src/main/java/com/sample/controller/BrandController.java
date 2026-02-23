//package com.sample.controller;


//
//import com.sample.entity.Brand;
//import com.sample.service.BrandService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/brands")
//public class BrandController {
//
//    @Autowired
//    private BrandService brandService;
//
//    @GetMapping("/getallbrand")
//    public List<Brand> getAllBrands() {
//        return brandService.getAllBrands();
//    }
//
//    @GetMapping("/getbrandbyid/{id}")
//    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
//        Optional<Brand> brand = brandService.getBrandById(id);
//        if (brand.isPresent()) {
//            return ResponseEntity.ok(brand.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("/postbrand")
//    public Brand createBrand(@RequestBody Brand brand) {
//        return brandService.createBrand(brand);
//    }
//
//    @PutMapping("/updatebrandbyid/{id}")
//    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand updatedBrand) {
//        Brand brand = brandService.updateBrand(id, updatedBrand);
//        if (brand != null) {
//            return ResponseEntity.ok(brand);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/deletebrandbyid/{id}")
//    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
//        brandService.deleteBrand(id);
//        return ResponseEntity.noContent().build();
//    }
////  // Api To Display All Brand Details 
//    @GetMapping("/dispalyallbranddetails")
//    public List<BrandDTO2> getAllBrandDetails() {
//        return brandService.getAllBrandDetails();
//    }  
//    
//}

package com.sample.controller;

import com.sample.entity.Brand;
import com.sample.entity.BrandDTO;
import com.sample.entity.BrandDTO1;
import com.sample.entity.BrandDTO2;
import com.sample.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    
    
    @PostMapping("/addbrands")
    public ResponseEntity<Brand> addBrand(@RequestBody Brand brand) {
        Brand savedBrand = brandService.saveBrand(brand);
        return ResponseEntity.ok(savedBrand);
    }
    
    // POST to get all brands
    @PostMapping("/getallbrands")
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brands = brandService.getAllBrands();
        return ResponseEntity.ok(brands);
    }

    // POST to get brand by ID
 // POST method for retrieving a brand by ID
    @PostMapping("/getbrandbyid")
    public ResponseEntity<Brand> getBrandById(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        Optional<Brand> brand = brandService.getBrandById(id);
        if (brand.isPresent()) {
            return ResponseEntity.ok(brand.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST to create a brand
   

    // POST to update a brand
    @PostMapping("/updatebrand")
    public ResponseEntity<Brand> updateBrand(@RequestBody Brand updatedBrand) {
        Long id = updatedBrand.getId();
        Brand brand = brandService.updateBrand(id, updatedBrand);
        if (brand != null) {
            return ResponseEntity.ok(brand);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 // POST method for deleting a brand by ID
    @PostMapping("/deletebrand")
    public ResponseEntity<String> deleteBrand(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        brandService.deleteBrand(id);
        return ResponseEntity.ok("Brand with ID " + id + " has been deleted.");
    }
    
    // api to display only brandname and id
    @PostMapping("/listofbrandsnames")
    public ResponseEntity<List<BrandDTO>> getAllBrandNamesAndIds() {
    	List<BrandDTO> brands = brandService.getAllBrandNamesAndIds();
        return ResponseEntity.ok(brands);
       
    }
    
    //api to dispaly brand names by particular user
    @PostMapping("/brandsbyuserid")
    public ResponseEntity<List<BrandDTO1>> getAccessibleBrands(@RequestBody Map<String, Long> requestBody) {
        Long userId = requestBody.get("userId");
        List<BrandDTO1> brands = brandService.getAccessibleBrands(userId);
        return ResponseEntity.ok(brands);
    }
    
   // Api To Display All Brand Details 
    @PostMapping("/dispalyallbranddetails")
    public ResponseEntity<List<BrandDTO2>> getAllBrandDetails() {
    	List<BrandDTO2> brands = brandService.getAllBrandDetails();
    	return ResponseEntity.ok(brands);
    }
    

    
}
