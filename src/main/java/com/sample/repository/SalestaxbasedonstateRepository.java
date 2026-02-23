package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.entity.Salestaxbasedonstate;

public interface SalestaxbasedonstateRepository extends JpaRepository<Salestaxbasedonstate, Long> {
	
	//Display Salestax Based On Given State
    Salestaxbasedonstate findByState(String state);
   
}