package com.sample.service;

import com.sample.entity.Customer;
import com.sample.entity.CustomerDTO1;
import com.sample.entity.CustomerDTO2;
import com.sample.entity.CustomerDetails;
import com.sample.entity.CustomerDetailsDto;
import com.sample.entity.CustomerDisplayNameDTO;
import com.sample.entity.CustomerNameResponseDTO;
import com.sample.entity.CustomerResponseDTO;
import com.sample.entity.Customersummary;
import com.sample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

//    public Optional<Customer> getCustomerById(Long id) {
//        return customerRepository.findById(id);
//    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setTitle(customerDetails.getTitle());
            customer.setFirstname(customerDetails.getFirstname());
            customer.setMiddlename(customerDetails.getMiddlename());
            customer.setLastname(customerDetails.getLastname());
            customer.setSuffix(customerDetails.getSuffix());
            customer.setCompanyname(customerDetails.getCompanyname());
            customer.setCustomerdisplayname(customerDetails.getCustomerdisplayname());
            customer.setEmailid(customerDetails.getEmailid());
            customer.setPhonenumber(customerDetails.getPhonenumber());
            customer.setMobilenumber(customerDetails.getMobilenumber());
            customer.setFax(customerDetails.getFax());
            customer.setOther(customerDetails.getOther());
            customer.setWebsite(customerDetails.getWebsite());
            customer.setNametoprintonchecks(customerDetails.getNametoprintonchecks());
            customer.setBillingstreetaddress(customerDetails.getBillingstreetaddress());
            customer.setBillingplatnumber(customerDetails.getBillingplatnumber());
            customer.setBillingcity_id(customerDetails.getBillingcity_id());
            customer.setBillingstate_id(customerDetails.getBillingstate_id());
            customer.setBillingcountry_id(customerDetails.getBillingcountry_id());
            customer.setBillingzipcode(customerDetails.getBillingzipcode());
            customer.setShipingstreetaddress(customerDetails.getShipingstreetaddress());
            customer.setShipingplatnumber(customerDetails.getShipingplatnumber());
            customer.setShipingcity_id(customerDetails.getShipingcity_id());
            customer.setShipingstate_id(customerDetails.getShipingstate_id());
            customer.setShipingcountry_id(customerDetails.getShipingcountry_id());
            customer.setShipingzipcode(customerDetails.getShipingzipcode());
            customer.setNote(customerDetails.getNote());
            customer.setPrimarypaymentmethod_id(customerDetails.getPrimarypaymentmethod_id());
            customer.setTerms_id(customerDetails.getTerms_id());
            customer.setSalesfromdeliveryoptions_id(customerDetails.getSalesfromdeliveryoptions_id());
            customer.setLanguages_id(customerDetails.getLanguages_id());
            customer.setCustomertype_id(customerDetails.getCustomertype_id());
            
            customer.setStatus_id(customerDetails.getStatus_id());
            customer.setFranchiseowner_id(customerDetails.getFranchiseowner_id());
            
            
            customer.setCreateddate(customerDetails.getCreateddate());
            customer.setCreatedby(customerDetails.getCreatedby());
            customer.setFollowedby(customerDetails.getFollowedby());
           
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with id " + id);
        }
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    
    //displaynames
    public List<String> getAllCustomerDisplayNames() {
        return customerRepository.findAllCustomerDisplayNames();
    }
    
