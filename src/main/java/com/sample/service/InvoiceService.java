package com.sample.service;

import com.sample.entity.Customer;
import com.sample.entity.CustomerDTO;
import com.sample.entity.History;
import com.sample.entity.Invoice;
import com.sample.entity.InvoiceBalanceDTO;
import com.sample.entity.InvoiceDTO;
import com.sample.entity.InvoiceDTO1;
import com.sample.entity.InvoiceDTO2;
import com.sample.entity.InvoiceDTO3;
import com.sample.entity.InvoiceProductDTO;
import com.sample.entity.InvoiceRequest;
import com.sample.entity.InvoiceRequestDTO;
import com.sample.entity.InvoiceResponseDTO;
import com.sample.entity.InvoiceWithProductsDTO;
import com.sample.entity.Invoicewithouttax;
import com.sample.entity.InvoicewithouttaxDTO;
import com.sample.entity.InvoicewithouttaxDTO1;
import com.sample.entity.InvoicewithouttaxRequest;
import com.sample.entity.Product;
import com.sample.entity.ProductDetailDTO3;
import com.sample.entity.ProductRequest;
import com.sample.entity.ProductdetailDTO;
import com.sample.entity.Productdetails;
import com.sample.entity.ProductdetailsDTO1;
import com.sample.repository.CustomerRepository;
import com.sample.repository.InvoiceRepository;
import com.sample.repository.InvoicewithouttaxRepository;
import com.sample.repository.ProductdetailsRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductdetailsRepository productdetailsRepository;

    @Autowired
    private InvoicewithouttaxRepository repository;
    
    
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }
    
    
    
    public List<Invoice> getAllInvoicesWithProducts() {
        return invoiceRepository.findAllInvoicesWithProducts();
    }
    
    
    public void deleteInvoiceById(Long id) {
        if (invoiceRepository.existsById(id)) {
            invoiceRepository.deleteById(id);
        } else {
            throw new RuntimeException("Invoice not found with ID: " + id);
        }
    }
    

    
    
