package com.sample.service;


import com.sample.entity.Customer;
import com.sample.entity.Invoice; // Import Invoice entity
import com.sample.entity.ReceiptPaymentDTO3;
import com.sample.entity.ReceiptPaymentDTO4;
import com.sample.entity.Receiptpayment;
import com.sample.entity.ReceiptpaymentDTO;
import com.sample.entity.ReceiptpaymentDTO2;
import com.sample.entity.ReceiptpaymentDTOs;
import com.sample.repository.CustomerRepository;
import com.sample.repository.InvoiceRepository; // Import Invoice repository
import com.sample.repository.ReceiptpaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceiptpaymentService {

    @Autowired
    private ReceiptpaymentRepository receiptpaymentRepository;

    @Autowired
    private InvoiceRepository invoiceRepository; // Inject Invoice repository
    
    @Autowired
    private CustomerRepository customerRepository;
    
    
    /**
     * Retrieves an Invoice by its ID.
     * @param invoiceId The ID of the invoice to retrieve.
     * @return An Optional containing the Invoice if found, or an empty Optional if not.
     */
    public Optional<Invoice> getInvoiceById(Long invoiceId) {
        return invoiceRepository.findById(invoiceId);
    }

    public List<ReceiptpaymentDTO> getAllReceiptpayments() {
        return receiptpaymentRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public Optional<ReceiptpaymentDTO> getReceiptpaymentById(Long id) {
        return receiptpaymentRepository.findById(id).map(this::convertToDTO);
    }

    public ReceiptpaymentDTO createReceiptpayment(ReceiptpaymentDTO receiptpaymentDTO) {
        Receiptpayment receiptpayment = new Receiptpayment();
        // Set properties from DTO
        receiptpayment.setInvoiceid(receiptpaymentDTO.getInvoiceid());
        receiptpayment.setOrdertype(receiptpaymentDTO.getOrdertype());
        receiptpayment.setCustomerdisplayname_id(receiptpaymentDTO.getCustomerdisplayname_id());
        receiptpayment.setDescription(receiptpaymentDTO.getDescription());
        receiptpayment.setCreateddate(receiptpaymentDTO.getCreateddate());
        receiptpayment.setCreatedby(receiptpaymentDTO.getCreatedby());
        receiptpayment.setPaymentmethod(receiptpaymentDTO.getPaymentmethod());
        receiptpayment.setDeposital(receiptpaymentDTO.getDeposital());
        receiptpayment.setAmount(receiptpaymentDTO.getAmount());
        
        // Set invoice using the invoice ID from the DTO
        if (receiptpaymentDTO.getInvoice_id() != null) {
            Invoice invoice = invoiceRepository.findById(receiptpaymentDTO.getInvoice_id()).orElse(null);
            receiptpayment.setInvoice(invoice);
        }

        // Save the new receipt payment
        
     // Set the customer based on the customerdisplayname_id
        String customerDisplayName = receiptpaymentDTO.getCustomerdisplayname_id();
        Customer customer = customerRepository.findBycustomerdisplayname(customerDisplayName);
        if (customer != null) {
        	receiptpayment.setCustomer(customer);  // Set the customer entity in the invoice
        } else {
            throw new IllegalArgumentException("Customer with display name " + customerDisplayName + " not found");
        }
        receiptpayment = receiptpaymentRepository.save(receiptpayment);
        return convertToDTO(receiptpayment);
    }
    
    

    public Optional<ReceiptpaymentDTO> updateReceiptpayment(Long id, ReceiptpaymentDTO receiptpaymentDTO) {
        return receiptpaymentRepository.findById(id).map(receiptpayment -> {
            // Update properties from DTO
        	receiptpayment.setInvoiceid(receiptpaymentDTO.getInvoiceid());
        	receiptpayment.setOrdertype(receiptpaymentDTO.getOrdertype());
        	receiptpayment.setCustomerdisplayname_id(receiptpaymentDTO.getCustomerdisplayname_id());
        	receiptpayment.setDescription(receiptpaymentDTO.getDescription());
        	receiptpayment.setCreateddate(receiptpaymentDTO.getCreateddate());
            receiptpayment.setCreatedby(receiptpaymentDTO.getCreatedby());
            receiptpayment.setPaymentmethod(receiptpaymentDTO.getPaymentmethod());
            receiptpayment.setDeposital(receiptpaymentDTO.getDeposital());
            receiptpayment.setAmount(receiptpaymentDTO.getAmount());
            
            // Set invoice using the invoice ID from the DTO
            if (receiptpaymentDTO.getInvoice_id() != null) {
                Invoice invoice = invoiceRepository.findById(receiptpaymentDTO.getInvoice_id()).orElse(null);
                receiptpayment.setInvoice(invoice);
            }

            // Save the updated receipt payment
            receiptpayment = receiptpaymentRepository.save(receiptpayment);
            return convertToDTO(receiptpayment);
        });
    }

    public boolean deleteReceiptpayment(Long id) {
        if (receiptpaymentRepository.existsById(id)) {
            receiptpaymentRepository.deleteById(id);
            return true; // Deletion successful
        }
        return false; // ID not found
    }

    private ReceiptpaymentDTO convertToDTO(Receiptpayment receiptpayment) {
        return new ReceiptpaymentDTO(
            receiptpayment.getId(),
            receiptpayment.getInvoiceid(),
            receiptpayment.getOrdertype(),
            receiptpayment.getCustomerdisplayname_id(),
            receiptpayment.getDescription(),
            receiptpayment.getCreateddate(),
            receiptpayment.getCreatedby(),
            receiptpayment.getPaymentmethod(),
            receiptpayment.getDeposital(),
            receiptpayment.getAmount(),
            receiptpayment.getInvoice() != null ? receiptpayment.getInvoice().getId() : null // Set invoice ID if available
        );
    }
    
// // Save Receiptpayment based on invoiceId
//    public Receiptpayment saveReceiptPayment(Long invoiceId, Receiptpayment receiptpayment) {
//        // Fetch Invoice using invoiceId
//        Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoiceId);
//        
//        if (optionalInvoice.isPresent()) {
//            // Set Invoice to Receiptpayment
//            receiptpayment.setInvoice(optionalInvoice.get());
//
//            // Save Receiptpayment to the database
//            return receiptpaymentRepository.save(receiptpayment);
//        } else {
//            throw new RuntimeException("Invoice not found with id: " + invoiceId);
//        }
//    }
//    
    
    
    // Save Receiptpayment based on invoiceId
    public Receiptpayment saveReceiptPayment(Long invoiceId, Receiptpayment receiptpayment) {
        // Fetch the Invoice using invoiceId
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoiceId);
        
        if (optionalInvoice.isPresent()) {
            Invoice invoice = optionalInvoice.get();

            // Set the invoice to Receiptpayment
            receiptpayment.setInvoice(invoice);

            // Automatically set invoicenumber as the invoiceId
            receiptpayment.setInvoiceid(String.valueOf(invoiceId));
            
            String customerDisplayName = receiptpayment.getCustomerdisplayname_id();
            Customer customer = customerRepository.findBycustomerdisplayname(customerDisplayName);
            if (customer != null) {
            	receiptpayment.setCustomer(customer);  // Set the customer entity in the invoice
            } else {
                throw new IllegalArgumentException("Customer with display name " + customerDisplayName + " not found");
            }

            // Save Receiptpayment to the database
            return receiptpaymentRepository.save(receiptpayment);
        } else {
            throw new RuntimeException("Invoice not found with id: " + invoiceId);
        }
    }
    
    public List<ReceiptpaymentDTOs> getReceiptpaymentsByInvoiceId(Long invoiceId) {
        return receiptpaymentRepository.findByInvoiceId(invoiceId).stream()
            .map(r -> new ReceiptpaymentDTOs(
                r.getId(),
                r.getInvoiceid(),
                r.getOrdertype(),
                r.getCustomerdisplayname_id(),
                r.getDescription(),
                r.getCreateddate(),
                r.getCreatedby(),
                r.getPaymentmethod(),
                r.getDeposital(),
                r.getAmount()
            ))
            .collect(Collectors.toList());
    }
    
    public List<ReceiptpaymentDTO2> getAllReceiptPayments() {
        List<Receiptpayment> receiptPayments = receiptpaymentRepository.findAll();
        return receiptPayments.stream().map(payment -> {
            ReceiptpaymentDTO2 dto = new ReceiptpaymentDTO2();
            dto.setId(payment.getId());
            dto.setInvoiceid(payment.getInvoiceid());
            dto.setOrdertype(payment.getOrdertype());
            dto.setCustomerdisplayname_id(payment.getCustomerdisplayname_id());
            dto.setDescription(payment.getDescription());
            dto.setCreateddate(payment.getCreateddate());
            dto.setCreatedby(payment.getCreatedby());
            dto.setPaymentmethod(payment.getPaymentmethod());
            dto.setDeposital(payment.getDeposital());
            dto.setAmount(payment.getAmount());
            return dto;
        }).collect(Collectors.toList());
    }
    
    public List<ReceiptPaymentDTO3> getAllReceiptPayments1() {
        List<Receiptpayment> receiptPayments = receiptpaymentRepository.findAll();
        
        return receiptPayments.stream().map(receipt -> new ReceiptPaymentDTO3(
                receipt.getId(),
                receipt.getInvoiceid(),
                receipt.getCustomerdisplayname_id(),
                receipt.getCreateddate(),
                receipt.getPaymentmethod(),
                receipt.getCreatedby(),
                receipt.getAmount()
        )).collect(Collectors.toList());
    }
    
    public BigDecimal getTotalAmountByInvoiceId(String invoiceid) {
        List<String> amounts = receiptpaymentRepository.findAmountsByInvoiceId(invoiceid);

        return amounts.stream()
                .filter(amount -> amount != null && !amount.isEmpty()) // Ignore null/empty values
                .map(amount -> new BigDecimal(amount.trim())) // Convert to BigDecimal
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Sum all amounts
    }
    
    public List<ReceiptPaymentDTO4> getReceiptPaymentsByInvoiceId(Long invoiceId) {
        List<Receiptpayment> receiptPayments = receiptpaymentRepository.findByInvoiceId(invoiceId);

        // Map Receiptpayment entities to ReceiptPaymentDTO
        return receiptPayments.stream().map(receiptPayment -> {
            ReceiptPaymentDTO4 dto = new ReceiptPaymentDTO4();
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
        }).collect(Collectors.toList());
    }
}
