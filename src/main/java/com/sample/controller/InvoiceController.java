


//correct code




//package com.sample.controller;
//
//import com.sample.entity.Invoice;
//import com.sample.entity.InvoiceDTO;
//import com.sample.entity.InvoiceRequest;
//import com.sample.entity.InvoiceRequestDTO;
//import com.sample.entity.InvoiceWithProductsDTO;
//import com.sample.entity.Productdetails;
//import com.sample.service.InvoiceService;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/invoices")
//public class InvoiceController {
//
//    @Autowired
//    private InvoiceService invoiceService;
//
//    /**
//     * Create a new invoice with products.
//     *
//     * @param invoiceRequest the invoice request payload
//     * @return the created Invoice entity
//     */
//    @PostMapping("/create")
//    public ResponseEntity<Invoice> createInvoiceWithProducts(@RequestBody InvoiceRequest invoiceRequest) {
//        try {
//            Invoice createdInvoice = invoiceService.createInvoiceWithProducts(invoiceRequest);
//            return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//   
//    @GetMapping("/getinvoice/{id}")
//    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
//        Invoice invoice = invoiceService.getInvoiceById(id);
//        if (invoice != null) {
//            return new ResponseEntity<>(invoice, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//     
//    @GetMapping("/allinvicewithproductsall")
//    public ResponseEntity<List<Invoice>> getAllInvoicesWithProducts() {
//        List<Invoice> invoices = invoiceService.getAllInvoicesWithProducts();
//        return new ResponseEntity<>(invoices, HttpStatus.OK);
//    }
//      
//    @DeleteMapping("/deleteinvoice/{id}")
//    public ResponseEntity<String> deleteInvoiceById1(@PathVariable Long id) {
//        try {
//            invoiceService.deleteInvoiceById(id);
//            return new ResponseEntity<>("Invoice deleted successfully", HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
//    
//    //based on customername fecth all invoice details
//    
////    @GetMapping("/customer/{customerdisplayname_id}")
////    public List<InvoiceDTO> getInvoicesByCustomerDisplayName(@PathVariable String customerdisplayname_id) {
////        return invoiceService.getInvoicesByCustomerDisplayName(customerdisplayname_id);
////    }
////    
//    
//    
// // API to get invoices by customer display name 
//    @GetMapping("/customer/{customerdisplayname}")
//    public ResponseEntity<List<InvoiceDTO>> getInvoicesByCustomerDisplayName(@PathVariable("customerdisplayname") String customerdisplayname) {
//        List<InvoiceDTO> invoices = invoiceService.findInvoicesByCustomerDisplayName(customerdisplayname);
//        return new ResponseEntity<>(invoices, HttpStatus.OK);
//    }
//
//    
//    @GetMapping("/fetchonlyinvoicewithproducts/{id}")
//    public ResponseEntity<InvoiceWithProductsDTO> getInvoiceWithProducts(@PathVariable Long id) {
//        InvoiceWithProductsDTO invoiceDTO = invoiceService.getInvoiceWithProducts(id);
//        if (invoiceDTO == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(invoiceDTO);
//    }
//    
//
//    @PutMapping("/updateinvoice/{id}")
//    public ResponseEntity<String> updateInvoiceWithProducts(@PathVariable("id") Long invoiceId, 
//                                                            @RequestBody InvoiceWithProductsDTO invoiceDTO) {
//        String result = invoiceService.updateInvoiceWithProducts(invoiceId, invoiceDTO);
//        if (result.contains("not found")) {
//            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        }
//    }
//    
//}
//    
//
////    
////    @GetMapping("/details/{invoiceId}")
////    public Object[] getInvoiceDetailsById(@PathVariable Long invoiceId) {
////        return invoiceService.getInvoiceDetailsById(invoiceId);
////    }
////    
////    @GetMapping("/details")
////    public List<Map<String, Object>> getInvoiceDetails() {
////        return invoiceService.getInvoiceDetails();
////    }
//    
//    
//    
// // Endpoint to create a new invoice
////    @PostMapping("/create")
////    public ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceDTO invoiceDTO) {
////        Invoice savedInvoice = invoiceService.createInvoice(invoiceDTO);
////        return ResponseEntity.status(HttpStatus.CREATED).body(savedInvoice);
////    }
////    }
//    
// // Get a single invoice by ID with products and history
////    @GetMapping("/one/{invoiceId}")
////    public ResponseEntity<Invoice> getInvoiceByIdhistory(@PathVariable Long invoiceId) {
////        Invoice invoice = invoiceService.getInvoiceById(invoiceId);
////        if (invoice != null) {
////            return ResponseEntity.ok(invoice);
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
////
////    // Get all invoices with products and history
////    @GetMapping
////    public ResponseEntity<List<Invoice>> getAllInvoices() {
////        List<Invoice> invoices = invoiceService.getAllInvoices();
////        if (!invoices.isEmpty()) {
////            return ResponseEntity.ok(invoices);
////        } else {
////            return ResponseEntity.noContent().build();
////        }
////    }
//update invoice with list of products based on id 
//@PutMapping("updateinvoicewithpro/{id}")
//    public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody InvoiceDTO2 invoiceDTO2) {
//        invoiceDTO2.setId(id);
//        Invoice updatedInvoice = invoiceService.updateInvoice(invoiceDTO2);
//        return ResponseEntity.ok(updatedInvoice);
//    }
//    
////    @PostMapping("/createinvoicewithproducthistory")
////    public ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceRequestDTO invoiceRequest) {
////        Invoice createdInvoice = invoiceService.createInvoice(invoiceRequest);
////        return ResponseEntity.ok(createdInvoice);
////    }

