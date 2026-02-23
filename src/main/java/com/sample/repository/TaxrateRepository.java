package com.sample.repository;

import com.sample.entity.Taxrate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxrateRepository extends JpaRepository<Taxrate, Long> {
    
}
