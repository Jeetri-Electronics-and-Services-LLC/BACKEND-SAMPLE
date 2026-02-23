package com.sample.service;



import com.sample.entity.Bundle;
import com.sample.entity.Createproduct;
import com.sample.entity.Products;
import com.sample.repository.BundleRepository;
import com.sample.repository.CreateproductRepository;
import com.sample.repository.ProductBundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductBundleService {

    @Autowired
    private ProductBundleRepository productBundleRepository;
    
    @Autowired
    private BundleRepository bundleRepository;
    
    @Autowired
    private CreateproductRepository createproductRepository;

 // POST method to get a list of product and bundle names, request body is optional
    public List<Map<String, Object>> getAllCreateProductIdsAndNames() {
        List<Object[]> results = productBundleRepository.findAllCreateProductIdsAndNames();
        List<Map<String, Object>> createProductList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> productMap = new LinkedHashMap<>(); // Use LinkedHashMap to preserve order
            productMap.put("id", result[0]);
            productMap.put("name", result[1]);
            createProductList.add(productMap);
        }
        return createProductList;
    }

    public List<Map<String, Object>> getAllBundleIdsAndNames() {
        List<Object[]> results = productBundleRepository.findAllBundleIdsAndNames();
        List<Map<String, Object>> bundleList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> bundleMap = new LinkedHashMap<>(); // Use LinkedHashMap to preserve order
            bundleMap.put("id", result[0]);
            bundleMap.put("name", result[1]);
            bundleList.add(bundleMap);
        }
        return bundleList;
    }

    public List<Map<String, Object>> getAllProductAndBundleIdsAndNames() {
        List<Map<String, Object>> combinedList = new ArrayList<>();

        // Fetch product and bundle data
        combinedList.addAll(getAllCreateProductIdsAndNames());
        combinedList.addAll(getAllBundleIdsAndNames());

        return combinedList;
    }
    
    
    
    
    public Map<String, Object> getProductDetailsByName(String productName) {
        List<Createproduct> products = createproductRepository.findByName(productName); // Implement this query in the repository

        if (products.isEmpty()) {
            return null; // Return null if not found
        }

        Createproduct product = products.get(0); // Assuming you want the first match
        Map<String, Object> response = new LinkedHashMap<>(); // Maintain insertion order

        response.put("id", product.getId()); // ID appears first
        response.put("salesprice", product.getSalesprice());
        response.put("msrp", product.getMsrp());
        response.put("promotionaldealerprice", product.getPromotionaldealerprice());
        response.put("companyprice", product.getCompanyprice());
        response.put("indirectdealerprice", product.getIndirectdealerprice());
        response.put("distributorprice", product.getDistributorprice());
        response.put("description", product.getDescription());
        response.put("promotionaldistributorprice", product.getPromotionaldistributorprice());
        response.put("directdealerprice", product.getDirectdealerprice());
        response.put("promotionalindirectdelarprice", product.getPromotionalindirectdelarprice());

        return response; // Return product details
    }

    public Map<String, Object> getBundleDetailsByName(String bundleName) {
        List<Object[]> bundleData = productBundleRepository.findBundleDetailsByName(bundleName);

        if (bundleData.isEmpty()) {
            return null; // Return null if not found
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("bundleId", bundleData.get(0)[0]); // Bundle ID
        response.put("bundleName", bundleData.get(0)[1]);
        response.put("bundleDescription", bundleData.get(0)[2]);

        // Prepare product list
        List<Map<String, Object>> productsList = new ArrayList<>();
        for (Object[] row : bundleData) {
            Map<String, Object> productMap = new LinkedHashMap<>();
            productMap.put("productId", row[3]); // Product ID
            productMap.put("productName", row[4]);
            productMap.put("productDescription", row[5]);
            productMap.put("productSalesprice", row[6]);
            productsList.add(productMap);
        }

        response.put("products", productsList); // Add products list to the response
        return response; // Return bundle details
    }

}

