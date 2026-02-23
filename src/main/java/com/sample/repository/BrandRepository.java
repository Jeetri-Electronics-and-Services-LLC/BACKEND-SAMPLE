package com.sample.repository;

import com.sample.entity.Brand;
import com.sample.entity.BrandDTO1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
	
	//dispaly list of brandnames and id
	 List<Brand> findAllBy();
	 
	 // To display brand names & id based on userid
	 @Query("SELECT new com.sample.entity.BrandDTO1(b.id, b.name) FROM Brand b JOIN b.users u WHERE u.id = :userId")
	 List<BrandDTO1> findBrandsByUserId(@Param("userId") Long userId);

    
}
