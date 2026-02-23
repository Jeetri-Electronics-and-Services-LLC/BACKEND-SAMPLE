package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.sample.entity.Salestaxbasedonstate;
import com.sample.service.SalestaxbasedonstateService;

@RestController
@RequestMapping("/salestaxbasedonstate")
public class SalestaxbasedonstateController {

    @Autowired
    private SalestaxbasedonstateService service;

    @GetMapping
    public List<Salestaxbasedonstate> getAllSalesTaxes() {
        return service.getAllSalesTaxes();
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<Salestaxbasedonstate> getSalestaxByState(@PathVariable String state) {
        Salestaxbasedonstate salestax = service.getSalestaxByState(state);
        return salestax != null ? ResponseEntity.ok(salestax) : ResponseEntity.notFound().build();
    }

    @PostMapping("/addSalestaxbasedonstate")
    public Salestaxbasedonstate saveSalestax(@RequestBody Salestaxbasedonstate salestax) {
        return service.saveSalestax(salestax);
    }

    @DeleteMapping("DELETESalestaxbasedonstate/{id}")
    public void deleteSalestax(@PathVariable Long id) {
        service.deleteSalestax(id);
    }
    
    //Display Salestax Based On Given State
    @PostMapping("/getSalestaxbasedongivenstate")
    public String getSalesTax(@RequestBody StateRequest stateRequest) {
        return service.getSalesTaxByState(stateRequest.getState());
    }

    // Request Body POJO for the state
    public static class StateRequest {
        private String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
