package com.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.entity.Productdetails;

@Repository
public interface ProductdetailsRepository extends JpaRepository<Productdetails, Long> {

    List<Productdetails> findByInvoiceId(Long invoiceId);
    
    
    
    

}



