package com.sample.repository;

import com.sample.entity.Estimate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstimateRepository extends JpaRepository<Estimate, Long> {
	
	Optional<Estimate> findById(Long id);
}