//    public Object[] getInvoiceDetailsById(Long invoiceId) {
//        return invoiceRepository.findInvoiceDetailsById(invoiceId);
//    }
//    
//    public List<Map<String, Object>> getInvoiceDetails() {
//        List<Object[]> results = invoiceRepository.findInvoiceDetails();
//        List<Map<String, Object>> formattedResults = new ArrayList<>();
//
//        for (Object[] row : results) {
//            Map<String, Object> rowData = new HashMap<>();
//            rowData.put("id", row[0]);
////            rowData.put("customer_id", row[1]);
//            rowData.put("email", row[2]);
//            rowData.put("subtotal", row[3]);
//            formattedResults.add(rowData);
//        }
//
//        return formattedResults;
//    }
 
    
    public Invoice getInvoiceByIdhistory(Long invoiceId) {
        return invoiceRepository.findInvoiceWithProducts(invoiceId);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAllInvoicesWithProducts();
    }
    
    // Add Invoice with List Of list of Products & Invoicewithouttax
    public Invoice createInvoiceWithProducts(InvoiceRequest invoiceRequest) {
        // Create a new Invoice entity
        Invoice invoice = new Invoice();
//        invoice.setId(invoiceRequest.getId()); // Optional: if you want to set the ID
        invoice.setCustomerdisplayname_id(invoiceRequest.getCustomerdisplayname_id());
        invoice.setOrdertype(invoiceRequest.getOrdertype());
        invoice.setEmail(invoiceRequest.getEmail());
        invoice.setCc(invoiceRequest.getCc());
        invoice.setBcc(invoiceRequest.getBcc());
        invoice.setBillto(invoiceRequest.getBillto());
        invoice.setShipto(invoiceRequest.getShipto());
        invoice.setShipvia(invoiceRequest.getShipvia());
        invoice.setShippingdate(invoiceRequest.getShippingdate());
        invoice.setTrackingno(invoiceRequest.getTrackingno());
        invoice.setTerms_id(invoiceRequest.getTerms_id());
        invoice.setInvoicedate(invoiceRequest.getInvoicedate());
        invoice.setDuedate(invoiceRequest.getDuedate());
        invoice.setStatus_id(invoiceRequest.getStatus_id());
        invoice.setFranchiseowner_id(invoiceRequest.getFranchiseowner_id());
        invoice.setProcessedon(invoiceRequest.getProcessedon());
        invoice.setCreateddate(invoiceRequest.getCreateddate());
        invoice.setCity_id(invoiceRequest.getCity_id());
        invoice.setState_id(invoiceRequest.getState_id());
        invoice.setTermsandconditions(invoiceRequest.getTermsandconditions());
        
        invoice.setSubtotal(invoiceRequest.getSubtotal());
        invoice.setDiscount(invoiceRequest.getDiscount());
        invoice.setTaxablesubtotal(invoiceRequest.getTaxablesubtotal());
        invoice.setTaxrates_id(invoiceRequest.getTaxrates_id());
        invoice.setSalestax(invoiceRequest.getSalestax());
        invoice.setTotal(invoiceRequest.getTotal());
        invoice.setDeposit(invoiceRequest.getDeposit());
        invoice.setPaycheckto(invoiceRequest.getPaycheckto());
        invoice.setBalanceamount(invoiceRequest.getBalanceamount());
        invoice.setNotetocustomer(invoiceRequest.getNotetocustomer());
        invoice.setInternalcustomernotes(invoiceRequest.getInternalcustomernotes());
        invoice.setMemoonstatement(invoiceRequest.getMemoonstatement());
        
     // Set the customer based on the customerdisplayname_id
        String customerDisplayName = invoiceRequest.getCustomerdisplayname_id();
        Customer customer = customerRepository.findBycustomerdisplayname(customerDisplayName);
        if (customer != null) {
            invoice.setCustomer(customer);  // Set the customer entity in the invoice
        } else {
            throw new IllegalArgumentException("Customer with display name " + customerDisplayName + " not found");
        }
        
        
        // Process the list of products
        List<ProductRequest> productRequests = invoiceRequest.getProducts();
        List<Productdetails> products = new ArrayList<>();

        for (ProductRequest productRequest : productRequests) {
            Productdetails product = new Productdetails();
//            product.setId(productRequest.getId()); // Optional: if you want to set the ID
            product.setProductid(productRequest.getProductid());
            product.setName(productRequest.getName());
            product.setDescription(productRequest.getDescription());
            product.setQty(productRequest.getQty());
            product.setSalesprice(productRequest.getSalesprice());
            product.setAmount(productRequest.getAmount());
            product.setSalestaxes_id(productRequest.getSalestaxes_id());
            System.out.println("Salestaxes ID for product: " + product.getSalestaxes_id());//tocheck
            System.out.println("Salestaxes ID: " + productRequest.getSalestaxes_id());  // Log salestaxes_id
            
            
            product.setInvoice(invoice); // Set the invoice for each product
            products.add(product);
        }

        // Set the products in the invoice
        invoice.setProducts(products);

     // Process the list of Invoicewithouttax
        List<InvoicewithouttaxRequest> invoicewithouttaxRequests = invoiceRequest.getInvoicewithouttax();
        List<Invoicewithouttax> invoicewithouttaxList = new ArrayList<>();
        for (InvoicewithouttaxRequest invoicewithouttaxRequest : invoicewithouttaxRequests) {
            Invoicewithouttax invoicewithouttax = new Invoicewithouttax();
            invoicewithouttax.setDescriptionwot(invoicewithouttaxRequest.getDescriptionwot());
            invoicewithouttax.setPricewot(invoicewithouttaxRequest.getPricewot());
            invoicewithouttax.setInvoice(invoice);
            invoicewithouttaxList.add(invoicewithouttax);
        }
        invoice.setInvoicewithouttax(invoicewithouttaxList);

        // Save the invoice along with its associated products and Invoicewithouttax
        return invoiceRepository.save(invoice);
    }
    