//    public List<CustomerDisplayNameDTO> getAllCustomerDisplayNames() {
//        return customerRepository.findAllCustomerDisplayNames();
//    }
    
    public List<Customersummary> getCustomersummaries() {
        return customerRepository.findCustomersummaries();
    }
    
    
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDetails getCustomerDetailsByDisplayName(String customerdisplayname) {
        return customerRepository.findCustomerDetailsByDisplayName(customerdisplayname);
    }
    
    public Optional<CustomerDetailsDto> getCustomerDetailsById(Long id) {
        return customerRepository.findCustomerDetailsById(id);
    }
    
    

    public boolean updateCustomerDetails(Long id, CustomerDetailsDto customerDetailsDto) {
        int updatedRows = customerRepository.updateCustomerDetails(
                id,
                customerDetailsDto.getTitle(),
                customerDetailsDto.getFirstname(),
                customerDetailsDto.getMiddlename(),
                customerDetailsDto.getLastname(),
                customerDetailsDto.getSuffix(),
                customerDetailsDto.getCompanyname(),
                customerDetailsDto.getCustomerdisplayname(),
                customerDetailsDto.getEmailid(),
                customerDetailsDto.getPhonenumber(),
                customerDetailsDto.getMobilenumber(),
                customerDetailsDto.getFax(),
                customerDetailsDto.getOther(),
                customerDetailsDto.getWebsite(),
                customerDetailsDto.getNametoprintonchecks(),
                customerDetailsDto.getBillingstreetaddress(),
                customerDetailsDto.getBillingplatnumber(),
                customerDetailsDto.getBillingcity_id(),
                customerDetailsDto.getBillingstate_id(),
                customerDetailsDto.getBillingcountry_id(),
                customerDetailsDto.getBillingzipcode(),
                customerDetailsDto.getShipingstreetaddress(),
                customerDetailsDto.getShipingplatnumber(),
                customerDetailsDto.getShipingcity_id(),
                customerDetailsDto.getShipingstate_id(),
                customerDetailsDto.getShipingcountry_id(),
                customerDetailsDto.getShipingzipcode(),
                customerDetailsDto.getNote(),
                customerDetailsDto.getPrimarypaymentmethod_id(),
                customerDetailsDto.getTerms_id(),
                customerDetailsDto.getSalesfromdeliveryoptions_id(),
                customerDetailsDto.getLanguages_id(),
                customerDetailsDto.getCustomertype_id(),
               
                customerDetailsDto.getStatus_id(),
                customerDetailsDto.getFranchiseowner_id()              
        );
        return updatedRows > 0; // returns true if any rows were updated
    }
    
    public List<CustomerDTO1> getCustomerDetailsByCreatedBy(String createdBy) {
        return customerRepository.findCustomerDetailsByCreatedBy(createdBy);
    }
    
    public CustomerResponseDTO getCustomerDetails(String customerdisplayname) {
        // Fetch customer entity from the database
        Customer customer = customerRepository.findBycustomerdisplayname(customerdisplayname);
        if (customer != null) {
            return mapToCustomerResponseDTO(customer);
        } else {
            throw new RuntimeException("Customer with display name " + customerdisplayname + " not found");
        }
    }

    private CustomerResponseDTO mapToCustomerResponseDTO(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setCustomerdisplayname(customer.getCustomerdisplayname());
        dto.setEmailid(customer.getEmailid());

        // Format billing details
        String billto = String.join(", ",
                customer.getBillingstreetaddress(),
                customer.getBillingcity_id(),
                customer.getBillingstate_id(),
                customer.getBillingcountry_id(),
                customer.getBillingzipcode());
        dto.setBillto(billto);

        // Format shipping details
        String shipto = String.join(", ",
                customer.getShipingstreetaddress(),
                customer.getShipingcity_id(),
                customer.getShipingstate_id(),
                customer.getShipingcountry_id(),
                customer.getShipingzipcode());
        dto.setShipto(shipto);

        return dto;
    }
    
 // Display all Customerlist but some fields -customerreports-customerlist
    public List<CustomerDTO2> getAllCustomers1() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> new CustomerDTO2(
                        customer.getId(),
                        customer.getCustomerdisplayname(),
                        customer.getMobilenumber(),
                        customer.getStatus_id(),
                        customer.getCreateddate(),
                        customer.getCreatedby()))
                .collect(Collectors.toList());
    }
    
   
    
    public CustomerNameResponseDTO getCustomerNameByCustomerId(Long customerId) {

        Optional<Customer> customerOpt = customerRepository.findById(customerId);

        if (customerOpt.isEmpty()) {
            throw new RuntimeException("Customer not found with id: " + customerId);
        }

        Customer customer = customerOpt.get();

        String customerName = String.join(" ",
                customer.getFirstname() != null ? customer.getFirstname() : "",
                customer.getMiddlename() != null ? customer.getMiddlename() : "",
                customer.getLastname() != null ? customer.getLastname() : ""
        ).trim();

        return new CustomerNameResponseDTO(customer.getId(), customerName);
    }
    
}