//@GetMapping("/getinvoiceparticularpr/{invoiceId}")
//    public InvoiceDTO1 getInvoiceWithProducts(@PathVariable Long invoiceId) {
//        return invoiceService.getInvoiceWithProducts1(invoiceId);
//    }
////    
//





















//
package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Invoice;
import com.sample.entity.InvoiceBalanceDTO;
import com.sample.entity.InvoiceDTO;
import com.sample.entity.InvoiceDTO1;
import com.sample.entity.InvoiceDTO2;
import com.sample.entity.InvoiceDTO3;
import com.sample.entity.InvoiceProductDTO;
import com.sample.entity.InvoiceRequest;
import com.sample.entity.InvoiceResponseDTO;
import com.sample.entity.InvoiceWithProductsDTO;
//import com.sample.entity.Invoicerequestdto;
import com.sample.service.InvoiceService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    /**
     * Create a new invoice with products.
     *
     * @param invoiceRequest the invoice request payload
     * @return the created Invoice entity
     */
    @PostMapping("/create")
  public ResponseEntity<Invoice> createInvoiceWithProducts(@RequestBody InvoiceRequest invoiceRequest) {
    	
      try {
          Invoice createdInvoice = invoiceService.createInvoiceWithProducts(invoiceRequest);
          return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
      } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
    

    /**
     * Fetch invoice by ID using POST method.
     *
     * @param payload a map containing the invoice ID
     * @return the invoice entity if found
     */
    @PostMapping("/getinvoice")
    public ResponseEntity<Invoice> getInvoiceById(@RequestBody Map<String, Long> payload) {
        Long id = payload.get("id");
        Invoice invoice = invoiceService.getInvoiceById(id);
        if (invoice != null) {
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Fetch all invoices with products using POST method.
     *
     * @param requestPayload an empty request payload
     * @return the list of all invoices
     */
    @PostMapping("/allinvicewithproductsall")
    public ResponseEntity<List<Invoice>> getAllInvoicesWithProducts(@RequestBody(required = false) Map<String, Object> request) {
        List<Invoice> invoices = invoiceService.getAllInvoicesWithProducts();
        return ResponseEntity.ok(invoices);
    }
    
    /**
     * Delete invoice by ID using POST method.
     *
     * @param payload a map containing the invoice ID
     * @return a response indicating the deletion status
     */
    @PostMapping("/deleteinvoice")
    public ResponseEntity<String> deleteInvoiceById(@RequestBody Map<String, Long> payload) {
        Long id = payload.get("id");
        try {
            invoiceService.deleteInvoiceById(id);
            return new ResponseEntity<>("Invoice deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Fetch invoices by customer display name using POST method.
     *
     * @param payload a map containing the customer display name
     * @return the list of invoices matching the customer display name
     */
    @PostMapping("/customer")
    public ResponseEntity<List<InvoiceDTO>> getInvoicesByCustomerDisplayName(@RequestBody Map<String, String> payload) {
        String customerdisplayname = payload.get("customerdisplayname");
        List<InvoiceDTO> invoices = invoiceService.findInvoicesByCustomerDisplayName(customerdisplayname);
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    /**
     * Fetch invoice with products by ID using POST method.
     *
     * @param payload a map containing the invoice ID
     * @return the invoice with products
     */
    @PostMapping("/fetchonlyinvoicewithproducts")
    public ResponseEntity<InvoiceWithProductsDTO> getInvoiceWithProducts(@RequestBody Map<String, Long> payload) {
        Long id = payload.get("id");
        InvoiceWithProductsDTO invoiceDTO = invoiceService.getInvoiceWithProducts(id);
        if (invoiceDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(invoiceDTO);
    }

    /**
     * Update an invoice by ID using POST method.
     *
     * @param payload a map containing the invoice ID and invoice DTO
     * @return the update status
     */
    @PostMapping("/updateinvoicewithpro/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody InvoiceDTO2 invoiceDTO2) {
        invoiceDTO2.setId(id); // Set the ID from the path variable
        Invoice updatedInvoice = invoiceService.updateInvoice(invoiceDTO2);
        return ResponseEntity.ok(updatedInvoice);
    }
    
    @PostMapping("/getinvoiceparticularpr")
    public ResponseEntity<InvoiceDTO1> getInvoiceWithProducts1(@RequestBody Map<String, Object> request) {
        Long invoiceId = Long.parseLong(request.get("invoiceId").toString());  // Extract invoiceId from the request
        InvoiceDTO1 invoiceDTO = invoiceService.getInvoiceWithProducts1(invoiceId);

        if (invoiceDTO != null) {
            return ResponseEntity.ok(invoiceDTO);
        } else {
            return ResponseEntity.notFound().build(); // If the invoice is not found
        }
    }
    
//  Display Invoice details with productdetails(Shipment Tracking)
    @PostMapping("/getsomeinvoicedetailswithlistofproducts")
    public ResponseEntity<List<InvoiceResponseDTO>> getAllInvoices1() {
        List<InvoiceResponseDTO> invoices = invoiceService.getAllInvoices1();
        return ResponseEntity.ok(invoices);
    }
    
    @PostMapping("/basedoninvoiceiddisplayinvoicewithlistproducts")
    public ResponseEntity<List<InvoiceProductDTO>> getInvoiceProducts(@RequestBody Map<String, Long> requestBody) {
        Long invoiceId = requestBody.get("invoiceId");
        if (invoiceId == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(invoiceService.getInvoiceProducts(invoiceId));
    }
    
    // Display List Of Invoices Particular Fields -invoice report
    @PostMapping("/Displaylistofinvoicesparticularfields")
    public List<InvoiceDTO3> getInvoices() {
        return invoiceService.getAllInvoices2();
    }
    
    // Display invoice some details based on invoiceid - PaymentBalance
    @PostMapping("/dispalybalanceamount/{invoiceId}")
    public ResponseEntity<InvoiceBalanceDTO> getInvoiceBalance(@PathVariable Long invoiceId) {
        InvoiceBalanceDTO invoiceBalance = invoiceService.getInvoiceBalanceById(invoiceId);
        
        if (invoiceBalance != null) {
            return ResponseEntity.ok(invoiceBalance);
        }
        return ResponseEntity.notFound().build();
    }

}

