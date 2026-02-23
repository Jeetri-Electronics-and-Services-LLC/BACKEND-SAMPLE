//package com.sample.service;
//
//
//
//import com.sample.entity.Invoice;
//import com.sample.entity.InvoiceDTOs;
//import com.sample.entity.ProductdetailsDTOs;
//import com.sample.entity.Estimate;
//import com.sample.entity.EstimateDTOs;
//import com.sample.entity.EstimateProductDetailsDTOs;
//import com.sample.repository.InvoiceRepository;
//import com.sample.repository.EstimateRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class OrderService {
//
//    @Autowired
//    private InvoiceRepository invoiceRepository;
//
//    @Autowired
//    private EstimateRepository estimateRepository;
//    
//    
//
//
//    
//    
//    public Optional<?> getOrderDetails(String ordertype, Long id) {
//        if ("invoice".equalsIgnoreCase(ordertype)) {
//            return invoiceRepository.findById(id).map(this::convertToInvoiceDTOs);
//        } else if ("estimate".equalsIgnoreCase(ordertype)) {
//            return estimateRepository.findById(id).map(this::convertToEstimateDTOs);
//        } else {
//            return Optional.empty();
//        }
//    }
//
//    private InvoiceDTOs convertToInvoiceDTOs(Invoice invoice) {
//        InvoiceDTOs dto = new InvoiceDTOs();
//        dto.setId(invoice.getId());
//        dto.setOrdertype(invoice.getOrdertype());
//        dto.setCustomerdisplayname_id(invoice.getCustomerdisplayname_id());
//        dto.setEmail(invoice.getEmail());
//        dto.setCc(invoice.getCc());
//        dto.setBcc(invoice.getBcc());
//        dto.setBillto(invoice.getBillto());
//        dto.setShipto(invoice.getShipto());
//        dto.setShipvia(invoice.getShipvia());
//        dto.setShippingdate(invoice.getShippingdate());
//        dto.setTrackingno(invoice.getTrackingno());
//        dto.setTerms_id(invoice.getTerms_id());
//        dto.setInvoicedate(invoice.getInvoicedate());
//        dto.setDuedate(invoice.getDuedate());
//        dto.setStatus_id(invoice.getStatus_id());
//        dto.setFranchiseowner_id(invoice.getFranchiseowner_id());
//        dto.setProcessedon(invoice.getProcessedon());
//        dto.setCreateddate(invoice.getCreateddate());
//        dto.setCity_id(invoice.getCity_id());
//        dto.setState_id(invoice.getState_id());
//        dto.setTermsandconditions(invoice.getTermsandconditions());
//        dto.setLocation_id(invoice.getLocation_id());
//        dto.setSubtotal(invoice.getSubtotal());
//        dto.setDiscount(invoice.getDiscount());
//        dto.setTaxablesubtotal(invoice.getTaxablesubtotal());
//        dto.setTaxrates_id(invoice.getTaxrates_id());
//        dto.setSalestax(invoice.getSalestax());
//        dto.setTotal(invoice.getTotal());
//        dto.setDeposit(invoice.getDeposit());
//        dto.setPaycheckto(invoice.getPaycheckto());
//        dto.setBalanceamount(invoice.getBalanceamount());
//        dto.setNotetocustomer(invoice.getNotetocustomer());
//        dto.setInternalcustomernotes(invoice.getInternalcustomernotes());
//        dto.setMemoonstatement(invoice.getMemoonstatement());
//
//        dto.setProducts(invoice.getProducts().stream().map(product -> {
//            ProductdetailsDTOs productDTO = new ProductdetailsDTOs();
//            productDTO.setId(product.getId());
//            productDTO.setName(product.getName());
//            productDTO.setDescription(product.getDescription());
//            productDTO.setQty(product.getQty());
//            productDTO.setSalesprice(product.getSalesprice());
//            productDTO.setAmount(product.getAmount());
//            productDTO.setSalestaxes_id(product.getSalestaxes_id());
//            return productDTO;
//        }).collect(Collectors.toList()));
//
//        return dto;
//    }
//
//    private EstimateDTOs convertToEstimateDTOs(Estimate estimate) {
//        EstimateDTOs dto = new EstimateDTOs();
//        dto.setId(estimate.getId());
//        dto.setOrdertype(estimate.getOrdertype());
//        dto.setCustomerdisplayname_id(estimate.getCustomerdisplayname_id());
//        dto.setEmail(estimate.getEmail());
//        dto.setCc(estimate.getCc());
//        dto.setBcc(estimate.getBcc());
//        dto.setBillto(estimate.getBillto());
//        dto.setShipto(estimate.getShipto());
//        dto.setAcceptedby(estimate.getAcceptedby());
//        dto.setEstimatedate(estimate.getEstimatedate());
//        dto.setStatus_id(estimate.getStatus_id());
//        dto.setFranchiseowner_id(estimate.getFranchiseowner_id());
//        dto.setCreatedon(estimate.getCreatedon());
//        dto.setCreateddate(estimate.getCreateddate());
//        dto.setCity_id(estimate.getCity_id());
//        dto.setState_id(estimate.getState_id());
//        dto.setLocation_id(estimate.getLocation_id());
//        dto.setSubtotal(estimate.getSubtotal());
//        dto.setDiscount(estimate.getDiscount());
//        dto.setTaxablesubtotal(estimate.getTaxablesubtotal());
//        dto.setTaxrates_id(estimate.getTaxrates_id());
//        dto.setSalestax(estimate.getSalestax());
//        dto.setTotal(estimate.getTotal());
//        dto.setPaycheckto(estimate.getPaycheckto());
//        dto.setNotetocustomer(estimate.getNotetocustomer());
//        dto.setInternalcustomernotes(estimate.getInternalcustomernotes());
//        dto.setMemoonstatement(estimate.getMemoonstatement());
//
//        dto.setEstimateProductDetails(estimate.getEstimateProductDetails().stream().map(product -> {
//            EstimateProductDetailsDTOs productDTO = new EstimateProductDetailsDTOs();
//          productDTO.setId(product.getId());
//          productDTO.setName(product.getName());
//          productDTO.setDescription(product.getDescription());
//          productDTO.setQty(product.getQty());
//          productDTO.setSalesprice(product.getSalesprice());
//          productDTO.setAmount(product.getAmount());
//          productDTO.setSalestaxes_id(product.getSalestaxes_id());
//            
//            return productDTO;
//        }).collect(Collectors.toList()));
//
//        return dto;
//    }
//    
//}
//










