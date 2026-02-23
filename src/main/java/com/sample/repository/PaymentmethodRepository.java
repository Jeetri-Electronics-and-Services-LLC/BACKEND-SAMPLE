package com.sample.repository;

import com.sample.entity.Paymentmethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentmethodRepository extends JpaRepository<Paymentmethod, Long> {
    // You can add custom query methods if needed
}
