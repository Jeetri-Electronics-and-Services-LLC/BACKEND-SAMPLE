package com.sample.repository;

import com.sample.entity.Invoicestatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicestatusRepository extends JpaRepository<Invoicestatus, Long> {
}
