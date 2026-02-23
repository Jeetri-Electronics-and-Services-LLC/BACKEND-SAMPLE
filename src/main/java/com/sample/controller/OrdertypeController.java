//package com.sample.controller;
//
//import com.sample.entity.Ordertype;
//import com.sample.service.OrdertypeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/ordertype")
//public class OrdertypeController {
//
//    @Autowired
//    private OrdertypeService ordertypeService;
//
//    // Create OrderType
//    @PostMapping("/create")
//    public ResponseEntity<Ordertype> createOrdertype(@RequestBody Ordertype ordertype) {
//        Ordertype createdOrdertype = ordertypeService.createOrdertype(ordertype);
//        return ResponseEntity.ok(createdOrdertype);
//    }
//
//    // Get all OrderTypes
//    @GetMapping("/ordertypelist")
//    public ResponseEntity<List<Ordertype>> getAllOrdertypes() {
//        List<Ordertype> ordertypes = ordertypeService.getAllOrdertypes();
//        return ResponseEntity.ok(ordertypes);
//    }
//
//    // Get OrderType by ID
//    @GetMapping("/fetchordertype/{id}")
//    public ResponseEntity<Ordertype> getOrdertypeById(@PathVariable int id) {
//        Optional<Ordertype> ordertype = ordertypeService.getOrdertypeById(id);
//        return ordertype.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // Update OrderType by ID
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Ordertype> updateOrdertype(@PathVariable int id, @RequestBody Ordertype ordertype) {
//        Ordertype updatedOrdertype = ordertypeService.updateOrdertype(id, ordertype);
//        if (updatedOrdertype != null) {
//            return ResponseEntity.ok(updatedOrdertype);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Delete OrderType by ID
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteOrdertype(@PathVariable int id) {
//        boolean deleted = ordertypeService.deleteOrdertype(id);
//        if (deleted) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}







package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Ordertype;
import com.sample.service.OrdertypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/ordertype")
public class OrdertypeController {

    @Autowired
    private OrdertypeService ordertypeService;

    // Create OrderType
    @PostMapping("/createorder")
    public ResponseEntity<Ordertype> createOrdertype(@RequestBody Ordertype ordertype) {
        Ordertype createdOrdertype = ordertypeService.createOrdertype(ordertype);
        return ResponseEntity.ok(createdOrdertype);
    }

    // Get all OrderTypes (using POST instead of GET)
    @PostMapping("/ordertypelist")
    public ResponseEntity<List<Ordertype>> getAllOrdertypes(@RequestBody(required = false) Map<String, Object> request) {
        List<Ordertype> ordertypes = ordertypeService.getAllOrdertypes();
        return ResponseEntity.ok(ordertypes);
    }
   
    // Get OrderType by ID (using POST and JSON request instead of GET and path variable)
    @PostMapping("/fetchordertypebyid")
    public ResponseEntity<Ordertype> getOrdertypeById(@RequestBody Map<String, Object> request) {
    	int id = Integer.parseInt(request.get("id").toString());

        return ordertypeService.getOrdertypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    // Update OrderType by ID (using POST and JSON request instead of PUT and path variable)
    @PostMapping("/updateOrdertype/{id}")
    public ResponseEntity<Ordertype> updateOrdertype(@PathVariable int id, @RequestBody Map<String, Object> request) {
    	String type = request.get("type").toString();
    	Ordertype existingOrdertype = ordertypeService.getOrdertypeById(id).orElse(null);
        if (existingOrdertype == null) {
            return ResponseEntity.notFound().build();
        }

        existingOrdertype.setType(type);
        Ordertype updatedOrdertype = ordertypeService.updateOrdertype(id, existingOrdertype);

        return ResponseEntity.ok(updatedOrdertype);
    }
    
    

    // Delete OrderType by ID (using POST and JSON request instead of DELETE and path variable)
    @PostMapping("/deleteordertype")
    public ResponseEntity<Void> deleteOrdertype(@RequestBody Map<String, Object> request) {
    	int id = Integer.parseInt(request.get("id").toString());
    	ordertypeService.deleteOrdertype(id);
          return ResponseEntity.noContent().build();
    }

   
}
