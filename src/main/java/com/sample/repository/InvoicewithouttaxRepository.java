package com.sample.repository;

import com.sample.entity.Invoicewithouttax;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicewithouttaxRepository extends JpaRepository<Invoicewithouttax, Long> {

	@Query("SELECT iwt FROM Invoicewithouttax iwt WHERE iwt.invoice.id = :invoiceId")
    List<Invoicewithouttax> findByInvoiceId(@Param("invoiceId") Long invoiceId);
	
}
