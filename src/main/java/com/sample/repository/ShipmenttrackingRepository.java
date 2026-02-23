package com.sample.repository;

import com.sample.entity.Shipmenttracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmenttrackingRepository extends JpaRepository<Shipmenttracking, Long> {
    
}
