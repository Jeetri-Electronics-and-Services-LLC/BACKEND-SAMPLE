package com.sample.repository;


	import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.entity.Products;

	public interface ProductsRepository extends JpaRepository<Products, Long> {
	}


