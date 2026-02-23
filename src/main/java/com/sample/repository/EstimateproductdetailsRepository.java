package com.sample.repository;

import com.sample.entity.Estimateproductdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstimateproductdetailsRepository extends JpaRepository<Estimateproductdetails, Long> {
    
}
