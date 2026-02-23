package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Customer;
import com.sample.entity.InvoiceCustomerSummaryDTO;
import com.sample.entity.Tenanteinvoice;
import com.sample.entity.TenanteinvoiceDTO;
import com.sample.repository.CustomerRepository;
import com.sample.repository.TenanteinvoiceRepository;

@Service
public class TenanteinvoiceService {

	 @Autowired
	    private TenanteinvoiceRepository tenanteinvoiceRepository;

	    @Autowired
	    private CustomerRepository customerRepository;

	    public Tenanteinvoice addInvoice(TenanteinvoiceDTO dto) {

	        Customer customer = customerRepository.findById(dto.getCustomerId())
	                .orElseThrow(() -> new RuntimeException("Customer not found"));

	        Tenanteinvoice invoice = new Tenanteinvoice();
	        invoice.setPluming(dto.getPluming());
	        invoice.setFraming(dto.getFraming());
	        invoice.setHvac(dto.getHvac());
	        invoice.setElectrical(dto.getElectrical());
	        invoice.setDropdownceiling(dto.getDropdownceiling());
	        invoice.setSheetrockceiling(dto.getSheetrockceiling());
	        invoice.setFlooring(dto.getFlooring());
	        invoice.setItemdescription(dto.getItemdescription());
	        invoice.setSalestax(dto.getSalestax());
            invoice.setCustom(dto.getCustom());
            invoice.setGrandtotal(dto.getGrandtotal());
	        invoice.setPrice(dto.getPrice());
	        invoice.setCustomer(customer);

	        return tenanteinvoiceRepository.save(invoice);
	    }

	    public InvoiceCustomerSummaryDTO getInvoiceCustomerSummary(Long invoiceId) {

	        Tenanteinvoice invoice = tenanteinvoiceRepository.findById(invoiceId)
	                .orElseThrow(() -> new RuntimeException("Tenanteinvoice not found with id: " + invoiceId));

	        Customer customer = invoice.getCustomer();

	        return new InvoiceCustomerSummaryDTO(
	                customer.getId(),
	                customer.getCustomerdisplayname(),
	                invoice.getId(),
	                invoice.getGrandtotal()
	        );
	    }
    
}