//    //based on customername fecth all invoice details
//    public List<InvoiceDTO> getInvoicesByCustomerDisplayName(String customerdisplayname_id) {
//        return invoiceRepository.findInvoicesByCustomerDisplayName(customerdisplayname_id);
//    }
    
    public List<InvoiceDTO> findInvoicesByCustomerDisplayName(String customerdisplayname) {
        return invoiceRepository.findInvoicesByCustomerDisplayName(customerdisplayname);
    }

    
    public InvoiceWithProductsDTO getInvoiceWithProducts(Long id) {
        Invoice invoice = invoiceRepository.findInvoiceByIdWithProducts(id);
        if (invoice == null) {
            return null; // Or throw an exception
        }

        List<ProductdetailDTO> productDetails = invoice.getProducts().stream()
                .map(product -> new ProductdetailDTO(
                        product.getId(),
                        product.getProductid(),
                        product.getName(),
                        product.getDescription(),
                        product.getQty(),
                        product.getSalesprice(),	
                        product.getAmount(),
                        product.getSalestaxes_id()
                ))
                .collect(Collectors.toList());
        
        // Retrieve and map Invoicewithouttax entities to InvoicewithouttaxDTO
        List<Invoicewithouttax> invoiceWithoutTaxList = repository.findByInvoiceId(invoice.getId());
        List<InvoicewithouttaxDTO> invoiceWithoutTaxDTOs = invoiceWithoutTaxList.stream()
                .map(invoiceWithoutTax -> new InvoicewithouttaxDTO(
                        invoiceWithoutTax.getId(),
                        invoiceWithoutTax.getDescriptionwot(),
                        invoiceWithoutTax.getPricewot()
                ))
                .collect(Collectors.toList());

        return new InvoiceWithProductsDTO(
                invoice.getId(),
                invoice.getOrdertype(),
                invoice.getCustomerdisplayname_id(),
                invoice.getEmail(),
                invoice.getCc(),
                invoice.getBcc(),
                invoice.getBillto(),
                invoice.getShipto(),
                invoice.getShipvia(),
                invoice.getShippingdate(),
                invoice.getTrackingno(),
                invoice.getTerms_id(),
                invoice.getInvoicedate(),
                invoice.getDuedate(),
                invoice.getStatus_id(),
                invoice.getFranchiseowner_id(),
                invoice.getProcessedon(),
                invoice.getCreateddate(),
                invoice.getCity_id(),
                invoice.getState_id(),
                invoice.getTermsandconditions(),
                
                invoice.getSubtotal(),
                invoice.getDiscount(),
                invoice.getTaxablesubtotal(),
                invoice.getTaxrates_id(),
                invoice.getSalestax(),
                invoice.getTotal(),
                invoice.getDeposit(),
                invoice.getPaycheckto(),
                invoice.getBalanceamount(),
                invoice.getNotetocustomer(),
                invoice.getInternalcustomernotes(),
                invoice.getMemoonstatement(),
                productDetails,
                invoiceWithoutTaxDTOs
        );
    }
    

    @Transactional
    public Invoice updateInvoice(InvoiceDTO2 invoiceDTO2) {
        Invoice invoice = invoiceRepository.findById(invoiceDTO2.getId())
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        // Update invoice fields
        invoice.setOrdertype(invoiceDTO2.getOrdertype());
        invoice.setCustomerdisplayname_id(invoiceDTO2.getCustomerdisplayname_id());
        invoice.setEmail(invoiceDTO2.getEmail());
        invoice.setCc(invoiceDTO2.getCc());
        invoice.setBcc(invoiceDTO2.getBcc());
        invoice.setBillto(invoiceDTO2.getBillto());
        invoice.setShipto(invoiceDTO2.getShipto());
        invoice.setShipvia(invoiceDTO2.getShipvia());
        invoice.setShippingdate(invoiceDTO2.getShippingdate());
        invoice.setTrackingno(invoiceDTO2.getTrackingno());
        invoice.setTerms_id(invoiceDTO2.getTerms_id());
        invoice.setInvoicedate(invoiceDTO2.getInvoicedate());
        invoice.setDuedate(invoiceDTO2.getDuedate());
        invoice.setStatus_id(invoiceDTO2.getStatus_id());
        invoice.setFranchiseowner_id(invoiceDTO2.getFranchiseowner_id());
        invoice.setProcessedon(invoiceDTO2.getProcessedon());
        invoice.setCreateddate(invoiceDTO2.getCreateddate());
        invoice.setCity_id(invoiceDTO2.getCity_id());
        invoice.setState_id(invoiceDTO2.getState_id());
        invoice.setTermsandconditions(invoiceDTO2.getTermsandconditions());
        
        invoice.setSubtotal(invoiceDTO2.getSubtotal());
        invoice.setDiscount(invoiceDTO2.getDiscount());
        invoice.setTaxablesubtotal(invoiceDTO2.getTaxablesubtotal());
        invoice.setTaxrates_id(invoiceDTO2.getTaxrates_id());
        invoice.setSalestax(invoiceDTO2.getSalestax());
        invoice.setTotal(invoiceDTO2.getTotal());
        invoice.setDeposit(invoiceDTO2.getDeposit());
        invoice.setPaycheckto(invoiceDTO2.getPaycheckto());
        invoice.setBalanceamount(invoiceDTO2.getBalanceamount());
        invoice.setNotetocustomer(invoiceDTO2.getNotetocustomer());
        invoice.setInternalcustomernotes(invoiceDTO2.getInternalcustomernotes());
        invoice.setMemoonstatement(invoiceDTO2.getMemoonstatement());

        // Update products
        List<Productdetails> products = invoiceDTO2.getProducts().stream().map(dto -> {
            Productdetails product = new Productdetails();
            product.setId(dto.getId()); // Ensure existing products are matched
            product.setProductid(dto.getProductid());
            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setQty(dto.getQty());
            product.setSalesprice(dto.getSalesprice());
            product.setAmount(dto.getAmount());
            product.setSalestaxes_id(dto.getSalestaxes_id());
            product.setInvoice(invoice); // Associate with the invoice
            return product;
        }).collect(Collectors.toList());

        invoice.getProducts().clear();
        invoice.getProducts().addAll(products);
        
     // Update Invoicewithouttax
        List<Invoicewithouttax> invoicewithouttaxList = invoiceDTO2.getInvoicewithouttax().stream().map(dto -> {
            Invoicewithouttax invoicewithouttax = new Invoicewithouttax();
            invoicewithouttax.setId(dto.getId());
            invoicewithouttax.setDescriptionwot(dto.getDescriptionwot());
            invoicewithouttax.setPricewot(dto.getPricewot());
            invoicewithouttax.setInvoice(invoice); // Associate with the invoice
            return invoicewithouttax;
        }).collect(Collectors.toList());

        invoice.getInvoicewithouttax().clear();
        invoice.getInvoicewithouttax().addAll(invoicewithouttaxList);


        return invoiceRepository.save(invoice);
    }
    
    public InvoiceDTO1 getInvoiceWithProducts1(Long invoiceId) {
        Invoice invoice = invoiceRepository.findByIdWithProducts(invoiceId);
        return mapToInvoiceDTO1(invoice);
    }

    private InvoiceDTO1 mapToInvoiceDTO1(Invoice invoice) {
        InvoiceDTO1 invoiceDTO = new InvoiceDTO1();
        invoiceDTO.setId(invoice.getId());
        invoiceDTO.setOrdertype(invoice.getOrdertype());
        invoiceDTO.setCustomerdisplayname_id(invoice.getCustomerdisplayname_id());
        invoiceDTO.setCreateddate(invoice.getCreateddate());
        invoiceDTO.setBillto(invoice.getBillto());
        invoiceDTO.setSubtotal(invoice.getSubtotal());
        invoiceDTO.setSalestax(invoice.getSalestax());
        invoiceDTO.setTotal(invoice.getTotal());
        invoiceDTO.setBalanceamount(invoice.getBalanceamount());
        invoiceDTO.setNotetocustomer(invoice.getNotetocustomer());

        invoiceDTO.setProducts(invoice.getProducts().stream().map(this::mapToProductdetailsDTO1).collect(Collectors.toList()));
        invoiceDTO.setInvoicewithouttax(invoice.getInvoicewithouttax().stream().map(this::mapToInvoicewithouttaxDTO1).collect(Collectors.toList()));
        return invoiceDTO;
    }

    private ProductdetailsDTO1 mapToProductdetailsDTO1(Productdetails product) {
        ProductdetailsDTO1 productDTO = new ProductdetailsDTO1();
        productDTO.setId(product.getId());
//        productDTO.setProductid(product.getProductid());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setQty(product.getQty());
        productDTO.setSalesprice(product.getSalesprice());
        productDTO.setAmount(product.getAmount());
        return productDTO;
    }
    private InvoicewithouttaxDTO1 mapToInvoicewithouttaxDTO1(Invoicewithouttax invoicewithouttaxDTO1) {
    	InvoicewithouttaxDTO1 invoicewithouttaxDTO = new InvoicewithouttaxDTO1();
    	invoicewithouttaxDTO.setId(invoicewithouttaxDTO1.getId());
    	invoicewithouttaxDTO.setDescriptionwot(invoicewithouttaxDTO1.getDescriptionwot());
    	invoicewithouttaxDTO.setPricewot(invoicewithouttaxDTO1.getPricewot());
        return invoicewithouttaxDTO;
    }
    
    //  Display Invoice details with productdetails(Shipment Tracking)
    public List<InvoiceResponseDTO> getAllInvoices1() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return invoices.stream().map(invoice -> {
            InvoiceResponseDTO dto = new InvoiceResponseDTO();
            dto.setInvoiceid(invoice.getId());
            dto.setCustomerdisplayname_id(invoice.getCustomerdisplayname_id());
            dto.setInvoicedate(invoice.getInvoicedate());
            dto.setStatus_id(invoice.getStatus_id());
            dto.setTotal(invoice.getTotal());

            List<ProductDetailDTO3> productDetails = invoice.getProducts().stream().map(product -> {
                ProductDetailDTO3 productDto = new ProductDetailDTO3();
                productDto.setName(product.getName());
                productDto.setQty(product.getQty());
                return productDto;
            }).collect(Collectors.toList());

            dto.setProductDetails(productDetails);
            return dto;
        }).collect(Collectors.toList());
    }
    
    public List<InvoiceProductDTO> getInvoiceProducts(Long invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).orElse(null);
        
        if (invoice == null) {
            return List.of(); // Return empty list if invoice not found
        }

        return invoice.getProducts().stream()
                .map(product -> new InvoiceProductDTO(product.getProductid(), product.getName() ,product.getQty()))
                .collect(Collectors.toList());
    }
    
    // Display List Of Invoices Particular Fields -invoice report
    public List<InvoiceDTO3> getAllInvoices2() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return invoices.stream().map(invoice -> new InvoiceDTO3(
                invoice.getId(),
                invoice.getOrdertype(),
                invoice.getCustomerdisplayname_id(),
                invoice.getStatus_id(),
                invoice.getCreateddate(),
                invoice.getFranchiseowner_id(),
                invoice.getBalanceamount()
                
        )).collect(Collectors.toList());
    }
    
 // Display invoice some details based on invoiceid - PaymentBalance
    public InvoiceBalanceDTO getInvoiceBalanceById(Long invoiceId) {
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceId);
        
        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();
            return new InvoiceBalanceDTO(invoice.getId(), invoice.getCustomerdisplayname_id(), invoice.getBalanceamount());
        }
        return null;
    }
    
}