package com.sample.service;

import com.sample.entity.Invoice;
import com.sample.entity.InvoiceDTOs;
import com.sample.entity.InvoicewithouttaxDTOs;
import com.sample.entity.ProductdetailsDTOs;
import com.sample.entity.ReceiptPaymentDTO1;
import com.sample.entity.Estimate;
import com.sample.entity.EstimateDTOs;
import com.sample.entity.EstimateProductDetailsDTOs;
import com.sample.entity.EstimateWithoutTaxDTOs;
import com.sample.repository.InvoiceRepository;
import com.sample.repository.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;
import com.sample.repository.ReceiptpaymentRepository;
import com.sample.repository.ExpenseRepository;
import com.sample.entity.Receiptpayment;
import com.sample.entity.Expense;
import com.sample.entity.ExpenseDTO;

@Service
public class OrderService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private EstimateRepository estimateRepository;

    @Autowired
    private ReceiptpaymentRepository receiptPaymentRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public Optional<?> getOrderDetails(String ordertype, Long id) {
        if ("invoice".equalsIgnoreCase(ordertype)) {
            return invoiceRepository.findById(id).map(this::convertToInvoiceDTOs);
        } else if ("estimate".equalsIgnoreCase(ordertype)) {
            return estimateRepository.findById(id).map(this::convertToEstimateDTOs);
        } else if ("receiptpayment".equalsIgnoreCase(ordertype)) {
            return receiptPaymentRepository.findById(id).map(this::convertToReceiptPaymentDTO1);
        } else if ("expense".equalsIgnoreCase(ordertype)) {
            return expenseRepository.findById(id).map(this::convertToExpenseDTO);
        } else {
            return Optional.empty();
        }
    }
    
    private InvoiceDTOs convertToInvoiceDTOs(Invoice invoice) {
      InvoiceDTOs dto = new InvoiceDTOs();
      dto.setId(invoice.getId());
      dto.setOrdertype(invoice.getOrdertype());
      dto.setCustomerdisplayname_id(invoice.getCustomerdisplayname_id());
      dto.setEmail(invoice.getEmail());
      dto.setCc(invoice.getCc());
      dto.setBcc(invoice.getBcc());
      dto.setBillto(invoice.getBillto());
      dto.setShipto(invoice.getShipto());
      dto.setShipvia(invoice.getShipvia());
      dto.setShippingdate(invoice.getShippingdate());
      dto.setTrackingno(invoice.getTrackingno());
      dto.setTerms_id(invoice.getTerms_id());
      dto.setInvoicedate(invoice.getInvoicedate());
      dto.setDuedate(invoice.getDuedate());
      dto.setStatus_id(invoice.getStatus_id());
      dto.setFranchiseowner_id(invoice.getFranchiseowner_id());
      dto.setProcessedon(invoice.getProcessedon());
      dto.setCreateddate(invoice.getCreateddate());
      dto.setCity_id(invoice.getCity_id());
      dto.setState_id(invoice.getState_id());
      dto.setTermsandconditions(invoice.getTermsandconditions());
      
      dto.setSubtotal(invoice.getSubtotal());
      dto.setDiscount(invoice.getDiscount());
      dto.setTaxablesubtotal(invoice.getTaxablesubtotal());
      dto.setTaxrates_id(invoice.getTaxrates_id());
      dto.setSalestax(invoice.getSalestax());
      dto.setTotal(invoice.getTotal());
      dto.setDeposit(invoice.getDeposit());
      dto.setPaycheckto(invoice.getPaycheckto());
      dto.setBalanceamount(invoice.getBalanceamount());
      dto.setNotetocustomer(invoice.getNotetocustomer());
      dto.setInternalcustomernotes(invoice.getInternalcustomernotes());
      dto.setMemoonstatement(invoice.getMemoonstatement());

      dto.setProducts(invoice.getProducts().stream().map(product -> {
          ProductdetailsDTOs productDTO = new ProductdetailsDTOs();
          productDTO.setId(product.getId());
          productDTO.setProductid(product.getProductid());
          productDTO.setName(product.getName());
          productDTO.setDescription(product.getDescription());
          productDTO.setQty(product.getQty());
          productDTO.setSalesprice(product.getSalesprice());
          productDTO.setAmount(product.getAmount());
          productDTO.setSalestaxes_id(product.getSalestaxes_id());
          return productDTO;
      }).collect(Collectors.toList()));
      
      dto.setInvoicewithouttax(invoice.getInvoicewithouttax().stream().map(invoicewithouttax -> {
    	  InvoicewithouttaxDTOs invoicewithouttaxDTOs = new InvoicewithouttaxDTOs();
    	  invoicewithouttaxDTOs.setId(invoicewithouttax.getId());
    	  invoicewithouttaxDTOs.setDescriptionwot(invoicewithouttax.getDescriptionwot());
    	  invoicewithouttaxDTOs.setPricewot(invoicewithouttax.getPricewot());
          return invoicewithouttaxDTOs;
      }).collect(Collectors.toList()));

      return dto;
  }

  private EstimateDTOs convertToEstimateDTOs(Estimate estimate) {
      EstimateDTOs dto = new EstimateDTOs();
      dto.setId(estimate.getId());
      dto.setOrdertype(estimate.getOrdertype());
      dto.setCustomerdisplayname_id(estimate.getCustomerdisplayname_id());
      dto.setEmail(estimate.getEmail());
      dto.setCc(estimate.getCc());
      dto.setBcc(estimate.getBcc());
      dto.setBillto(estimate.getBillto());
      dto.setShipto(estimate.getShipto());
      dto.setAcceptedby(estimate.getAcceptedby());
      dto.setEstimatedate(estimate.getEstimatedate());
      dto.setStatus_id(estimate.getStatus_id());
      dto.setFranchiseowner_id(estimate.getFranchiseowner_id());
      
      dto.setCreateddate(estimate.getCreateddate());
      dto.setCity_id(estimate.getCity_id());
      dto.setState_id(estimate.getState_id());
      
      dto.setSubtotal(estimate.getSubtotal());
      dto.setDiscount(estimate.getDiscount());
      dto.setTaxablesubtotal(estimate.getTaxablesubtotal());
      dto.setTaxrates_id(estimate.getTaxrates_id());
      dto.setSalestax(estimate.getSalestax());
      dto.setTotal(estimate.getTotal());
      dto.setPaycheckto(estimate.getPaycheckto());
      dto.setNotetocustomer(estimate.getNotetocustomer());
      dto.setInternalcustomernotes(estimate.getInternalcustomernotes());
      dto.setMemoonstatement(estimate.getMemoonstatement());

      dto.setEstimateProductDetails(estimate.getEstimateProductDetails().stream().map(product -> {
          EstimateProductDetailsDTOs productDTO = new EstimateProductDetailsDTOs();
        productDTO.setId(product.getId());
        productDTO.setProductid(product.getProductid());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setQty(product.getQty());
        productDTO.setSalesprice(product.getSalesprice());
        productDTO.setAmount(product.getAmount());
        productDTO.setSalestaxes_id(product.getSalestaxes_id());
          
          return productDTO;
      }).collect(Collectors.toList()));
      
      dto.setEstimateWithoutTax(estimate.getEstimateWithoutTax().stream().map(estimateWithoutTax -> {
          EstimateWithoutTaxDTOs estimateWithoutTaxDTO = new EstimateWithoutTaxDTOs();
          estimateWithoutTaxDTO.setId(estimateWithoutTax.getId());
          estimateWithoutTaxDTO.setDescriptionwot(estimateWithoutTax.getDescriptionwot());
          estimateWithoutTaxDTO.setPricewot(estimateWithoutTax.getPricewot());
          return estimateWithoutTaxDTO;
      }).collect(Collectors.toList()));
      
      
      return dto;
  }


    private ReceiptPaymentDTO1 convertToReceiptPaymentDTO1(Receiptpayment receiptPayment) {
        ReceiptPaymentDTO1 dto = new ReceiptPaymentDTO1();
        dto.setId(receiptPayment.getId());
        dto.setInvoiceid(receiptPayment.getInvoiceid());
        dto.setOrdertype(receiptPayment.getOrdertype());
        dto.setCustomerdisplayname_id(receiptPayment.getCustomerdisplayname_id());
        dto.setDescription(receiptPayment.getDescription());
        dto.setCreateddate(receiptPayment.getCreateddate());
        dto.setCreatedby(receiptPayment.getCreatedby());
        dto.setPaymentmethod(receiptPayment.getPaymentmethod());
        dto.setDeposital(receiptPayment.getDeposital());
        dto.setAmount(receiptPayment.getAmount());
        return dto;
    }

    private ExpenseDTO convertToExpenseDTO(Expense expense) {
        ExpenseDTO dto = new ExpenseDTO();
        dto.setId(expense.getId());
        dto.setInvoiceid(expense.getInvoiceid());
        dto.setOrdertype(expense.getOrdertype());
        dto.setCustomerdisplayname_id(expense.getCustomerdisplayname_id());
        dto.setAmount(expense.getAmount());
        dto.setDescription(expense.getDescription());
        dto.setPaidfromaccount(expense.getPaidfromaccount());
        dto.setCreatedby(expense.getCreatedby());
        dto.setCreateddate(expense.getCreateddate());
        return dto;
    }

    
}
