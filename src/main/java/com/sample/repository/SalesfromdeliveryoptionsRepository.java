package com.sample.repository;

import com.sample.entity.Salesfromdeliveryoptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesfromdeliveryoptionsRepository extends JpaRepository<Salesfromdeliveryoptions, Long> {
   
}
