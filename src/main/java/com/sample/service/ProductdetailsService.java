package com.sample.service;


import com.sample.entity.Productdetails;
import com.sample.repository.ProductdetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductdetailsService {

    @Autowired
    private ProductdetailsRepository productdetailsRepository;

    // Get all product details
    public List<Productdetails> getAllProductDetails() {
        return productdetailsRepository.findAll();
    }

    // Get product details by ID
    public Optional<Productdetails> getProductDetailsById(Long id) {
        return productdetailsRepository.findById(id);
    }

    // Save or update product details
    public Productdetails saveOrUpdateProductDetails(Productdetails productdetails) {
        return productdetailsRepository.save(productdetails);
    }

    // Delete product details by ID
    public void deleteProductDetails(Long id) {
        productdetailsRepository.deleteById(id);
    }
}




