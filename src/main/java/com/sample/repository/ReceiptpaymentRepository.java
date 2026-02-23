package com.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sample.entity.Receiptpayment;

@Repository
public interface ReceiptpaymentRepository extends JpaRepository<Receiptpayment, Long> {
	
	@Query("SELECT rp.invoiceid FROM Receiptpayment rp WHERE rp.invoice.id = :invoiceId")
    List<String> findInvoiceNumbersByInvoiceId(Long invoiceId);
	
	@Query("SELECT r FROM Receiptpayment r WHERE r.invoice.id = :invoiceId")
    List<Receiptpayment> findByInvoiceId(@Param("invoiceId") Long invoiceId);
	
	 @Query("SELECT r.amount FROM Receiptpayment r WHERE r.invoiceid = :invoiceid")
	    List<String> findAmountsByInvoiceId(@Param("invoiceid") String invoiceid);
	 
	 
	 List<Receiptpayment> findByInvoice_Id(Long invoiceId);

}

