package com.sample.repository;




import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.entity.Estimate;
import com.sample.entity.EstimateDTOes;
import com.sample.entity.ExpenseDTOes;
import com.sample.entity.InvoiceDTOes;
import com.sample.entity.ReceiptpaymentDTOes;

import java.util.List;

@Repository
public interface EstimateInvoiceRepository extends JpaRepository<Estimate, Long> {

    @Query("SELECT new com.sample.entity.EstimateDTOes(e.id, e.ordertype, e.customerdisplayname_id, e.status_id, e.createddate, e.total, e.memoonstatement) " +
           "FROM Estimate e JOIN e.customer c WHERE c.customerdisplayname = :customerdisplayname")
    List<EstimateDTOes> findEstimatesByCustomerDisplayName(@Param("customerdisplayname") String customerdisplayname);

    @Query("SELECT new com.sample.entity.InvoiceDTOes(i.id, i.ordertype, i.customerdisplayname_id, i.status_id, i.createddate, i.total, i.balanceamount , i.memoonstatement) " +
           "FROM Invoice i JOIN i.customer c WHERE c.customerdisplayname = :customerdisplayname")
    List<InvoiceDTOes> findInvoicesByCustomerDisplayName(@Param("customerdisplayname") String customerdisplayname);
    
    @Query("SELECT new com.sample.entity.ExpenseDTOes(p.id, p.ordertype, p.customerdisplayname_id, p.amount, p.createddate) " +
            "FROM Expense p JOIN p.customer c WHERE c.customerdisplayname = :customerdisplayname")
     List<ExpenseDTOes> findExpensesByCustomerDisplayName(@Param("customerdisplayname") String customerdisplayname);
    
    @Query("SELECT new com.sample.entity.ReceiptpaymentDTOes(r.id, r.ordertype, r.customerdisplayname_id, r.amount, r.createddate) " +
            "FROM Receiptpayment r JOIN r.customer c WHERE c.customerdisplayname = :customerdisplayname")
     List<ReceiptpaymentDTOes> findReceiptpaymentByCustomerDisplayName(@Param("customerdisplayname") String customerdisplayname);


}





