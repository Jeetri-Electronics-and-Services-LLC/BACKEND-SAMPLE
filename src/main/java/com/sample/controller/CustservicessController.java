//package com.sample.controller;
//
//import com.sample.entity.Custservicess;
//import com.sample.service.CustservicessService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/custservicess")
//public class CustservicessController {
//
//    @Autowired
//    private CustservicessService custservicessService;
//
//    @GetMapping
//    public List<Custservicess> getAll() {
//        return custservicessService.getAll();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Custservicess> getById(@PathVariable Long id) {
//        return custservicessService.getById(id);
//    }
//
//    @PostMapping
//    public Custservicess create(@RequestBody Custservicess custservicess) {
//        return custservicessService.create(custservicess);
//    }
//
//    @PutMapping("/{id}")
//    public Custservicess update(@PathVariable Long id, @RequestBody Custservicess custservicess) {
//        return custservicessService.update(id, custservicess);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        custservicessService.delete(id);
//    }
//}




package com.sample.controller;

import com.sample.entity.CustservicessDTO;
import com.sample.entity.CustservicessResponseDTO;
import com.sample.entity.CustservicessResponseDTO1;
import com.sample.entity.CustserviceIdRequest;
import com.sample.entity.Custservicess;
import com.sample.service.CustservicessService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/custservicess")
public class CustservicessController {

    @Autowired
    private CustservicessService custservicessService;

 // POST API to Create a records
    @PostMapping("/adddataincustservicess&connectiondata")
    public Custservicess create(@RequestBody CustservicessDTO custservicessDTO) {
        return custservicessService.createFromDTO(custservicessDTO);
    }
    
 // POST API to fetch all records
    @PostMapping("/displayallcustservices&dataconnections")
    public List<CustservicessResponseDTO> getAllCustservicess() {
        return custservicessService.getAllAsDTO();
    }
    
    // POST API: Fetch custservicess by ID and include its connectiondetails
    @PostMapping("/getByIdcustservicess")
    public CustservicessResponseDTO1 getCustservicessById(@RequestBody CustserviceIdRequest request) {
        return custservicessService.getCustservicessById(request.getCustserviceId());
    }
}
