package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}