//package com.sample.controller;


//
//import com.sample.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/ordersinvoiceestimate")
//public class OrderController {
//
//    @Autowired
//    private OrderService orderService;
//    
//    @GetMapping("/basedonordertype/{ordertype}/{id}")
//    public ResponseEntity<?> getOrderDetails(
//            @PathVariable String ordertype, 
//            @PathVariable Long id) {
//        
//        return orderService.getOrderDetails(ordertype, id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//}





package com.sample.controller;

import com.sample.service.OrderService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ordersinvoiceestimate")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @PostMapping("/basedonordertype")
    public ResponseEntity<?> getOrderDetails(@RequestBody Map<String, Object> request) {
        // Extract ordertype and id from the JSON request body
        String ordertype = (String) request.get("ordertype");
        Long id = Long.valueOf(String.valueOf(request.get("id")));

        return orderService.getOrderDetails(ordertype, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
