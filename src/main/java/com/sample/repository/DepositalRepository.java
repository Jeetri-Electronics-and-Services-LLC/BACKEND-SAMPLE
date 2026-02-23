package com.sample.repository;

import com.sample.entity.Deposital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositalRepository extends JpaRepository<Deposital, Long> {
    
}
