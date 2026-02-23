//package com.sample.controller;
//
//import com.sample.entity.Product;
//import com.sample.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/product")
//public class ProductController {
//
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping("/getallproduct")
//    public List<Product> getAllProducts() {
//        return productService.getAllProducts();
//    }
//
//    @GetMapping("/getproduct/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
//        Optional<Product> product = productService.getProductById(id);
//        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addproduct")
//    public Product createProduct(@RequestBody Product product) {
//        return productService.saveProduct(product);
//    }
//
//    @PutMapping("/updateproduct/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
//        try {
//            Product updatedProduct = productService.updateProduct(id, productDetails);
//            return ResponseEntity.ok(updatedProduct);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/deleteproduct/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
//        try {
//            productService.deleteProduct(id);
//            return ResponseEntity.noContent().build();
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}















package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Product;
import com.sample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/getallproduct")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/getproductbyid")
    public ResponseEntity<Product> getProductById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   
    @PostMapping("/addproduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @PostMapping("/updateproduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	// Extract name from request body
        String product = request.get("product").toString();

        // Retrieve the existing city and update its name
        Product existingProduct = productService.getProductById(id).orElse(null);
        if (existingProduct == null) {
            return ResponseEntity.notFound().build();
        }

        existingProduct.setProduct(product);
        Product updatedProduct = productService.updateProduct(id, existingProduct);

        return ResponseEntity.ok(updatedProduct);
    }
    

    @PostMapping("/deleteproduct")
    public ResponseEntity<Void> deleteProduct(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

   
}

