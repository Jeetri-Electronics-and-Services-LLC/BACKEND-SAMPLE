package com.sample.repository;

import com.sample.entity.Createproduct;
import com.sample.entity.ProductDetailsDTO;
import com.sample.entity.ProductNameDTO;
import com.sample.entity.ProductsDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateproductRepository extends JpaRepository<Createproduct, Long> {
	
	List<Createproduct> findByName(String name); // Method to find products by name
	
	@Query("SELECT new com.sample.entity.ProductNameDTO(c.id, c.name) FROM Createproduct c")
    List<ProductNameDTO> findAllProductNames();
	
	@Query("SELECT new com.sample.entity.ProductDetailsDTO(c.description, c.msrp, c.salesprice, c.directdealerprice, "
		       + "c.promotionaldealerprice, c.indirectdealerprice, c.promotionalindirectdelarprice,c.distributorprice, c.promotionaldistributorprice,  c.companyprice) "
		       + "FROM Createproduct c WHERE c.name = :name")
		ProductDetailsDTO findProductDetailsByName(@Param("name") String name);
	
	@Query("SELECT new com.sample.entity.ProductsDTO(c.id, c.description, c.salesprice) "
		       + "FROM Createproduct c WHERE c.name = :name")
		ProductsDTO findProductDescriptionAndPriceByName(@Param("name") String name);
	
	// To Display Only Inventory Data
	 @Query("SELECT c FROM Createproduct c WHERE c.type_id = :typeId")
	    List<Createproduct> findByTypeId(@Param("typeId") String typeId);


	
}



//@Query("SELECT new com.sample.entity.ProductDetailsDTO(c.description, c.companyprice) FROM Createproduct c WHERE c.name = :name")
//ProductDetailsDTO findProductDetailsByName(@Param("name") String name);