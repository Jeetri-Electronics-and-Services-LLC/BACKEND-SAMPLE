package com.sample.repository;

import com.sample.entity.Primarypaymentmethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimarypaymentmethodRepository extends JpaRepository<Primarypaymentmethod, Long> {
    
}
