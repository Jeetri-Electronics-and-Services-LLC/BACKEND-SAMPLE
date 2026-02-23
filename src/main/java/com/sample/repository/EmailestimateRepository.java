package com.sample.repository;

import com.sample.entity.Emailestimate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailestimateRepository extends JpaRepository<Emailestimate, Long> {
   
}

