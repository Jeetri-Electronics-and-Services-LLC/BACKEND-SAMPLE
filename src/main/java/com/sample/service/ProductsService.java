package com.sample.service;

<<<<<<< HEAD
import com.sample.entity.Products;
import com.sample.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
=======
import com.sample.entity.Inventory;
import com.sample.entity.Products;
import com.sample.entity.ReqBody;
import com.sample.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;
<<<<<<< HEAD
   
=======

    
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
        /*Read operation*/
        public List<Products> getAllProducts() {
            return productsRepository.findAll();
        }
<<<<<<< HEAD
         
        /*Create operation*/
        public void addProducts(Products products) {
            Products newProducts = new Products();
            newProducts.setName(products.getName());
            newProducts.setDescription(products.getDescription());
            newProducts.setQty(products.getQty());
            newProducts.setSalesprice(products.getSalesprice());
            newProducts.setAmount(products.getAmount());
=======
    
      
        /*Create operation*/
        public void addProducts(Products products) {
            Products newProducts = new Products();
            newProducts.setProduct(products.getProduct());
            newProducts.setQty(products.getQty());
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
            productsRepository.save(newProducts);
            
            System.out.println("Products data added successfully");
        }
    
        /*Update operation*/
        public void updateProducts(Products updatedProducts, long id) {
            Products existingProducts = productsRepository.findById(id).orElse(null);
            
            if (existingProducts != null) {
            	
<<<<<<< HEAD
				existingProducts.setName(updatedProducts.getName());
				existingProducts.setDescription(updatedProducts.getDescription());
				existingProducts.setQty(updatedProducts.getQty());
				existingProducts.setSalesprice(updatedProducts.getSalesprice());
				existingProducts.setAmount(updatedProducts.getAmount());
=======
				existingProducts.setProduct(updatedProducts.getProduct());
				existingProducts.setQty(updatedProducts.getQty());
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
               
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
<<<<<<< HEAD
=======




>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
