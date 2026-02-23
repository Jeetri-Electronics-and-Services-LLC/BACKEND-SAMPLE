package com.sample.service;

import com.sample.entity.Products;
import com.sample.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;
   
        /*Read operation*/
        public List<Products> getAllProducts() {
            return productsRepository.findAll();
        }
         
        /*Create operation*/
        public void addProducts(Products products) {
            Products newProducts = new Products();
            newProducts.setName(products.getName());
            newProducts.setDescription(products.getDescription());
            newProducts.setQty(products.getQty());
            newProducts.setSalesprice(products.getSalesprice());
            newProducts.setAmount(products.getAmount());
            productsRepository.save(newProducts);
            
            System.out.println("Products data added successfully");
        }
    
        /*Update operation*/
        public void updateProducts(Products updatedProducts, long id) {
            Products existingProducts = productsRepository.findById(id).orElse(null);
            
            if (existingProducts != null) {
            	
				existingProducts.setName(updatedProducts.getName());
				existingProducts.setDescription(updatedProducts.getDescription());
				existingProducts.setQty(updatedProducts.getQty());
				existingProducts.setSalesprice(updatedProducts.getSalesprice());
				existingProducts.setAmount(updatedProducts.getAmount());
               
            	productsRepository.save(existingProducts);
                System.out.println("Products data updated successfully");
            }
        }

        /*Delete operation*/

        public void deleteProducts(long id) {
        	productsRepository.deleteById(id);
        	System.out.println("products Data Deleted Successfully");

    }
}
