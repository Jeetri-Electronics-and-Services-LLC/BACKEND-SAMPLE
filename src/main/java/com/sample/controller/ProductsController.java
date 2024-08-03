package com.sample.controller;


import com.sample.entity.Products;

import com.sample.entity.Services;
import com.sample.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;


	@GetMapping("/productsdata/get")
	public List<Products> getAllProductsData(){
		return productsService.getAllProducts();		
	}

	@PostMapping("/addproductsdata")
	public void addProducts(@RequestBody Products products) {
		productsService.addProducts(products);
    }
	@PutMapping("/updateproductsdata/{id}")
	public void updateProducts(@RequestBody Products products,@PathVariable int id) {
		productsService.updateProducts(products, id);
	}

	@DeleteMapping("/deleteproductsdata/{id}")
	public void deleteProducts(@PathVariable int id) {
		productsService.deleteProducts(id);
	}
}




