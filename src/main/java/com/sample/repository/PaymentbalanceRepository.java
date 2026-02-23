package com.sample.repository;

import com.sample.entity.Paymentbalance;
import com.sample.entity.Receiptpayment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentbalanceRepository extends JpaRepository<Paymentbalance, Long> {
    
	
}
