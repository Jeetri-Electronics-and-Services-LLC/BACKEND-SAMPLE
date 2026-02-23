package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.entity.Salestaxes;

public interface SalestaxesRepository extends JpaRepository<Salestaxes, Long> {
	
	 @Query("SELECT s FROM Salestaxes s WHERE s.city = :city AND s.state = :state")
	    Salestaxes findTaxByCityAndState(String city, String state);
	
	
	
}
