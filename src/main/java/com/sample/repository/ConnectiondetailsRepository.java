package com.sample.repository;

import com.sample.entity.Connectiondetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectiondetailsRepository extends JpaRepository<Connectiondetails, Long> {
}
