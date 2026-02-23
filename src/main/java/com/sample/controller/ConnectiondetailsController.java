//package com.sample.controller;
//
//import com.sample.entity.Connectiondetails;
//import com.sample.service.ConnectiondetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/connectiondetails")
//public class ConnectiondetailsController {
//
//    @Autowired
//    private ConnectiondetailsService connectiondetailsService;
//
//    @GetMapping
//    public List<Connectiondetails> getAll() {
//        return connectiondetailsService.getAll();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Connectiondetails> getById(@PathVariable Long id) {
//        return connectiondetailsService.getById(id);
//    }
//
//    @PostMapping
//    public Connectiondetails create(@RequestBody Connectiondetails connectiondetails) {
//        return connectiondetailsService.create(connectiondetails);
//    }
//
//    @PutMapping("/{id}")
//    public Connectiondetails update(@PathVariable Long id, @RequestBody Connectiondetails connectiondetails) {
//        return connectiondetailsService.update(id, connectiondetails);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        connectiondetailsService.delete(id);
//    }
//}







package com.sample.controller;

import com.sample.entity.Connectiondetails;
import com.sample.service.ConnectiondetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/connectiondetails")
public class ConnectiondetailsController {

    @Autowired
    private ConnectiondetailsService connectiondetailsService;

    @GetMapping
    public List<Connectiondetails> getAll() {
        return connectiondetailsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Connectiondetails> getById(@PathVariable Long id) {
        return connectiondetailsService.getById(id);
    }

    @PostMapping
    public Connectiondetails create(@RequestBody Connectiondetails connectiondetails) {
        return connectiondetailsService.create(connectiondetails);
    }

    @PutMapping("/{id}")
    public Connectiondetails update(@PathVariable Long id, @RequestBody Connectiondetails connectiondetails) {
        return connectiondetailsService.update(id, connectiondetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        connectiondetailsService.delete(id);
    }
}
