//package com.sample.controller;
//
//
//import com.sample.entity.EstimateDTOs;
//import com.sample.entity.EstimateInvoiceResponseDTOes;
//
//import com.sample.service.EstimateInvoiceService;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/EstimateInvoice")
//public class EstimateInvoiceController {
//
//    @Autowired
//    private EstimateInvoiceService estimateInvoiceService;
//
////    @GetMapping("/estimateinvoicelists/{customerdisplayname}")
////    public EstimateInvoiceResponseDTOes getEstimatesAndInvoices(@PathVariable String customerdisplayname) {
////        return estimateInvoiceService.getEstimatesAndInvoicesByCustomerDisplayName(customerdisplayname);
////    }
////    
//    
//    @GetMapping("/estimateinvoicelists/{customerdisplayname}")
//    public List<Object> getEstimatesAndInvoices(@PathVariable String customerdisplayname) {
//        return estimateInvoiceService.getEstimatesAndInvoicesAsSingleList(customerdisplayname);
//    }
//    
//   
//
//   
//}









package com.sample.controller;

import com.sample.entity.EstimateInvoiceResponseDTOes;

import com.sample.service.EstimateInvoiceService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EstimateInvoice")
public class EstimateInvoiceController {

    @Autowired
    private EstimateInvoiceService estimateInvoiceService;


    
   

    @PostMapping("/estimateinvoicelists")
    public ResponseEntity<List<Object>> getEstimatesAndInvoices(@RequestBody Map<String, String> payload) {
    	String customerdisplayname = payload.get("customerdisplayname");
        List<Object> estimates = estimateInvoiceService.getEstimatesAndInvoicesAsSingleList(customerdisplayname);
        return new ResponseEntity<>(estimates, HttpStatus.OK);
    	
    	
       
    }
}

