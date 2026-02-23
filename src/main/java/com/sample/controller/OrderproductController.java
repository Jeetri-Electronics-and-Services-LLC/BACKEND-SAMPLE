package com.sample.controller;

import com.sample.entity.Orderproduct;
import com.sample.service.OrderproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderproducts")
public class OrderproductController {

    @Autowired
    private OrderproductService orderproductService;

    @PostMapping("/add")
    public ResponseEntity<Orderproduct> addOrderproduct(@RequestBody Orderproduct orderproduct) {
        return ResponseEntity.ok(orderproductService.saveOrderproduct(orderproduct));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Orderproduct>> getAllOrderproducts() {
        return ResponseEntity.ok(orderproductService.getAllOrderproducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orderproduct> getOrderproductById(@PathVariable Long id) {
        Optional<Orderproduct> orderproduct = orderproductService.getOrderproductById(id);
        return orderproduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Orderproduct> updateOrderproduct(@PathVariable Long id, @RequestBody Orderproduct updatedOrderproduct) {
        Orderproduct updated = orderproductService.updateOrderproduct(id, updatedOrderproduct);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrderproduct(@PathVariable Long id) {
        boolean deleted = orderproductService.deleteOrderproduct(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
