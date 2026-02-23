package com.sample.repository;

import com.sample.entity.Inventoryquantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryquantityRepository extends JpaRepository<Inventoryquantity, Long> {
}