package com.sample.repository;



import com.sample.entity.Createproduct;
import com.sample.entity.Bundle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductBundleRepository extends CrudRepository<Createproduct, Long> {

	// Query to get list of Createproduct IDs and names
    @Query("SELECT p.id, p.name FROM Createproduct p")
    List<Object[]> findAllCreateProductIdsAndNames();

    // Query to get list of Bundle IDs and names
    @Query("SELECT b.id, b.name FROM Bundle b")
    List<Object[]> findAllBundleIdsAndNames();
    
 // Query to get details based on Createproduct name
    @Query("SELECT p.id, p.name, p.description, p.msrp, p.salesprice, p.directdealerprice, p.promotionaldealerprice, " +
           "p.indirectdealerprice, p.promotionalindirectdelarprice, p.distributorprice, p.promotionaldistributorprice, p.companyprice " +
           "FROM Createproduct p WHERE p.name = :productName")
    List<Object[]> findProductDetailsByName(String productName);

    // Query to get details based on Bundle name and list of products
    @Query("SELECT b.id, b.name, b.description, p.productid, p.name, p.description, p.salesprice " +
    	       "FROM Bundle b JOIN b.products p WHERE b.name = :bundleName")
    	List<Object[]> findBundleDetailsByName(String bundleName);

}

