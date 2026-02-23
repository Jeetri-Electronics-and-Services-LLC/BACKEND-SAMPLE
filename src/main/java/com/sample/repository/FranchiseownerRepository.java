package com.sample.repository;

import com.sample.entity.Franchiseowner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseownerRepository extends JpaRepository<Franchiseowner, Long> {
    
}
