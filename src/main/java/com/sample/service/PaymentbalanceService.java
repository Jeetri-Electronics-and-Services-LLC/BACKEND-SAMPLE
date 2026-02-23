package com.sample.service;

import com.sample.entity.Customer;
import com.sample.entity.Invoice;
import com.sample.entity.PaymentBalanceDTO;
import com.sample.entity.Paymentbalance;

import com.sample.entity.Receiptpayment;
import com.sample.entity.ReceiptpaymentDTO;
import com.sample.repository.CustomerRepository;
import com.sample.repository.InvoiceRepository;
import com.sample.repository.PaymentbalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentbalanceService {

    @Autowired
    private PaymentbalanceRepository paymentbalanceRepository;
    
    @Autowired
    private InvoiceRepository invoiceRepository; // Inject Invoice repository
    
    @Autowired
    private CustomerRepository customerRepository;

    public Paymentbalance savePaymentbalance(Long invoiceId, Paymentbalance paymentbalance) {
        // Fetch the Invoice using invoiceId
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoiceId);
        
        if (optionalInvoice.isPresent()) {
            Invoice invoice = optionalInvoice.get();

            // Set the invoice to Receiptpayment
            paymentbalance.setInvoice(invoice);

            // Automatically set invoicenumber as the invoiceId
            paymentbalance.setInvoiceid(Long.valueOf(invoiceId));
            
            String customerDisplayName = paymentbalance.getCustomerdisplayname_id();
            Customer customer = customerRepository.findBycustomerdisplayname(customerDisplayName);
            if (customer != null) {
            	paymentbalance.setCustomer(customer);  // Set the customer entity in the invoice
            } else {
                throw new IllegalArgumentException("Customer with display name " + customerDisplayName + " not found");
            }

            // Save Receiptpayment to the database
            return paymentbalanceRepository.save(paymentbalance);
        } else {
            throw new RuntimeException("Invoice not found with id: " + invoiceId);
        }
    }
    
    public List<PaymentBalanceDTO> getAllPaymentBalances() {
        List<Paymentbalance> paymentBalances = paymentbalanceRepository.findAll();
        return paymentBalances.stream().map(pb -> new PaymentBalanceDTO(
                
                pb.getInvoiceid(),
                pb.getCustomerdisplayname_id(),
                pb.getCreateddate(),
                pb.getCreatedby(),
                pb.getBalanceamount(),
                pb.getReceiptpaymentamount(),
                pb.getTotalbalanceamount()
        )).collect(Collectors.toList());
    }
    
    
}
