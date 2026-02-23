//package com.sample.repository;
//
//import com.sample.entity.Invoice;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
//	
////	@Query("SELECT i FROM Invoice i LEFT JOIN FETCH i.products WHERE i.id = :invoiceId")
////	Invoice findInvoiceWithProducts(@Param("invoiceId") Long invoiceId);
//	
//}

package com.sample.repository;

import com.sample.entity.Customer;
import com.sample.entity.CustomerDetails;
import com.sample.entity.Invoice;
import com.sample.entity.InvoiceDTO;
import com.sample.entity.InvoiceRequest;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
    @Query("SELECT i FROM Invoice i LEFT JOIN FETCH i.products WHERE i.id = :invoiceId")
    Invoice findInvoiceWithProducts(@Param("invoiceId") Long invoiceId);
    
    @Query("SELECT i FROM Invoice i LEFT JOIN FETCH i.products WHERE i.id = :id")
    Invoice findInvoiceByIdWithProducts(Long id);
    
    //to display only particular details of invoicedto1 and productdetailsdto1 based on id 
    @Query("SELECT i FROM Invoice i LEFT JOIN FETCH i.products WHERE i.id = :invoiceId")
    Invoice findByIdWithProducts(@Param("invoiceId") Long invoiceId);
        
    @Query("SELECT i FROM Invoice i LEFT JOIN FETCH i.products")
    List<Invoice> findAllInvoicesWithProducts();
         
    @Query("SELECT new com.sample.entity.InvoiceDTO(i.id, i.ordertype, i.customerdisplayname_id,   i.status_id, i.createddate, i.total, i.deposit, i.balanceamount, i.memoonstatement) " +
    	       "FROM Invoice i JOIN i.customer c " +
    	       "WHERE c.customerdisplayname = :customerdisplayname")
    	List<InvoiceDTO> findInvoicesByCustomerDisplayName(@Param("customerdisplayname") String customerdisplayname);	
    
 // Query by id (which is Long)
    Optional<Invoice> findById(Long id);
}
