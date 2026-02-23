package com.sample.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.entity.Category;
import com.sample.entity.CategoryDTO1;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	//display list of category id,names based on brandid
	@Query("SELECT new com.sample.entity.CategoryDTO1(c.id, c.name) FROM Category c JOIN c.brands b WHERE b.id = :brandId")
    List<CategoryDTO1> findCategoryIdsAndNamesByBrandId(int brandId);
		
}
