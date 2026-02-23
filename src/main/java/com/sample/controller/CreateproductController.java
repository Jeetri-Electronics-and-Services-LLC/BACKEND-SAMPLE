//package com.sample.controller;
//
//
//import com.sample.entity.Createproduct;
//import com.sample.entity.ProductDetailsDTO;
//import com.sample.entity.ProductNameDTO;
//import com.sample.entity.ProductsDTO;
//import com.sample.service.CreateproductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/createproducts")
//public class CreateproductController {
//
//    @Autowired
//    private CreateproductService createproductService;
//
//    @GetMapping("/getallcreateproducts")
//    public List<Createproduct> getAllProducts() {
//        return createproductService.getAllProducts();
//    }
//    
//
//
//    @GetMapping("/getallcreateproductsid/{id}")
//    public ResponseEntity<Createproduct> getProductById(@PathVariable Long id) {
//        Optional<Createproduct> product = createproductService.getProductById(id);
//        if (product.isPresent()) {
//            return ResponseEntity.ok(product.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//
//    
//    @PostMapping("/postallcreateproducts")
//    public Createproduct createProduct(@RequestBody Createproduct createproduct) {
//        return createproductService.createProduct(createproduct);
//    }
//
//    @PutMapping("/updateallcreateproducts/{id}")
//    public ResponseEntity<Createproduct> updateProduct(@PathVariable Long id, @RequestBody Createproduct updatedProduct) {
//        Createproduct product = createproductService.updateProduct(id, updatedProduct);
//        if (product != null) {
//            return ResponseEntity.ok(product);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/deleteallcreateproducts/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
//        createproductService.deleteProduct(id);
//        return ResponseEntity.noContent().build();
//    }
//    
////    public CreateproductController(CreateproductService createproductService) {
////        this.createproductService = createproductService;
////    }
//
//    @GetMapping("/listofproducts")
//    public List<ProductNameDTO> getAllProductNames() {
//        return createproductService.getAllProductNames();
//    }
////    
//
//
////    
//    @GetMapping("/details/{name}")
//    public ProductDetailsDTO getProductDetails(@PathVariable String name) {
//        return createproductService.getProductDetailsByName(name);
//    }
//    
//    @GetMapping("/productsdetails/{name}")
//    public ResponseEntity<ProductsDTO> getProductsByName(@PathVariable String name) {
//        ProductsDTO products = createproductService.getProductDescriptionAndPrice(name);
//        if (products != null) {
//            return ResponseEntity.ok(products);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//





//2
package com.sample.controller;

import com.sample.entity.CreateProductDTO;
import com.sample.entity.CreateProductDTO1;
import com.sample.entity.Createproduct;
import com.sample.entity.ProductDetailsDTO;
import com.sample.entity.ProductNameDTO;
import com.sample.entity.ProductsDTO;
import com.sample.service.CreateproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/createproducts")
public class CreateproductController {

    @Autowired
    private CreateproductService createproductService;

    // POST method for retrieving all products
    @PostMapping("/getallcreateproducts")
    public ResponseEntity<List<Createproduct>> getAllProducts(@RequestBody(required = false) Object request) {
        List<Createproduct> products = createproductService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // POST method for retrieving a product by ID
    @PostMapping("/getproductbyid")
    public ResponseEntity<Createproduct> getProductById(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        Optional<Createproduct> product = createproductService.getProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST method for creating a product
    @PostMapping("/postallcreateproductssaved")
    public Createproduct createProduct(@RequestBody Createproduct createproduct) {
        return createproductService.createProduct(createproduct);
    }

    // POST method for updating a product
    @PostMapping("/update/{id}")
    public ResponseEntity<Createproduct> updateProduct(
        @PathVariable Long id,
        @RequestBody Createproduct productDetails
    ) {
        // Call the service to update the product
        Createproduct updatedProduct = createproductService.updateProduct(id, productDetails);
        // Return the updated product in response
        return ResponseEntity.ok(updatedProduct);
    }
    
   

    // POST method for deleting a product
    @PostMapping("/deleteproduct")
    public ResponseEntity<Void> deleteProduct(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        createproductService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    


 // POST method for retrieving product names 
    @PostMapping("/listofproducts")
    public ResponseEntity<List<ProductNameDTO>> getAllProductNames(@RequestBody(required = false) Object requestBody) {
        // Directly fetch all product names without any filtering based on companyId
        List<ProductNameDTO> productNames = createproductService.getAllProductNames();
        return ResponseEntity.ok(productNames);
    }


    // POST method for retrieving product details by name
    @PostMapping("/details")
    public ResponseEntity<ProductDetailsDTO> getProductDetails(@RequestBody Map<String, String> requestBody) {
        String name = requestBody.get("name");
        ProductDetailsDTO productDetails = createproductService.getProductDetailsByName(name);
        if (productDetails != null) {
            return ResponseEntity.ok(productDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST method for retrieving description and price by product name
    @PostMapping("/productsdetails")
    public ResponseEntity<ProductsDTO> getProductsByName(@RequestBody Map<String, String> requestBody) {
        String name = requestBody.get("name");
        ProductsDTO products = createproductService.getProductDescriptionAndPrice(name);
        if (products != null) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
 // To Display Only Inventory Data
    @PostMapping("/inventory")
    public ResponseEntity<List<CreateProductDTO>> getInventoryProducts() {
        List<CreateProductDTO> products = createproductService.getInventoryProducts();
        return ResponseEntity.ok(products);
    }
    
    // Add Product DEtails
    @PostMapping("/addcreateproductdetailsonly")
    public ResponseEntity<Createproduct> addCreateProduct(@RequestBody CreateProductDTO1 createProductDTO) {
        Createproduct createproduct = createproductService.addCreateProduct(createProductDTO);
        return ResponseEntity.ok(createproduct);
    }
}










