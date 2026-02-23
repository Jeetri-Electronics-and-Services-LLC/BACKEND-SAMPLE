//package com.sample.controller;
//
//import com.sample.entity.Products;
//import com.sample.service.ProductsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/products")
//public class ProductsController {
//
//    @Autowired
//    private ProductsService productsService;
//
//	@GetMapping("/productsdata/get")
//	public List<Products> getAllProductsData(){
//		return productsService.getAllProducts();		
//	}
//
//	@PostMapping("/addproductsdata")
//	public void addProducts(@RequestBody Products products) {
//		productsService.addProducts(products);
//    }
//	
//	@PutMapping("/updateproductsdata/{id}")
//	public void updateProducts(@RequestBody Products products,@PathVariable int id) {
//		productsService.updateProducts(products, id);
//	}
//
//	@DeleteMapping("/deleteproductsdata/{id}")
//	public void deleteProducts(@PathVariable int id) {
//		productsService.deleteProducts(id);
//	}
//}












package com.sample.controller;

import com.sample.entity.Products;
import com.sample.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    // Use POST for retrieving all products (unconventional, but following your request)
    @PostMapping("/productsdata/get")
    public ResponseEntity<List<Products>> getAllProductsData() {
        List<Products> products = productsService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Use POST for adding products
    @PostMapping("/addproductsdata")
    public ResponseEntity<String> addProducts(@RequestBody Products products) {
        productsService.addProducts(products);
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }
    
    // Use POST for updating products
    @PostMapping("/updateproductsdata/{id}")
    public ResponseEntity<String> updateProducts(@RequestBody Products products, @PathVariable int id) {
        productsService.updateProducts(products, id);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    // Use POST for deleting products
    @PostMapping("/deleteproductsdata")
    public ResponseEntity<String> deleteProducts(@RequestBody Map<String, Object> request) {
    	int id = Integer.parseInt(request.get("id").toString());
    	productsService.deleteProducts(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
    
   
}
