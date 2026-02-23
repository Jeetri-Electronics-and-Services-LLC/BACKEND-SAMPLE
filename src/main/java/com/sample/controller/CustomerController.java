//package com.sample.controller;


//
//import com.sample.entity.Customer;
//
//import com.sample.entity.CustomerDetails;
//import com.sample.entity.CustomerDetailsDto;
//import com.sample.entity.CustomerDisplayNameDTO;
//import com.sample.entity.Customersummary;
//import com.sample.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/customers")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @GetMapping("/getallcustomer")
//    public List<Customer> getAllCustomers() {
//        return customerService.getAllCustomers();
//    }
//
////    @GetMapping("/getcustomer/{id}")
////    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
////        Optional<Customer> customer = customerService.getCustomerById(id);
////        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
////    }
//
//    @PostMapping("/addcustomer")
//    public Customer createCustomer(@RequestBody Customer customer) {
//        return customerService.saveCustomer(customer);
//    }
//
//    @PutMapping("/updatecustomer/{id}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
//        try {
//            Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
//            return ResponseEntity.ok(updatedCustomer);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/deletecustomer/{id}")
//    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
//        try {
//            customerService.deleteCustomer(id);
//            return ResponseEntity.noContent().build();
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    
// // Other methods...
////displaynames
//    @GetMapping("/displaynames")
//    public List<String> getAllCustomerDisplayNames() {
//        return customerService.getAllCustomerDisplayNames();
//    }
//    
////    @GetMapping("/displaynames")
////    public ResponseEntity<List<CustomerDisplayNameDTO>> getCustomerDisplayNames() {
////        List<CustomerDisplayNameDTO> customerDisplayNames = customerService.getAllCustomerDisplayNames();
////        return ResponseEntity.ok(customerDisplayNames);
////    }
////    
//    
//    @GetMapping("/customersummary")
//    public List<Customersummary> getCustomersummary() {
//        return customerService.getCustomersummaries();
//    }
//    
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @GetMapping("/customers/displayname/{customerdisplayname}")
//    public CustomerDetails getCustomerDetails(@PathVariable String customerdisplayname) {
//        return customerService.getCustomerDetailsByDisplayName(customerdisplayname);
//    }
//    
// 
//    @GetMapping("/customerdetailsbyoneid/{id}")
//    public ResponseEntity<CustomerDetailsDto> getCustomerDetailsById(@PathVariable Long id) {
//        Optional<CustomerDetailsDto> customerDetailsOptional = customerService.getCustomerDetailsById(id);
//        return customerDetailsOptional
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//    
//    
//    @PutMapping("/updateonlycustomerdetails/{id}")
//    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody CustomerDetailsDto customerDetailsDto) {
//        boolean isUpdated = customerService.updateCustomerDetails(id, customerDetailsDto);
//        if (isUpdated) {
//            return ResponseEntity.ok("Customer details updated successfully.");
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
// @GetMapping("/listofcustomers/{createdby}")
//    public List<CustomerDTO1> getListOfCustomers(@PathVariable String createdby) {
//        return customerService.getCustomerDetailsByCreatedBy(createdby);
//    }
//    
//}





//
package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Customer;
import com.sample.entity.CustomerDTO1;
import com.sample.entity.CustomerDTO2;
import com.sample.entity.CustomerDetails;
import com.sample.entity.CustomerDetailsDto;
import com.sample.entity.CustomerDisplayNameDTO;
import com.sample.entity.CustomerIdRequestDTO;
import com.sample.entity.CustomerNameResponseDTO;
import com.sample.entity.CustomerResponseDTO;
import com.sample.entity.Customersummary;
import com.sample.entity.ProductDetailsDTO;
import com.sample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/getallcustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/addcustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @PostMapping("/updatecustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        try {
            Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
            return ResponseEntity.ok(updatedCustomer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/deletecustomer")
    public ResponseEntity<Void> deleteCustomer(@RequestBody Map<String, Object> request) {
    	  Long id = Long.parseLong(request.get("id").toString());
          customerService.deleteCustomer(id);
          return ResponseEntity.noContent().build();
    }
    
    

    // Display names
    @PostMapping("/displaynames")
    public ResponseEntity<List<String>> getAllCustomerDisplayNames() {
        List<String> customerDisplayNames = customerService.getAllCustomerDisplayNames();
        return ResponseEntity.ok(customerDisplayNames);
    }

    @PostMapping("/customersummary")
    public ResponseEntity<List<Customersummary>> getCustomersummary() {
        List<Customersummary> summaries = customerService.getCustomersummaries();
        return ResponseEntity.ok(summaries);
    }

    @PostMapping("/customerdetailsbydisplayname")
    public ResponseEntity<CustomerDetails> getCustomerDetails(@RequestBody Map<String, String> requestBody) {
    	 String customerDisplayName = requestBody.get("customerDisplayName");
        CustomerDetails details = customerService.getCustomerDetailsByDisplayName(customerDisplayName);
        return ResponseEntity.ok(details);
    }
 
    

    @PostMapping("/customerdetailsbyoneid")
    public ResponseEntity<CustomerDetailsDto> getCustomerDetailsById(@RequestBody Map<String, Object> request) {
    	 Long id = Long.parseLong(request.get("id").toString());
    	 return customerService.getCustomerDetailsById(id)
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping("/updateonlycustomerdetails/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody CustomerDetailsDto customerDetailsDto) {
        boolean isUpdated = customerService.updateCustomerDetails(id, customerDetailsDto);
        if (isUpdated) {
            return ResponseEntity.ok("Customer details updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
   
    
    @PostMapping("/listofcustomers")
    public List<CustomerDTO1> getListOfCustomers(@RequestBody Map<String, String> requestBody) {
        String createdBy = requestBody.get("createdby");
        return customerService.getCustomerDetailsByCreatedBy(createdBy);
    }
    
//    @GetMapping("/particularcustomerdetails/{customerdisplayname}")
//    public CustomerResponseDTO getCustomerDetails(@PathVariable String customerdisplayname) {
//        return customerService.getCustomerDetails(customerdisplayname);
//    }

    @PostMapping("/particularcustomerdetails")
    public CustomerResponseDTO getCustomerDetails1(@RequestBody Map<String, String> request) {
        // Extract customerDisplayName from the request body
        String customerDisplayName = request.get("customerDisplayName");

        // Fetch customer details from the service layer
        return customerService.getCustomerDetails(customerDisplayName);
    }
    
 // Display all Customerlist but some fields -customerreports-customerlist
     @PostMapping("/displayallcustomerslistfewfields")
    public List<CustomerDTO2> getAllCustomers1() {
        return customerService.getAllCustomers1();
    }
     
     // display customerid & customername based on id
     @PostMapping("/getCustomerByIdname")
     public ResponseEntity<CustomerNameResponseDTO> getCustomerById(
             @RequestBody CustomerIdRequestDTO requestDTO) {

         CustomerNameResponseDTO response =
                 customerService.getCustomerNameByCustomerId(requestDTO.getCustomerId());

         return ResponseEntity.ok(response);
     }
}


