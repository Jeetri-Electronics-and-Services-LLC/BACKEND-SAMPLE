package com.sample.repository;

import com.sample.entity.Bundle;
<<<<<<< HEAD

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BundleRepository extends JpaRepository<Bundle, Long> {
	
	List<Bundle> findByName(String name); // Method to find bundles by name
	
//	@Query("SELECT b FROM Bundle b JOIN FETCH b.products WHERE b.name = :name")
//    Optional<Bundle> findByNameWithProducts(@Param("name") String name);
	
	@Query("SELECT b FROM Bundle b JOIN FETCH b.products WHERE b.name = :name")
    Optional<Bundle> findByNameWithProducts(@Param("name") String name);
	
	@Query("SELECT b FROM Bundle b JOIN FETCH b.products WHERE b.id = :id")
	Optional<Bundle> findByIdWithProducts(@Param("id") Long id);
     
	
	@Query("SELECT b.name AS bundleName, b.description AS bundleDescription, p.name AS productName, p.description AS productDescription, p.salesprice AS productSalesPrice " +
	           "FROM Bundle b JOIN b.products p WHERE b.name = :bundleName")
	    List<Object[]> findBundleDetailsByName(String bundleName);
	
=======
import org.springframework.data.jpa.repository.JpaRepository;

public interface BundleRepository extends JpaRepository<Bundle, Long> {
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
}
